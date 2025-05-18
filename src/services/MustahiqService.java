package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MustahiqService {

    public void loadDataMustahiq(DefaultTableModel tableModel) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT nama, golongan, umur, alamat, handphone FROM mustahiq";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Hapus semua data dulu sebelum load baru
            tableModel.setRowCount(0);

            while (rs.next()) {
                String nama = rs.getString("nama");
                String kategori = rs.getString("golongan");
                int umur = rs.getInt("umur");
                String alamat = rs.getString("alamat");
                String handphone = rs.getString("handphone");
                

                tableModel.addRow(new Object[]{nama, kategori, umur, alamat,handphone});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean deleteMustahiq(String namaMustahiq) {
    Connection conn = DBConnection.getConnection();
    try {
        conn.setAutoCommit(false); // Mulai transaksi

        // Hapus semua anggota keluarga berdasarkan nama keluarga
        String sqlMustahiq = "DELETE FROM mustahiq WHERE nama = ?";
        try (PreparedStatement ps1 = conn.prepareStatement(sqlMustahiq)) {
            ps1.setString(1, namaMustahiq.toUpperCase());
            ps1.executeUpdate();
        }

        conn.commit(); // Sukses semua, simpan perubahan
        return true;
    } catch (SQLException e) {
        System.err.println("Error saat menghapus mustahiq: " + e.getMessage());
        try { conn.rollback(); } catch (SQLException rollbackError) {
            System.err.println("Gagal rollback: " + rollbackError.getMessage());
        }
        return false;
    } finally {
        try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
    }
}
}
