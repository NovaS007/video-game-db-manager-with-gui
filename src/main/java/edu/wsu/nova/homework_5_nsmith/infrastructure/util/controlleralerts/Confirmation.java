package edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Utility class for displaying confirmation alerts in the application.
 */
public class Confirmation {
    /**
     * Displays a confirmation alert for cancelling changes.
     *
     * @return true if the user confirms cancellation, false otherwise.
     */
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

    /**
     * Displays a confirmation alert for editing a game.
     *
     * @return true if the user confirms the edit, false otherwise.
     */
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

    /**
     * Displays a confirmation alert for deleting a game.
     *
     * @return true if the user confirms deletion, false otherwise.
     */
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
}
