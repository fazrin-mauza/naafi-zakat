package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
        // Fungsi tambahan untuk mengambil nilai session dari tabel config
    public static String getSession() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT session FROM config WHERE id = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("session");
            } else {
                return "Tidak ditemukan";
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return "Error";
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
}
