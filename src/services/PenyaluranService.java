package services;

import db.DBConnection;
import helper.Function;
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
            String sql = "SELECT umur, alamat, golongan, jenis_kelamin FROM mustahiq WHERE nama = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int umur = rs.getInt("umur");
                String alamat = rs.getString("alamat");
                String golongan = rs.getString("golongan");
                String gender = rs.getString("jenis_kelamin");
                return new MustahiqData(umur, alamat, golongan, gender);
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
        private String gender;

        public MustahiqData(int umur, String alamat, String golongan, String gender) {
            this.umur = umur;
            this.alamat = alamat;
            this.golongan = golongan;
            this.gender = gender;
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
        
         public String getGender() {
            return gender;
        }
    }
    
    public String buatPenyaluran(String nama_mustahiq, String golongan, int umur, String jenis_kelamin, String alamat, String jumlah_disalurkan, String amil, String toString, String toString1) {
    jumlah_disalurkan = jumlah_disalurkan.replaceAll("[^0-9.]", "");
    if (nama_mustahiq.isEmpty() || golongan.isEmpty() || jenis_kelamin.isEmpty()|| alamat.isEmpty()|| jumlah_disalurkan.isEmpty()|| amil.isEmpty()) {
       return "Semua field wajib diisi!";
    }
    double double_jumlahDisalurkan = Double.parseDouble((String) jumlah_disalurkan);
    if (umur < 1 || double_jumlahDisalurkan < 1) {
       return "Umur atau jumlah total disalurkan tidak boleh kurang dari 1!";
    }
   
    String date = Function.getCurrentDate();
    String time = Function.getCurrentTime();
    
     boolean success = createPenyaluran(nama_mustahiq, golongan, umur, jenis_kelamin, alamat,
                                        double_jumlahDisalurkan, amil, date, time);
     return success ? "success" : "Gagal menyimpan data penyaluran. Silakan coba lagi.";
}

private boolean createPenyaluran(String nama_mustahiq, String golongan, int umur,String jenis_kelamin, String alamat,
                                 double jumlah_disalurkan, String amil,
                                 String tanggal, String waktu) {
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO penyaluran (nama_mustahiq, golongan, umur, jenis_kelamin, alamat, jumlah_disalurkan, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nama_mustahiq);
        stmt.setString(2, golongan);
        stmt.setInt(3, umur);
        stmt.setString(4, jenis_kelamin);
        stmt.setString(5, alamat);
        stmt.setDouble(6, jumlah_disalurkan);
        stmt.setString(7, amil);
        stmt.setString(8, tanggal);
        stmt.setString(9, waktu);

        int rowsAffected = stmt.executeUpdate();
         // Jika insert berhasil, lakukan update ke tabel total
        if (rowsAffected > 0) {
            String updateSql = "";
            updateSql = "UPDATE total SET beras = beras - ?";
           
            if (!updateSql.isEmpty()) {
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setDouble(1, jumlah_disalurkan);
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
    
}
