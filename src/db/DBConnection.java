/**package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:zakat.db";
   private static final String URL;////////
static {
    String dbPath;
    try {
        String jarDir = new java.io.File(DBConnection.class
            .getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .toURI())
            .getParent();
        dbPath = jarDir + java.io.File.separator + "zakat.db";
    } catch (Exception e) {
        dbPath = "zakat.db"; // fallback jika gagal
    }
    URL = "jdbc:sqlite:" + dbPath;
}
////////
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
*/

//// Multi

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:zakat.db?journal_mode=WAL&synchronous=NORMAL";
    private static int koneksiCounter = 0;

    public static Connection getConnection() {
        Connection localConn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            localConn = DriverManager.getConnection(URL);
            koneksiCounter++;
            System.out.print("\rKoneksi berhasil ke zakat.db (" + koneksiCounter + ")    ");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
        return localConn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                    System.out.println("Koneksi ditutup.");
                }
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}