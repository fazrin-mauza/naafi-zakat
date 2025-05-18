package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MustahiqCreateService {

    public String mustahiqCreate(String nama, String kategori, int umur, String alamat, String nomorhandphone) {
        // Validasi input
        if (nama.isEmpty() || kategori.isEmpty() || alamat.isEmpty() || nomorhandphone.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        // Ubah semua input jadi huruf besar (kecuali umur)
        nama = nama.toUpperCase();
        kategori = kategori.toUpperCase();
        alamat = alamat.toUpperCase();

        // Cek apakah mustahiq dengan nama dan nomor HP sudah terdaftar
        if (isMustahiqExist(nama, nomorhandphone)) {
            return "Data Mustahiq dengan nama tersebut dan nomor handphone sudah terdaftar.";
        }

        boolean success = insertMustahiq(nama, kategori, umur, alamat, nomorhandphone);
        return success ? "success" : "Gagal menyimpan data mustahiq. Silakan coba lagi.";
    }

    private boolean insertMustahiq(String nama, String golongan, int umur, String alamat, String nomorhandphone) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO mustahiq (nama, golongan, umur, alamat, handphone) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setString(2, golongan);
            stmt.setInt(3, umur);
            stmt.setString(4, alamat);
            stmt.setString(5, nomorhandphone);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error insert mustahiq: " + e.getMessage());
            return false;
        }
    }
    
    
     public String mustahiqUpdate(String nama, String golongan, int umur, String alamat, String handphone, String namaLama) {
        // Validasi input
        if (nama.isEmpty() || golongan.isEmpty() || alamat.isEmpty() || handphone.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        nama = nama.toUpperCase();
        golongan = golongan.toUpperCase();
        alamat = alamat.toUpperCase();


        boolean success = updateMustahiq(nama, golongan, umur, alamat, handphone, namaLama);
        return success ? "success" : "Gagal mengupdate data mustahiq. Silakan coba lagi.";
    }

    private boolean updateMustahiq(String nama, String golongan, int umur, String alamat, String handphone, String namaLama) {
        Connection conn = DBConnection.getConnection();
       String sql = "UPDATE mustahiq SET nama=?, golongan=?, umur=?, alamat=?, handphone=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nama);
                stmt.setString(2, golongan);
                stmt.setInt(3, umur);
                stmt.setString(4, alamat);
                stmt.setString(5, handphone);
                stmt.setString(6, namaLama);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error insert mustahiq: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    private boolean isMustahiqExist(String nama, String handphone) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM mustahiq WHERE UPPER(nama) = ? AND UPPER(handphone) = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setString(2, handphone);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking mustahiq: " + e.getMessage());
        }
        return false;
    }
}
