package edu.wsu.nova.homework_5_nsmith.model.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

// Model (POJOs):
// Represents video game information as plain old Java objects (POJOs).
// Each object corresponds to a row in a table (e.g., VideoGame, Console, Publisher).
// Does not directly talk to the database; it just holds data.
/**
 * VideoGame class representing a video game POJO.
 */
public class VideoGame {
    private int gameID;
    private String gameTitle;
    private Date releaseDate;
    private ArrayList<String> developers;
    private ArrayList<String> publishers;
    private ArrayList<String> consoles;

    /**
     * Constructor for VideoGame.
     *
     * @param gameID      Unique identifier for the game. This is the primary key in the database.
     * @param gameTitle   Title of the game.
     * @param releaseDate Release date of the game. Note: LocalDate is converted to SQL Date.
     * @param developers  List of developers.
     * @param publishers  List of publishers.
     * @param consoles    List of consoles/platforms.
     */
    public VideoGame(int gameID,
                     String gameTitle,
                     LocalDate releaseDate,
                     ArrayList<String> developers,
                     ArrayList<String> publishers,
                     ArrayList<String> consoles){
        this.gameID = gameID;
        this.gameTitle = gameTitle;
        this.releaseDate = Date.valueOf(releaseDate);
        this.developers = developers;
        this.publishers = publishers;
        this.consoles = consoles;
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
        if (gameID > 0)
            this.gameID = gameID;
    }

    /**
     * Gets the release date of the game.
     *
     * @return releaseDate Release date of the game.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the game.
     *
     * @param releaseDate Release date of the game.
     */
    public void setReleaseDate(Date releaseDate) {
        if (releaseDate != null)
            this.releaseDate = releaseDate;
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
        if (!gameTitle.isEmpty())
            this.gameTitle = gameTitle;
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
        if (developers != null){
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
        if (publishers != null)
            this.publishers = publishers;
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
        if(consoles != null)
            this.consoles = consoles;
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

        for(String developer : developers){
            if (developers.size()-1 != developers.indexOf(developer))
                sb.append(developer)
                    .append(", ");
            else
                sb.append(developer)
                        .append(" ");
        }

        sb.append("Published by: ");
        for(String publisher : publishers){
            if(publishers.size()-1 != publishers.indexOf(publisher))
                sb.append(publisher)
                    .append(", ");
            else
                sb.append(publisher)
                        .append(" ");
        }

        sb.append("Playable on: ");
        for(String console : consoles){
            if(consoles.size()-1 != consoles.indexOf(console))
                sb.append(console)
                    .append(", ");
            else
                sb.append(console)
                        .append(" ");
        }

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
}