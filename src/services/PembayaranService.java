package services;

import db.DBConnection;
//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PembayaranService {
    
public static List<String> getDaftarKepalaKeluarga() {
    List<String> daftarNama = new ArrayList<>();
    try {
        Connection con = DBConnection.getConnection();
        String sql = """
            SELECT nama FROM keluarga 
            WHERE nama NOT IN (SELECT nama_keluarga FROM pembayaran)
            """;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            daftarNama.add(rs.getString("nama"));
        }

        rs.close();
        ps.close();
    } catch (Exception e) {
        System.err.println("Gagal memuat data keluarga: " + e.getMessage());
    }

    return daftarNama;
}

   public Map<String, Object> getDetailKeluarga(String namaKepala) {
        Map<String, Object> result = new HashMap<>();

    Connection con = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
        
        try {
             con = DBConnection.getConnection();

            // Ambil data dari keluarga
            String sql1 = "SELECT * FROM keluarga WHERE nama = ?";
            ps1 = con.prepareStatement(sql1);
            ps1.setString(1, namaKepala);
            rs1 = ps1.executeQuery();
            String alamatLengkap = "RT "+rs1.getString("rt")+" / RW "+rs1.getString("rw")+rs1.getString("alamat");

            if (rs1.next()) {
                result.put("status", rs1.getString("status"));
                result.put("alamat", rs1.getString("alamat"));
                result.put("id", rs1.getInt("id"));
            }

            rs1.close();
            ps1.close();

            // Ambil data anggota keluarga
            String sql2 = "SELECT * FROM anggota_keluarga WHERE keluarga = ?";
            ps2 = con.prepareStatement(sql2);
            ps2.setString(1, namaKepala);
            rs2 = ps2.executeQuery();

            List<Object[]> anggota = new ArrayList<>();
            int jumlahAnggota = 0;
            String namaKepalaKeluarga = namaKepala;
            while (rs2.next()) {
                anggota.add(new Object[]{
                    rs2.getString("nama"),
                    rs2.getString("status")
                });
                 jumlahAnggota++;
            }
            
            result.put("anggota", anggota);
            result.put("jumlahAnggota", anggota.size());
            result.put("namaKepalaKeluarga", namaKepalaKeluarga);
            
            rs2.close();
            ps2.close();

        } catch (Exception e) {
            result.put("error", e.getMessage());
        } 

        return result;
    }


public boolean buatPembayaran(String namaKeluarga, String alamatText,int jumlahAnggota, String jenisZakat, String jenisPembayaran, double totalPembayaran, String amil, String tanggal, String waktu) {
    if (namaKeluarga.isEmpty() || jenisZakat.isEmpty() || jenisPembayaran.isEmpty() || amil.isEmpty()) {
        return false;
    }

    if (jumlahAnggota <= 0 || totalPembayaran <= 0) {
        return false;
    }

    return createPembayaran(namaKeluarga, alamatText, jumlahAnggota, jenisZakat,
                            jenisPembayaran, totalPembayaran, amil, tanggal, waktu);
}

private boolean createPembayaran(String namaKeluarga, String alamatText, int jumlahAnggota, String jenisZakat,
                                 String jenisPembayaran, double totalPembayaran, String amil,
                                 String tanggal, String waktu) {
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO pembayaran (nama_keluarga, alamat, jumlah_anggota, jenis_zakat, jenis_pembayaran, total_pembayaran, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, namaKeluarga);
        stmt.setString(2, alamatText);
        stmt.setInt(3, jumlahAnggota);
        stmt.setString(4, jenisZakat);
        stmt.setString(5, jenisPembayaran);
        stmt.setDouble(6, totalPembayaran);
        stmt.setString(7, amil);
        stmt.setString(8, tanggal);
        stmt.setString(9, waktu);

        int rowsAffected = stmt.executeUpdate();
        
       // Jika insert berhasil, lakukan update ke tabel total
        if (rowsAffected > 0) {
            String updateSql = "";

            if (jenisPembayaran.equalsIgnoreCase("Beras")) {
                updateSql = "UPDATE total SET beras = beras + ?";
            } else if (jenisPembayaran.equalsIgnoreCase("Uang Tunai")) {
                updateSql = "UPDATE total SET tunai = tunai + ?";
            }

            if (!updateSql.isEmpty()) {
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setDouble(1, totalPembayaran);
                    updateStmt.executeUpdate();
                }
            }
        }
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("Error creating pembayaran: " + e.getMessage());
        return false;
    }
}

 public static String hitungZakatMaal(double pendapatan) {
        double hargaEmas = 0;
        String sql = "SELECT harga_emas_85gram FROM config WHERE id = 1";

        Connection conn = DBConnection.getConnection(); // koneksi tunggal
        if (conn == null) {
            return "Koneksi DB gagal";
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                hargaEmas = rs.getDouble("harga_emas_85gram");
            }

            rs.close();
            stmt.close();

            if (pendapatan >= hargaEmas) {
                double zakat = pendapatan * 0.025;
                return String.format("%.2f", zakat);
            } else {
                return "Belum Mencapai Nisab";
            }

        } catch (SQLException e) {
            System.err.println("Gagal menghitung zakat: " + e.getMessage());
            return "Error DB";
        }
    }
     
}
