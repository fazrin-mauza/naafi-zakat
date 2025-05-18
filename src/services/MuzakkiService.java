package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MuzakkiService {

    public void loadKeluargaData(DefaultTableModel tableModel) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT nama, jumlah, alamat, handphone FROM keluarga";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Hapus semua data dulu sebelum load baru
            tableModel.setRowCount(0);

            while (rs.next()) {
                String nama = rs.getString("nama");
                int jumlah = rs.getInt("jumlah");
                String alamat = rs.getString("alamat");
                String handphone = rs.getString("handphone");

                tableModel.addRow(new Object[]{nama, jumlah, alamat, handphone});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean deleteKeluargaDanAnggota(String namaKeluarga) {
    Connection conn = DBConnection.getConnection();
    try {
        conn.setAutoCommit(false); // Mulai transaksi

        // Hapus semua anggota keluarga berdasarkan nama keluarga
        String sqlAnggota = "DELETE FROM anggota_keluarga WHERE keluarga = ?";
        try (PreparedStatement ps1 = conn.prepareStatement(sqlAnggota)) {
            ps1.setString(1, namaKeluarga.toUpperCase());
            ps1.executeUpdate();
        }

        // Hapus keluarga berdasarkan nama
        String sqlKeluarga = "DELETE FROM keluarga WHERE nama = ?";
        try (PreparedStatement ps2 = conn.prepareStatement(sqlKeluarga)) {
            ps2.setString(1, namaKeluarga.toUpperCase());
            ps2.executeUpdate();
        }

        conn.commit(); // Sukses semua, simpan perubahan
        return true;
    } catch (SQLException e) {
        System.err.println("Error saat menghapus keluarga dan anggota: " + e.getMessage());
        try { conn.rollback(); } catch (SQLException rollbackError) {
            System.err.println("Gagal rollback: " + rollbackError.getMessage());
        }
        return false;
    } finally {
        try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
    }
}

}
