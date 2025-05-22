package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserService {

     public String signUp(String usernameText, String namaText, String handphoneText, String emailText, String passwordText, String ulangiPasswordText) {
        if (usernameText.isEmpty() || namaText.isEmpty() || handphoneText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty() || ulangiPasswordText.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        if (!passwordText.equals(ulangiPasswordText)) {
            return "Password dan Ulangi Password tidak cocok!";
        }

        String date = java.time.LocalDate.now().toString();
        String time = java.time.LocalTime.now().toString();

        boolean success = createUser(usernameText, namaText, handphoneText, emailText, passwordText, date, time);
        return success ? "success" : "Gagal membuat akun. Silakan coba lagi.";
    }

    private boolean createUser(String username, String nama, String handphone, String email, String password, String date, String time) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO users (username, nama, handphone, email, password, date, time) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, nama);
            stmt.setString(3, handphone);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.setString(6, date);
            stmt.setString(7, time);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
            return false;
        }
    }
    
    
     // Method login ditambahkan di bawah sini
    public String login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return "Username dan password tidak boleh kosong!";
        }

        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
             // Ambil nama dari hasil query
            String nama = rs.getString("nama");

            // Update kolom session di tabel config
            String updateSessionSQL = "UPDATE config SET session = ? WHERE id = 1";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSessionSQL)) {
                updateStmt.setString(1, nama);
                updateStmt.executeUpdate();
            }
                return "success";
            } else {
                return "Username atau password salah!";
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return "Terjadi kesalahan saat login.";
        }
    }
    
    public static String getSession() {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT session FROM config WHERE id = 1";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("session");
        } else {
            return null; // Tidak ditemukan data dengan id = 1
        }
    } catch (SQLException e) {
        System.err.println("Error getting session: " + e.getMessage());
        return null;
    }
}

}
