package edu.wsu.nova.homework_5_nsmith.model.persistence;

import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for managing video game data in the database.
 * <p>
 * Schema expectations:
 *   video_games(id, title, release_date)
 *   developers(id, name)
 *   publishers(id, name)
 *   platforms(id, name)
 *   video_game_developer(video_game_id, developer_id)
 *   video_game_publisher(video_game_id, publisher_id)
 *   video_game_platform(video_game_id, platform_id)
 */
public class VideoGamesDAO {

    /**
     * Retrieves all video games from the database, including developers, publishers, and platforms.
     *
     * @return List of VideoGame objects representing all video games in the database.
     */
    public static List<VideoGame> getAllVideoGamesFromDB() {
        String sqlGetAllGames = "SELECT id, title, release_date FROM video_games";

        String sqlGetDevelopersForGame = """
                SELECT dev.name
                FROM developers dev
                JOIN video_game_developer vgd ON dev.id = vgd.developer_id
                WHERE vgd.video_game_id = ?
                """;

        String sqlGetPublishersForGame = """
                SELECT pub.name
                FROM publishers pub
                JOIN video_game_publisher vgp ON pub.id = vgp.publisher_id
                WHERE vgp.video_game_id = ?
                """;

        String sqlGetPlatformsForGame = """
                SELECT plat.name
                FROM platforms plat
                JOIN video_game_platform vgp ON plat.id = vgp.platform_id
                WHERE vgp.video_game_id = ?
                """;

        List<VideoGame> allGames = new ArrayList<>();

        try (Connection dbConnection = DatabaseManager.getConnection();
             PreparedStatement getAllGamesStmt = dbConnection.prepareStatement(sqlGetAllGames);
             PreparedStatement getDevelopersStmt = dbConnection.prepareStatement(sqlGetDevelopersForGame);
             PreparedStatement getPublishersStmt = dbConnection.prepareStatement(sqlGetPublishersForGame);
             PreparedStatement getPlatformsStmt = dbConnection.prepareStatement(sqlGetPlatformsForGame);
             ResultSet gamesRs = getAllGamesStmt.executeQuery()) {

            while (gamesRs.next()) {
                int gameId = gamesRs.getInt("id");
                String title = gamesRs.getString("title");
                Date releaseDate = gamesRs.getDate("release_date");

                VideoGame videoGameToAdd = new VideoGame(
                        gameId,
                        title,
                        releaseDate.toLocalDate(),
                        new ArrayList<>(),   // developers
                        new ArrayList<>(),   // publishers
                        new ArrayList<>()    // consoles/platforms
                );

                // Load developers
                getDevelopersStmt.setInt(1, gameId);
                try (ResultSet devRs = getDevelopersStmt.executeQuery()) {
                    while (devRs.next()) {
                        videoGameToAdd.getDevelopers().add(devRs.getString("name"));
                    }
                }

                // Load publishers
                getPublishersStmt.setInt(1, gameId);
                try (ResultSet pubRs = getPublishersStmt.executeQuery()) {
                    while (pubRs.next()) {
                        videoGameToAdd.getPublishers().add(pubRs.getString("name"));
                    }
                }

                // Load platforms
                getPlatformsStmt.setInt(1, gameId);
                try (ResultSet platRs = getPlatformsStmt.executeQuery()) {
                    while (platRs.next()) {
                        videoGameToAdd.getConsoles().add(platRs.getString("name"));
                    }
                }

                allGames.add(videoGameToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allGames;
    }

    /**
     * Updates an existing video game in the database, including its relationships
     * to developers, publishers, and platforms.
     *
     * @param game VideoGame object containing updated information.
     * @throws SQLException if a database access error occurs.
     */
    public static void updateDB(VideoGame game) throws SQLException {
        String updateGameSQL = """
                UPDATE video_games
                SET title = ?,
                    release_date = ?
                WHERE id = ?
                """;

        try (Connection dbConnection = DatabaseManager.getConnection()) {
            // This prevents partial updates if any step fails
            // By default, auto-commit is true, so we disable it here
            // Helpful for when multiple related updates are needed, and it must all succeed or fail together
            // Helpful link explaining this: https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html
            dbConnection.setAutoCommit(false);

            try (PreparedStatement updateStmt = dbConnection.prepareStatement(updateGameSQL)) {
                updateStmt.setString(1, game.getGameTitle());
                updateStmt.setDate(2, Date.valueOf(game.getReleaseDate()));
                updateStmt.setInt(3, game.getGameID());
                updateStmt.executeUpdate();
            }

            // Refresh join tables for this game
            updateDevelopersForGame(dbConnection, game.getGameID(), game.getDevelopers());
            updatePublishersForGame(dbConnection, game.getGameID(), game.getPublishers());
            updatePlatformsForGame(dbConnection, game.getGameID(), game.getConsoles());

            // Commit all changes as a single transaction
            // Re-enable auto-commit afterwards so that other operations are not affected
            dbConnection.commit();
            dbConnection.setAutoCommit(true);
        }
    }

    /**
     * Deletes a video game from the database.
     * ON DELETE CASCADE on foreign keys will clean up join tables automatically.
     *
     * @param game VideoGame object to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    public static void deleteGameFromDB(VideoGame game) throws SQLException {
        String deleteGameSQL = """
                DELETE FROM video_games
                WHERE id = ?
                """;

        try (Connection dbConnection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteGameSQL)) {
            preparedStatement.setInt(1, game.getGameID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Adds a new video game to the database, including relationships to
     * developers, publishers, and platforms.
     *
     * @param game VideoGame object to be added.
     * @throws SQLException if a database access error occurs.
     */
    public static void addGameToDB(VideoGame game) throws SQLException {
        String insertGameSQL = """
                INSERT INTO video_games (title, release_date)
                VALUES (?, ?)
                """;

        try (Connection dbConnection = DatabaseManager.getConnection()) {
            // Once again, disable auto-commit for transaction safety because we do not want partial inserts
            // I.E a game inserted but no relationships, or some relationships missing
            dbConnection.setAutoCommit(false);

            int newGameId;
            try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                    insertGameSQL,
                    Statement.RETURN_GENERATED_KEYS
            )) {
                preparedStatement.setString(1, game.getGameTitle());
                preparedStatement.setDate(2, Date.valueOf(game.getReleaseDate()));
                preparedStatement.executeUpdate();

                try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                    if (!keys.next()) {
                        throw new SQLException("Failed to retrieve generated game ID.");
                    }
                    newGameId = keys.getInt(1);
                }
            }

            // Save relationships
            updateDevelopersForGame(dbConnection, newGameId, game.getDevelopers());
            updatePublishersForGame(dbConnection, newGameId, game.getPublishers());
            updatePlatformsForGame(dbConnection, newGameId, game.getConsoles());

            dbConnection.commit();
            dbConnection.setAutoCommit(true);
        }
    }

