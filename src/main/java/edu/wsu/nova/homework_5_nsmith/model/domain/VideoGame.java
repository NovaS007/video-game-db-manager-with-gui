package edu.wsu.nova.homework_5_nsmith.model.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

// Model (POJOs):
// Represents video game information as plain old Java objects (POJOs).
// Each object corresponds to a row in a table (e.g., VideoGame, Console, Publisher).
// Does not directly talk to the database; it just holds data.
public class VideoGame {
    private int gameID;
    private String gameTitle;
    private Date releaseDate;
    private ArrayList<String> developers;
    private ArrayList<String> publishers;
    private ArrayList<String> consoles;

    //make this record?

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

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        if (gameID > 0)
            this.gameID = gameID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        if (releaseDate != null)
            this.releaseDate = releaseDate;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        if (!gameTitle.isEmpty())
            this.gameTitle = gameTitle;
    }

    public ArrayList<String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(ArrayList<String> developers) {
        if (developers != null){
            this.developers = developers;
        }
    }

    public ArrayList<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(ArrayList<String> publishers) {
        if (publishers != null)
            this.publishers = publishers;
    }

    public ArrayList<String> getConsoles() {
        return consoles;
    }

    public void setConsoles(ArrayList<String> consoles) {
        if(consoles != null)
            this.consoles = consoles;
    }

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
}
