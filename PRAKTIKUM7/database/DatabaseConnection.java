package PRAKTIKUM7.database;

import java.sql.*;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/tokobuku";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
            return null;
        }
    }
}