    /**
     * Retrieves the next available game ID for inserting a new video game.
     *
     * @return Next available game ID.
     */
    public static int getNextGameID() {
        String sqlGetMaxID = "SELECT MAX(id) AS maximum_id FROM video_games";
        int nextID = 1;

        try (Connection dbConnection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlGetMaxID);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int maxId = resultSet.getInt("maximum_id");
                if (!resultSet.wasNull()) {
                    nextID = maxId + 1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nextID;
    }


    // Helper methods for managing join tables
    // These methods first clear existing relationships, then insert the new ones
    // This ensures that the database state matches exactly what is in the VideoGame object
    // It also handles creating new developers, publishers, and platforms as needed
    // based on names provided in the lists
    /**
     * Updates the developers associated with a video game.
     *
     * @param conn      Active database connection.
     * @param gameId    ID of the video game.
     * @param developers List of developer names to associate with the game.
     * @throws SQLException if a database access error occurs.
     */
    private static void updateDevelopersForGame(Connection conn, int gameId, List<String> developers) throws SQLException {
        String deleteSQL = "DELETE FROM video_game_developer WHERE video_game_id = ?";
        String insertJoinSQL = "INSERT INTO video_game_developer (video_game_id, developer_id) VALUES (?, ?)";

        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
            deleteStmt.setInt(1, gameId);
            deleteStmt.executeUpdate();
        }

        if (developers == null) {
            return;
        }

        try (PreparedStatement insertJoinStmt = conn.prepareStatement(insertJoinSQL)) {
            for (String devName : developers) {
                if (devName == null || devName.isBlank()) {
                    continue;
                }
                int devId = getOrCreateDeveloperId(conn, devName.trim());
                insertJoinStmt.setInt(1, gameId);
                insertJoinStmt.setInt(2, devId);
                insertJoinStmt.addBatch();
            }
            insertJoinStmt.executeBatch();
        }
    }

