
package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WilayahService {
    
     public static List<String> getAllProvinsi() {
        List<String> provinsiList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT name FROM provinces ORDER BY name";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                provinsiList.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinsiList;
    } 

    public static List<String> getAllKabupatenByProvinsiName(String provinsiName) {
    List<String> kabupatenList = new ArrayList<>();
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT r.name FROM regencies r "
                   + "JOIN provinces p ON r.province_code = p.code "
                   + "WHERE p.name = ? ORDER BY r.name";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, provinsiName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    kabupatenList.add(rs.getString("name"));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try { conn.close(); } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    return kabupatenList;
}

public static List<String> getAllKecamatanByKabupatenName(String kabupatenName) {
    List<String> kecamatanList = new ArrayList<>();
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT d.name FROM districts d " +
                     "JOIN regencies r ON d.regency_code = r.code " +
                     "WHERE r.name = ? ORDER BY d.name";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kabupatenName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    kecamatanList.add(rs.getString("name"));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return kecamatanList;
}

     public static List<String> getAllDesaByKecamatanName(String kecamatanName) {
    List<String> desaList = new ArrayList<>();
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT v.name FROM villages v " +
                     "JOIN districts d ON v.district_code = d.code " +
                     "WHERE d.name = ? ORDER BY v.name";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kecamatanName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    desaList.add(rs.getString("name"));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try { conn.close(); } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    return desaList;
}

    public static boolean insertLembaga(
    String nama,
    String makanan_pokok,
    double sha,
    double harga,  
    String cakupan,
    String provinsi,
    String kabupaten,
    String kecamatan,
    String desa) {
    double harga_kg = harga / sha;
    Connection conn = DBConnection.getConnection();
    String insertSQL = "INSERT INTO lembaga (nama, makanan_pokok, sha, harga, cakupan, provinsi, kabupaten, kecamatan, desa, harga_kg) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
        stmt.setString(1, nama);
        stmt.setString(2, makanan_pokok);
        stmt.setDouble(3, sha);
        stmt.setDouble(4, harga);
        stmt.setString(5, cakupan);
        stmt.setString(6, provinsi);
        stmt.setString(7, kabupaten);
        stmt.setString(8, kecamatan);
        stmt.setString(9, desa);
        stmt.setDouble(10, harga_kg);
        
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        System.err.println("Error insert lembaga: " + e.getMessage());
        return false;
    }
}

    public static Map<String, String> getWilayah() {
        Map<String, String> wilayahData = new HashMap<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT nama, cakupan, provinsi, kabupaten, kecamatan, desa FROM lembaga WHERE nama = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
           ps.setString(1, data.get("nama_masjid"));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    wilayahData.put("nama", rs.getString("nama"));
                    wilayahData.put("cakupan", rs.getString("cakupan"));
                    wilayahData.put("provinsi", rs.getString("provinsi"));
                    wilayahData.put("kabupaten", rs.getString("kabupaten"));
                    wilayahData.put("kecamatan", rs.getString("kecamatan"));
                    wilayahData.put("desa", rs.getString("desa"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data wilayah: " + e.getMessage());
        }
        return wilayahData;
    }
     
  public static Map<String, String> getMakananPokok() {
    Map<String, String> makananData = new HashMap<>();
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT makanan_pokok, sha, harga, harga_kg FROM lembaga WHERE nama = ?";
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        Map<String, String> data = helper.Function.getSessionAndMasjid();
        ps.setString(1, data.get("nama_masjid"));
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                makananData.put("makanan_pokok", rs.getString("makanan_pokok"));
                makananData.put("sha", rs.getString("sha"));
                makananData.put("harga", rs.getString("harga"));
                makananData.put("harga_kg", rs.getString("harga_kg"));
            }
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil data makanan pokok: " + e.getMessage());
    }
    
    return makananData;
}

}
