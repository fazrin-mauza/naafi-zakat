package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BerandaService {
    // Fungsi utama untuk mengambil data beranda
    public static BerandaData getBerandaData() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT beras, tunai FROM total WHERE id = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double beras = rs.getDouble("beras");
                double uangTunai = rs.getDouble("tunai");
                return new BerandaData(beras, uangTunai);
            } else {
                return new BerandaData(0, 0); // Default jika tidak ada data
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    } 
    
  
    // Inner class untuk menyimpan data beranda
    public static class BerandaData {
        private double beras;
        private double uangTunai;

        public BerandaData(double beras, double uangTunai) {
            this.beras = beras;
            this.uangTunai = uangTunai;
        }

        public double getBeras() {
            return beras;
        }

        public void setBeras(double beras) {
            this.beras = beras;
        }

        public double getUangTunai() {
            return uangTunai;
        }

        public void setUangTunai(double uangTunai) {
            this.uangTunai = uangTunai;
        }
    }
    
    
     // Fungsi tambahan untuk mengambil nilai session dan nama masjid dari tabel config
 public static Map<String, String> getSessionAndMasjid() {
    Map<String, String> result = new HashMap<>();
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT session, nama_masjid FROM config WHERE id = 1";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            result.put("session", rs.getString("session"));
            result.put("nama_masjid", rs.getString("nama_masjid"));
        }
    } catch (SQLException e) {
        System.err.println("Error getting session and masjid: " + e.getMessage());
    }

    return result;
}

    
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
    // jangan tutup koneksi jika pakai singleton
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
     public static String getNamaMasjid() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT nama_masjid FROM config WHERE id = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("nama_masjid");
            } else {
                return "Tidak ditemukan";
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return "Error";
        }
     }
}
