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
            ps2.setString(1, namaKepala); // bisa diganti id jika sudah relasi foreign key
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


   
   public boolean insertPembayaran(String namaKeluarga, int jumlahAnggota, String jenisZakat, 
                                    String jenisPembayaran, double totalPembayaran, String amil, 
                                    String tanggal, String waktu) {
        String sql = "INSERT INTO pembayaran (nama_keluarga, jumlah_anggota, jenis_zakat, jenis_pembayaran, total_pembayaran, amil, date, time) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, namaKeluarga);
            stmt.setInt(2, jumlahAnggota);
            stmt.setString(3, jenisZakat);
            stmt.setString(4, jenisPembayaran);
            stmt.setDouble(5, totalPembayaran);
            stmt.setString(6, amil);
            stmt.setString(7, tanggal); // Format: yyyy-MM-dd
            stmt.setString(8, waktu);   // Format: HH:mm:ss

            int rows = stmt.executeUpdate();
            stmt.close();
            conn.close();
            return rows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error insert pembayaran: " + e.getMessage());
            return false;
        }
    } 


public boolean buatPembayaran(String namaKeluarga, int jumlahAnggota, String jenisZakat, String jenisPembayaran, double totalPembayaran, String amil, String toString, String toString1) {
    if (namaKeluarga.isEmpty() || jenisZakat.isEmpty() || jenisPembayaran.isEmpty() || amil.isEmpty()) {
        return false;
    }

    if (jumlahAnggota <= 0 || totalPembayaran <= 0) {
        return false;
    }

    String date = java.time.LocalDate.now().toString();
    String time = java.time.LocalTime.now().toString();

    return createPembayaran(namaKeluarga, jumlahAnggota, jenisZakat,
                            jenisPembayaran, totalPembayaran, amil, date, time);
}

private boolean createPembayaran(String namaKeluarga, int jumlahAnggota, String jenisZakat,
                                 String jenisPembayaran, double totalPembayaran, String amil,
                                 String tanggal, String waktu) {
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO pembayaran (nama_keluarga, jumlah_anggota, jenis_zakat, jenis_pembayaran, total_pembayaran, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, namaKeluarga);
        stmt.setInt(2, jumlahAnggota);
        stmt.setString(3, jenisZakat);
        stmt.setString(4, jenisPembayaran);
        stmt.setDouble(5, totalPembayaran);
        stmt.setString(6, amil);
        stmt.setString(7, tanggal);
        stmt.setString(8, waktu);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("Error creating pembayaran: " + e.getMessage());
        return false;
    }
}

     
}
