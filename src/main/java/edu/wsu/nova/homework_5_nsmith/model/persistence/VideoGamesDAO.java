package edu.wsu.nova.homework_5_nsmith.model.persistence;

import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO (Data Access Object):
// Serves as a bridge between the application and the database.
// Handles data operations such as retrieval, insertion, updating, and deletion
// by converting between SQL rows and POJOs (model objects).
public class VideoGamesDAO {
    public static List<VideoGame> getAllVideoGamesFromDB() {
        String sqlGetAllGames = "SELECT id, title, release_date FROM video_games";

        String sqlGetDevelopersForGame = """
        SELECT developer.name
        FROM developers developer
        JOIN video_game_developer vgd ON developer.id = vgd.developer_id
        WHERE vgd.video_game_id = ?
        """;

        String sqlGetPublishersForGame = """
        SELECT publisher.name
        FROM publishers publisher
        JOIN video_game_publisher vgp ON publisher.id = vgp.publisher_id
        WHERE vgp.video_game_id = ?
        """;

        String sqlGetPlatformsForGame = """
        SELECT platform.name
        FROM platforms platform
        JOIN video_game_platform vgp ON platform.id = vgp.platform_id
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
                        new ArrayList<>()    // consoles
                );

                // ---- Load developers ----
                getDevelopersStmt.setInt(1, gameId);
                try (ResultSet devRs = getDevelopersStmt.executeQuery()) {
                    while (devRs.next()) {
                        videoGameToAdd.getDevelopers().add(devRs.getString("name"));
                    }
                }

                // ---- Load publishers ----
                getPublishersStmt.setInt(1, gameId);
                try (ResultSet pubRs = getPublishersStmt.executeQuery()) {
                    while (pubRs.next()) {
                        videoGameToAdd.getPublishers().add(pubRs.getString("name"));
                    }
                }

                // ---- Load platforms/consoles ----
                getPlatformsStmt.setInt(1, gameId);
                try (ResultSet platRs = getPlatformsStmt.executeQuery()) {
                    while (platRs.next()) {
                        videoGameToAdd.getConsoles().add(platRs.getString("name"));
                    }
                }

                allGames.add(videoGameToAdd);
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return allGames;
    }
}

