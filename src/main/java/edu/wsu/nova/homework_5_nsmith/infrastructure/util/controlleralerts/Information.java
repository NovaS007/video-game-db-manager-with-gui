package edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts;

import javafx.scene.control.Alert;

/**
 * Utility class for displaying information alerts in the Video Game Manager application.
 */
public class Information {
    /**
     * Displays an information alert when a game is added successfully.
     */
    public static void gameAddedSuccessfullyAlert() {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Game Added Successfully!");
        successAlert.setHeaderText("The video game was added to the database successfully!");
        successAlert.setContentText("You may now add another game or return to the game list.");
        successAlert.showAndWait();
    }

    /**
     * Displays an information alert when no games match the filter criteria.
     */
    public static void noGamesMatchFilterAlert() {
        Alert noMatchAlert = new Alert(Alert.AlertType.INFORMATION);
        noMatchAlert.setTitle("No Games Match Filter!");
        noMatchAlert.setHeaderText("No video games match the filter criteria!");
        noMatchAlert.setContentText("Please adjust your filter criteria and try again.");
        noMatchAlert.showAndWait();
    }
}