    /**
     * Updates the publishers associated with a video game.
     *
     * @param conn       Active database connection.
     * @param gameId     ID of the video game.
     * @param publishers List of publisher names to associate with the game.
     * @throws SQLException if a database access error occurs.
     */
    private static void updatePublishersForGame(Connection conn, int gameId, List<String> publishers) throws SQLException {
        String deleteSQL = "DELETE FROM video_game_publisher WHERE video_game_id = ?";
        String insertJoinSQL = "INSERT INTO video_game_publisher (video_game_id, publisher_id) VALUES (?, ?)";

        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
            deleteStmt.setInt(1, gameId);
            deleteStmt.executeUpdate();
        }

        if (publishers == null) {
            return;
        }

        try (PreparedStatement insertJoinStmt = conn.prepareStatement(insertJoinSQL)) {
            for (String pubName : publishers) {
                if (pubName == null || pubName.isBlank()) {
                    continue;
                }
                int pubId = getOrCreatePublisherId(conn, pubName.trim());
                insertJoinStmt.setInt(1, gameId);
                insertJoinStmt.setInt(2, pubId);
                insertJoinStmt.addBatch();
            }
            insertJoinStmt.executeBatch();
        }
    }

    /**
     * Updates the platforms associated with a video game.
     *
     * @param conn      Active database connection.
     * @param gameId    ID of the video game.
     * @param platforms List of platform names to associate with the game.
     * @throws SQLException if a database access error occurs.
     */
    private static void updatePlatformsForGame(Connection conn, int gameId, List<String> platforms) throws SQLException {
        String deleteSQL = "DELETE FROM video_game_platform WHERE video_game_id = ?";
        String insertJoinSQL = "INSERT INTO video_game_platform (video_game_id, platform_id) VALUES (?, ?)";

        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
            deleteStmt.setInt(1, gameId);
            deleteStmt.executeUpdate();
        }

        if (platforms == null) {
            return;
        }

        try (PreparedStatement insertJoinStmt = conn.prepareStatement(insertJoinSQL)) {
            for (String platformName : platforms) {
                if (platformName == null || platformName.isBlank()) {
                    continue;
                }
                int platformId = getOrCreatePlatformId(conn, platformName.trim());
                insertJoinStmt.setInt(1, gameId);
                insertJoinStmt.setInt(2, platformId);
                insertJoinStmt.addBatch();
            }
            insertJoinStmt.executeBatch();
        }
    }

    /**
     * Retrieves the ID of a developer by name, creating a new entry if it doesn't exist.
     *
     * @param conn Active database connection.
     * @param name Name of the developer.
     * @return ID of the developer.
     * @throws SQLException if a database access error occurs.
     */
    private static int getOrCreateDeveloperId(Connection conn, String name) throws SQLException {
        String selectSQL = "SELECT id FROM developers WHERE name = ?";
        String insertSQL = "INSERT INTO developers (name) VALUES (?)";

        try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
            selectStmt.setString(1, name);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, name);
            insertStmt.executeUpdate();
            try (ResultSet keys = insertStmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }

        throw new SQLException("Failed to insert or retrieve developer ID for name: " + name);
    }

    /**
     * Retrieves the ID of a publisher by name, creating a new entry if it doesn't exist.
     *
     * @param conn Active database connection.
     * @param name Name of the publisher.
     * @return ID of the publisher.
     * @throws SQLException if a database access error occurs.
     */
    private static int getOrCreatePublisherId(Connection conn, String name) throws SQLException {
        String selectSQL = "SELECT id FROM publishers WHERE name = ?";
        String insertSQL = "INSERT INTO publishers (name) VALUES (?)";

        try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
            selectStmt.setString(1, name);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, name);
            insertStmt.executeUpdate();
            try (ResultSet keys = insertStmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }

        throw new SQLException("Failed to insert or retrieve publisher ID for name: " + name);
    }

    /**
     * Retrieves the ID of a platform by name, creating a new entry if it doesn't exist.
     *
     * @param conn Active database connection.
     * @param name Name of the platform.
     * @return ID of the platform.
     * @throws SQLException if a database access error occurs.
     */
    private static int getOrCreatePlatformId(Connection conn, String name) throws SQLException {
        String selectSQL = "SELECT id FROM platforms WHERE name = ?";
        String insertSQL = "INSERT INTO platforms (name) VALUES (?)";

        try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
            selectStmt.setString(1, name);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }

        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, name);
            insertStmt.executeUpdate();
            try (ResultSet keys = insertStmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }

        throw new SQLException("Failed to insert or retrieve platform ID for name: " + name);
    }
}
