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
}
