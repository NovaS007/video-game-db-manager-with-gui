package edu.wsu.nova.homework_5_nsmith.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ControllerAlerts {
    public static boolean confirmCancellationAlert() {
        Alert confirmCancel = new Alert(Alert.AlertType.CONFIRMATION);
        confirmCancel.setTitle("Confirm Cancellation.");
        confirmCancel.setHeaderText("Are you sure you want to cancel your changes?");
        confirmCancel.setContentText("Any changes made will be lost!");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        confirmCancel.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = confirmCancel.showAndWait();

        return result.isPresent() && result.get() == yes;
    }

    public static boolean confirmEditAlert() {
        Alert confirmEdit = new Alert(Alert.AlertType.CONFIRMATION);
        confirmEdit.setTitle("Confirm Edit.");
        confirmEdit.setHeaderText("Are you sure you want make these changes?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        confirmEdit.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = confirmEdit.showAndWait();

        return result.isPresent() && result.get() == yes;
    }

    public static void noSelectedGamePopup() {
        Alert nullAlert = new Alert(Alert.AlertType.ERROR);
        nullAlert.setTitle("No video game selected!");
        nullAlert.setHeaderText("No video game was selected to edit!");
        nullAlert.setContentText("No video game is selected. " +
                "Please select a game from the drop down list before continuing.");
        nullAlert.showAndWait();
    }

    public static void noGamesInDBPopup() {
        Alert nullAlert = new Alert(Alert.AlertType.ERROR);
        nullAlert.setTitle("No video games in database!");
        nullAlert.setHeaderText("There are no video games in the database!");
        nullAlert.setContentText("There are no video games in the database. " +
                "Please add a game before attempting to edit or delete.");
        nullAlert.showAndWait();
    }

    public static void emptyFieldsAlert() {
        Alert emptyFieldsAlert = new Alert(Alert.AlertType.ERROR);
        emptyFieldsAlert.setTitle("Empty Fields Detected!");
        emptyFieldsAlert.setHeaderText("One or more required fields are empty!");
        emptyFieldsAlert.setContentText("Please ensure all required fields are filled out before continuing.");
        emptyFieldsAlert.showAndWait();
    }

    public static boolean confirmGameDeletion() {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle("Confirm Game Deletion.");
        confirmDelete.setHeaderText("Are you sure you want to delete this game?");
        confirmDelete.setContentText("This action cannot be undone.");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        confirmDelete.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = confirmDelete.showAndWait();

        return result.isPresent() && result.get() == yes;
    }

    public static void gameAddedSuccessfullyAlert() {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Game Added Successfully!");
        successAlert.setHeaderText("The video game was added to the database successfully!");
        successAlert.setContentText("You may now add another game or return to the game list.");
        successAlert.showAndWait();
    }

    public static void noGamesMatchFilterAlert() {
        Alert noMatchAlert = new Alert(Alert.AlertType.INFORMATION);
        noMatchAlert.setTitle("No Games Match Filter!");
        noMatchAlert.setHeaderText("No video games match the filter criteria!");
        noMatchAlert.setContentText("Please adjust your filter criteria and try again.");
        noMatchAlert.showAndWait();
    }
}