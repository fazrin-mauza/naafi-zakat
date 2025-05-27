
package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaporanService {
    public static String emptyTabelPembayaran() {
    String sql = "DELETE FROM pembayaran";
    Connection conn = (Connection) DBConnection.getConnection();

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        int rows = stmt.executeUpdate();

        return rows > 0 ? "Data pembayaran berhasil dikosongkan." : "Tabel pembayaran sudah kosong.";
    } catch (SQLException e) {
        System.err.println("Gagal mengosongkan tabel pembayaran: " + e.getMessage());
        return "Gagal mengosongkan data pembayaran.";
    }
    // tidak ditutup karena pakai singleton
}
    public static String emptyTabelPenyaluran() {
    String sql = "DELETE FROM penyaluran";
    Connection conn = (Connection) DBConnection.getConnection();

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        int rows = stmt.executeUpdate();

        return rows > 0 ? "Data penyaluran berhasil dikosongkan." : "Tabel penyaluran sudah kosong.";
    } catch (SQLException e) {
        System.err.println("Gagal mengosongkan tabel pembayaran: " + e.getMessage());
        return "Gagal mengosongkan data pembayaran.";
    }
    // tidak ditutup karena pakai singleton
}

}
