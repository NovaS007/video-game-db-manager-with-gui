package edu.wsu.nova.homework_5_nsmith.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DatabaseManager:
// Responsible only for managing the database connection.
// Knows the JDBC URL, username, and password, and provides a method to get a Connection.
// Does NOT contain application logic or table-specific queries.
public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/video_game_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "XenobladeChronicles2020!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}