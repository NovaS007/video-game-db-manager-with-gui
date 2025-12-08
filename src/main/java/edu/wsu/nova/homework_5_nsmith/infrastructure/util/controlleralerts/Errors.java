package edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts;

import javafx.scene.control.Alert;

/**
 * Utility class for displaying error alerts in the application.
 */
public class Errors {
    /**
     * Displays an error alert when a database error occurs.
     */
    public static void databaseErrorAlert() {
        Alert dbErrorAlert = new Alert(Alert.AlertType.ERROR);
        dbErrorAlert.setTitle("Database Error!");
        dbErrorAlert.setHeaderText("An error occurred while accessing the database!");
        dbErrorAlert.setContentText("Please try again later or contact support if the issue persists.");
        dbErrorAlert.showAndWait();
    }

    /**
     * Displays an error alert when no game is selected.
     */
    public static void noSelectedGamePopup() {
        Alert nullAlert = new Alert(Alert.AlertType.ERROR);
        nullAlert.setTitle("No video game selected!");
        nullAlert.setHeaderText("No video game was selected to edit!");
        nullAlert.setContentText("No video game is selected. " +
                "Please select a game from the drop down list before continuing.");
        nullAlert.showAndWait();
    }

    /**
     * Displays an error alert when there are no games in the database.
     */
    public static void noGamesInDBPopup() {
        Alert nullAlert = new Alert(Alert.AlertType.ERROR);
        nullAlert.setTitle("No video games in database!");
        nullAlert.setHeaderText("There are no video games in the database!");
        nullAlert.setContentText("There are no video games in the database. " +
                "Please add a game before attempting to edit or delete.");
        nullAlert.showAndWait();
    }

    /**
     * Displays an error alert when there are empty fields.
     */
    public static void emptyFieldsAlert() {
        Alert emptyFieldsAlert = new Alert(Alert.AlertType.ERROR);
        emptyFieldsAlert.setTitle("Empty Fields Detected!");
        emptyFieldsAlert.setHeaderText("One or more required fields are empty!");
        emptyFieldsAlert.setContentText("Please ensure all required fields are filled out before continuing.");
        emptyFieldsAlert.showAndWait();
    }


}
