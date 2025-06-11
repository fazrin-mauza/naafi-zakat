package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlexibleDBConnection {

    private static final String URL = "jdbc:sqlite:zakat.db";

    public static Connection getNewConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver tidak ditemukan", e);
        }

        return DriverManager.getConnection(URL);
    }
}
