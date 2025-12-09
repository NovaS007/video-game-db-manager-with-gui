package edu.wsu.nova.homework_5_nsmith.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * VideoGame class representing a video game POJO.
 * <p>
 * Model (POJOs):
 * Represents video game information as plain old Java objects (POJOs).
 * Each object corresponds to a row in a table (e.g., VideoGame, Console, Publisher).
 * Does not directly talk to the database; it just holds data.
 */
public class VideoGame {
    private int gameID;
    private String gameTitle;
    private LocalDate releaseDate;
    private ArrayList<String> developers;
    private ArrayList<String> publishers;
    private ArrayList<String> consoles;

    /**
     * Constructor for VideoGame.
     *
     * @param gameID      Unique identifier for the game. This is the primary key in the database.
     * @param gameTitle   Title of the game.
     * @param releaseDate Release date of the game as a LocalDate.
     * @param developers  List of developers.
     * @param publishers  List of publishers.
     * @param consoles    List of consoles/platforms.
     */
    public VideoGame(int gameID,
                     String gameTitle,
                     LocalDate releaseDate,
                     ArrayList<String> developers,
                     ArrayList<String> publishers,
                     ArrayList<String> consoles) {
        this.gameID = gameID;
        this.gameTitle = gameTitle;
        this.releaseDate = releaseDate;  // store directly as LocalDate
        this.developers = (developers != null) ? developers : new ArrayList<>();
        this.publishers = (publishers != null) ? publishers : new ArrayList<>();
        this.consoles = (consoles != null) ? consoles : new ArrayList<>();
    }

    // Getters and Setters

    /**
     * Gets the unique game ID.
     *
     * @return gameID Unique identifier for the game.
     */
    public int getGameID() {
        return gameID;
    }

    /**
     * Sets the unique game ID.
     *
     * @param gameID Unique identifier for the game.
     */
    public void setGameID(int gameID) {
        if (gameID > 0) {
            this.gameID = gameID;
        }
    }

    /**
     * Gets the release date of the game as a LocalDate.
     *
     * @return releaseDate Release date of the game.
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the game.
     *
     * @param releaseDate Release date of the game.
     */
    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate != null) {
            this.releaseDate = releaseDate;
        }
    }

    /**
     * Gets the title of the game.
     *
     * @return gameTitle Title of the game.
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * Sets the title of the game.
     *
     * @param gameTitle Title of the game.
     */
    public void setGameTitle(String gameTitle) {
        if (gameTitle != null && !gameTitle.isEmpty()) {
            this.gameTitle = gameTitle;
        }
    }

    /**
     * Gets the list of developers.
     *
     * @return developers List of developers.
     */
    public ArrayList<String> getDevelopers() {
        return developers;
    }

    /**
     * Sets the list of developers.
     *
     * @param developers List of developers.
     */
    public void setDevelopers(ArrayList<String> developers) {
        if (developers != null) {
            this.developers = developers;
        }
    }

    /**
     * Gets the list of publishers.
     *
     * @return publishers List of publishers.
     */
    public ArrayList<String> getPublishers() {
        return publishers;
    }

    /**
     * Sets the list of publishers.
     *
     * @param publishers List of publishers.
     */
    public void setPublishers(ArrayList<String> publishers) {
        if (publishers != null) {
            this.publishers = publishers;
        }
    }

    /**
     * Gets the list of consoles/platforms.
     *
     * @return consoles List of consoles/platforms.
     */
    public ArrayList<String> getConsoles() {
        return consoles;
    }

    /**
     * Sets the list of consoles/platforms.
     *
     * @param consoles List of consoles/platforms.
     */
    public void setConsoles(ArrayList<String> consoles) {
        if (consoles != null) {
            this.consoles = consoles;
        }
    }

    /**
     * Returns a string representation of the video game.
     *
     * @return String representation of the video game.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(gameID)
          .append(": ")
          .append(gameTitle)
          .append(", ")
          .append(releaseDate)
          .append("; ")
          .append("Developed by: ");
        formatNames(sb, developers);

        sb.append("Published by: ");
        formatNames(sb, publishers);

        sb.append("Playable on: ");
        formatNames(sb, consoles);

        return sb.toString();
    }

    /**
     * Returns a string representation for ListView display.
     *
     * @return String representation for ListView display.
     */
    public String listViewString() {
        return gameID + ": " + gameTitle;
    }

    /**
     * Helper method to format names from a list into a string.
     *
     * @param sb         StringBuilder to append to.
     * @param names      List of names to format.
     */
    // Only used in toString() to make it cleaner.
    private void formatNames(StringBuilder sb, ArrayList<String> names) {
        if (names != null && !names.isEmpty()) {
            for (int i = 0; i < names.size(); i++) {
                sb.append(names.get(i));
                if (i < names.size() - 1) {
                    sb.append(", ");
                } else {
                    sb.append(" ");
                }
            }
        } else {
            sb.append("N/A ");
        }
    }
}