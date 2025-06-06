package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserService {

     public String signUp(String usernameText, String namaText, String handphoneText, String masjidText, String passwordText, String ulangiPasswordText) {
        if (usernameText.isEmpty() || namaText.isEmpty() || handphoneText.isEmpty() || masjidText.isEmpty() || passwordText.isEmpty() || ulangiPasswordText.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        if (!passwordText.equals(ulangiPasswordText)) {
            return "Password dan Ulangi Password tidak cocok!";
        }

        String date = java.time.LocalDate.now().toString();
        String time = java.time.LocalTime.now().toString();

        boolean success = createUser(usernameText, namaText, handphoneText, masjidText, passwordText, date, time);
        return success ? "success" : "Gagal membuat akun. Silakan coba lagi.";
    }

    private boolean createUser(String username, String nama, String handphone, String masjid, String password, String date, String time) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO users (username, nama, handphone, masjid, password, date, time) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, nama);
            stmt.setString(3, handphone);
            stmt.setString(4, masjid);
            stmt.setString(5, password);
            stmt.setString(6, date);
            stmt.setString(7, time);

            int rowsAffected = stmt.executeUpdate();;
        if (rowsAffected > 0) {
            updateConfig(nama, masjid);
            return rowsAffected > 0;
        } else {
            return false;
        }
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
            String masjid = rs.getString("masjid");

            // Update kolom session & nama_masjid di tabel config
            updateConfig(nama, masjid);
           /** String updateSessionSQL = "UPDATE config SET session = ?,nama_masjid = ? WHERE id = 1";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSessionSQL)) {
                updateStmt.setString(1, nama);
                updateStmt.setString(2, masjid);
                updateStmt.executeUpdate();
            } */
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
 public static List<String> getNamaMasjidList() {
    List<String> namaMasjidList = new ArrayList<>();
    
    // Tambahkan opsi kosong di paling atas
    namaMasjidList.add(""); 

    Connection conn = DBConnection.getConnection();
    String sql = "SELECT DISTINCT masjid FROM users WHERE masjid IS NOT NULL ORDER BY masjid ASC";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            namaMasjidList.add(rs.getString("masjid"));
        }

    } catch (SQLException e) {
        System.err.println("Error getting list of nama masjid: " + e.getMessage());
    }

    return namaMasjidList;
}
 /** public static boolean updateMasjid(String nama_masjid) {
        Connection conn = DBConnection.getConnection();
        String updateMasjid = "UPDATE config SET nama_masjid=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateMasjid)) {
                stmt.setString(1, nama_masjid);
                stmt.setInt(2, 1);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update nama masjid: " + e.getMessage());
            return false;
        }
    } */
   public static boolean updateConfig(String Session, String nama_masjid) {
        Connection conn = DBConnection.getConnection();
        // Update kolom session di tabel config
            String updateConfigSQL = "UPDATE config SET session = ?,nama_masjid = ? WHERE id = 1";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateConfigSQL)) {
                updateStmt.setString(1, Session);
                updateStmt.setString(2, nama_masjid);
                updateStmt.executeUpdate();
        int rowsAffected = updateStmt.executeUpdate();
        return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update nama masjid: " + e.getMessage());
            return false;
        }
    }

}
