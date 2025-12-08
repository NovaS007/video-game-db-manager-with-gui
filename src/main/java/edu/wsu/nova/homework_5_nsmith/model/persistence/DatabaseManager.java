package edu.wsu.nova.homework_5_nsmith.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DatabaseManager:
// Responsible only for managing the database connection.
// Knows the JDBC URL, username, and password, and provides a method to get a Connection.
// Does NOT contain application logic or table-specific queries.
/**
 * Manages the database connection for the video game application.
 */
public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/video_game_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    /**
     * Establishes and returns a connection to the database.
     *
     * @return Connection object to interact with the database.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}