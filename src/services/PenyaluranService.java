package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PenyaluranService {

        public List<String> getNamaMustahiq() {
        List<String> mustahiqList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT nama FROM mustahiq";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                mustahiqList.add(rs.getString("nama"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mustahiqList;
    }
        
    public MustahiqData getDetailMustahiqByNama(String nama) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT umur, alamat, golongan FROM mustahiq WHERE nama = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int umur = rs.getInt("umur");
                String alamat = rs.getString("alamat");
                String golongan = rs.getString("golongan");
                return new MustahiqData(umur, alamat, golongan);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Inner class untuk menyimpan data Mustahiq
    public static class MustahiqData {
        private int umur;
        private String alamat;
        private String golongan;

        public MustahiqData(int umur, String alamat, String golongan) {
            this.umur = umur;
            this.alamat = alamat;
            this.golongan = golongan;
        }

        public int getUmur() {
            return umur;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getGolongan() {
            return golongan;
        }
    }
    
    public String buatPenyaluran(String nama_mustahiq, String golongan, int umur, String jumlah_disalurkan, String amil, String toString, String toString1) {
    jumlah_disalurkan = jumlah_disalurkan.replaceAll("[^0-9.]", "");
    if (nama_mustahiq.isEmpty() || golongan.isEmpty() || jumlah_disalurkan.isEmpty()|| amil.isEmpty()) {
       return "Semua field wajib diisi!";
    }
    double double_jumlahDisalurkan = Double.parseDouble((String) jumlah_disalurkan);
    if (umur < 1 || double_jumlahDisalurkan < 1) {
       return "Umur atau jumlah total disalurkan tidak boleh kurang dari 1!";
    }
   
    String date = java.time.LocalDate.now().toString();
    String time = java.time.LocalTime.now().toString();

     boolean success = createPenyaluran(nama_mustahiq, golongan, umur,
                                        double_jumlahDisalurkan, amil, date, time);
     return success ? "success" : "Gagal menyimpan data penyaluran. Silakan coba lagi.";
}

private boolean createPenyaluran(String nama_mustahiq, String golongan, int umur,
                                 double jumlah_disalurkan, String amil,
                                 String tanggal, String waktu) {
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO penyaluran (nama_mustahiq, golongan, umur, jumlah_disalurkan, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nama_mustahiq);
        stmt.setString(2, golongan);
        stmt.setInt(3, umur);
        stmt.setDouble(4, jumlah_disalurkan);
        stmt.setString(5, amil);
        stmt.setString(6, tanggal);
        stmt.setString(7, waktu);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("Error creating pembayaran: " + e.getMessage());
        return false;
    }
}
    
}
