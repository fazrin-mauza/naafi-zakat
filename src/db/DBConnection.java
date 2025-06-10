package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:zakat.db";
    private static Connection conn = null;
    private static int koneksiCounter = 0;

public static synchronized Connection getConnection() {
    try {
        if (conn == null || conn.isClosed()) {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
            koneksiCounter++;
           System.out.print("\rKoneksi berhasil ke zakat.db (" + koneksiCounter + ")    ");
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println("Koneksi gagal: " + e.getMessage());
        conn = null;
    }
    return conn;
}


    public static synchronized void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi: " + e.getMessage());
        } finally {
            conn = null;
        }
    }
}
