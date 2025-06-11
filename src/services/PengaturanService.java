package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PengaturanService {
    
    public String getHargaEmas() {
    String sql = "SELECT harga_emas_85gram FROM config WHERE id = 1";
    Connection conn2 = DBConnection.getConnection();

    try {
        PreparedStatement stmt = conn2.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("harga_emas_85gram");
        } else {
            return "0";
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil harga emas: " + e.getMessage());
        return "0";
    }
    
}


     public String emasUpdate(String emas) {
        if (emas.isEmpty()) {
            return "Harga tidak valid!";
        }

        boolean success = updateEmas(emas);
        return success ? "success" : "Gagal mengupdate data harga Emas. Silakan coba lagi.";
    }

    private boolean updateEmas(String emas) {
        Connection conn = DBConnection.getConnection();
        String updateEmas = "UPDATE config SET harga_emas_85gram=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateEmas)) {
                stmt.setString(1, emas);
                stmt.setInt(2, 1);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga emas: " + e.getMessage());
            return false;
        }
    }
      public static boolean updateHargakMakananPokok(String harga) {
        Connection conn = DBConnection.getConnection();
        double harga_kg = Double.parseDouble(harga);
        String updateHarga = "UPDATE lembaga SET harga_kg=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateHarga)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
                stmt.setDouble(1, harga_kg);    
                stmt.setString(2, data.get("nama_masjid"));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga Makanan Pokok: " + e.getMessage());
            return false;
        }
    }
         public static boolean updateHargakSha(String harga) {
        Connection conn = DBConnection.getConnection();
        double harga_kg = Double.parseDouble(harga);
        String updateHarga = "UPDATE lembaga SET harga=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateHarga)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
                stmt.setDouble(1, harga_kg);    
                stmt.setString(2, data.get("nama_masjid"));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga Sha: " + e.getMessage());
            return false;
        }
    }
   
    
public static Map<String, Double> getPembagian() {
    Map<String, Double> pembagianData = new HashMap<>();
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT Fakir, Miskin, Amil, Muallaf, Riqab, Gharim, Fii_Sabilillah, Ibnu_Sabil FROM pembagian WHERE id = ?";
    
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        //Map<String, String> data = helper.Function.getSessionAndMasjid();
        ps.setInt(1, 1);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                pembagianData.put("Fakir", rs.getDouble("Fakir"));
                pembagianData.put("Miskin", rs.getDouble("Miskin"));
                pembagianData.put("Amil", rs.getDouble("Amil"));
                pembagianData.put("Muallaf", rs.getDouble("Muallaf"));
                pembagianData.put("Riqab", rs.getDouble("Riqab"));
                pembagianData.put("Gharim", rs.getDouble("Gharim"));
                pembagianData.put("Fii_Sabilillah", rs.getDouble("Fii_Sabilillah"));
                pembagianData.put("Ibnu_Sabil", rs.getDouble("Ibnu_Sabil"));
            }
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil data pembagian: " + e.getMessage());
    }

    return pembagianData;
}

public static boolean updatePembagian(Map<String, Double> dataPembagian) {
    Connection conn = DBConnection.getConnection();
    String sql = "UPDATE pembagian SET Fakir = ?, Miskin = ?, Amil = ?, Muallaf = ?, Riqab = ?, Gharim = ?, Fii_Sabilillah = ?, Ibnu_Sabil = ? WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setDouble(1, dataPembagian.getOrDefault("Fakir", 0.0));
        ps.setDouble(2, dataPembagian.getOrDefault("Miskin", 0.0));
        ps.setDouble(3, dataPembagian.getOrDefault("Amil", 0.0));
        ps.setDouble(4, dataPembagian.getOrDefault("Muallaf", 0.0));
        ps.setDouble(5, dataPembagian.getOrDefault("Riqab", 0.0));
        ps.setDouble(6, dataPembagian.getOrDefault("Gharim", 0.0));
        ps.setDouble(7, dataPembagian.getOrDefault("Fii_Sabilillah", 0.0));
        ps.setDouble(8, dataPembagian.getOrDefault("Ibnu_Sabil", 0.0));
        ps.setInt(9, 1); // ID yang diupdate, bisa diganti parameter kalau dinamis

        int affectedRows = ps.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        System.err.println("Gagal mengupdate data pembagian: " + e.getMessage());
    }

    return false;
}


}
