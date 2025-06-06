package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
