package edu.wsu.nova.homework_5_nsmith.infrastructure.fileio;

import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;

import javafx.stage.FileChooser;

import java.util.List;

/**
 * FileOutput class to handle saving video game data to a CSV file.
 */
public class FileOutput {
    /**
     * Saves the provided list of video games to a CSV file.
     *
     * @param videoGames List of VideoGame objects to be saved.
     */
    public static void saveAsCSV(List<VideoGame> videoGames) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Video Games as CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        java.io.File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
                writer.println("Title,Release Date,Platforms,Developers,Publishers");
                for (VideoGame game : videoGames) {
                    String platforms = String.join(";", game.getConsoles());
                    String developers = String.join(";", game.getDevelopers());
                    String publishers = String.join(";", game.getPublishers());
                    writer.printf("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"%n",
                            game.getGameTitle(),
                            game.getReleaseDate().toString(),
                            platforms,
                            developers,
                            publishers);
                }
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
