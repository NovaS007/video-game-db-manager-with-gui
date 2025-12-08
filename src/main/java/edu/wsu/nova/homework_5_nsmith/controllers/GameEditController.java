package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.infrastructure.util.navigation.SceneSwitcher;
import edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Confirmation.confirmCancellationAlert;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Confirmation.confirmEditAlert;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Errors.noGamesInDBPopup;

import static edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO.updateDB;

/**
 * Controller class for editing existing video games in the database.
 */
public class GameEditController {

    // FXML UI Components
    @FXML
    public DatePicker EditReleaseDatePicker;

    @FXML
    public TextField EditPlatformTextBox;

    @FXML
    public TextField EditPublisherTextBox;

    @FXML
    public TextField EditDeveloperTextBox;

    @FXML
    public Button ConfirmChangesButton;

    @FXML
    public Button CancelChangesButton;

    @FXML
    public TextField EditGameTitleTextBox;

    // VideoGame instance being edited
    private VideoGame gameBeingEdited;

    /**
     * Initializes the controller.
     * This method is called after the FXML fields have been injected.
     */
    @FXML
    public void initialize(){
    }

    /**
     * Initializes the text boxes with the current values of the video game being edited.
     * This method populates the fields with existing data for user modification.
     */
    @FXML
    public void initializeTextBoxes() {
        EditGameTitleTextBox.setText(gameBeingEdited.getGameTitle());
        EditDeveloperTextBox.setText(String.join(", ", gameBeingEdited.getDevelopers()));
        EditPublisherTextBox.setText(String.join(", ", gameBeingEdited.getPublishers()));
        EditPlatformTextBox.setText(String.join(", ", gameBeingEdited.getConsoles()));
        EditReleaseDatePicker.setValue(gameBeingEdited.getReleaseDate().toLocalDate());
    }

    /**
     * Finalizes the changes made to the video game being edited.
     * Prompts the user for confirmation before updating the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @FXML
    public void finalizeChanges() throws SQLException {
        if (confirmEditAlert()) {
            ArrayList<String> newDevelopers = new ArrayList<>(Arrays.asList(EditDeveloperTextBox.getText().split(", ")));
            ArrayList<String> newPublishers = new ArrayList<>(Arrays.asList(EditPublisherTextBox.getText().split(", ")));
            ArrayList<String> newPlatforms = new ArrayList<>(Arrays.asList(EditPlatformTextBox.getText().split(", ")));

            VideoGame updatedGame = new VideoGame(gameBeingEdited.getGameID(),
                    EditGameTitleTextBox.getText(),
                    EditReleaseDatePicker.getValue(),
                    newDevelopers,
                    newPublishers,
                    newPlatforms
            );

            updateDB(updatedGame);
        }
    }

    /**
     * Cancels the changes made to the video game being edited and returns to the game list view.
     *
     * @throws IOException if an I/O error occurs during scene switching
     */
    @FXML
    public void cancelChangesAndReturn() throws IOException {
        if (confirmCancellationAlert()) {
            SceneSwitcher sceneSwitcher = new SceneSwitcher();
            sceneSwitcher.switchScenes(
                    "/edu/wsu/nova/homework_5_nsmith/views/game-list-view.fxml",
                    CancelChangesButton);
        }
    }

    // Getter and Setter for gameBeingEdited with validation to ensure a game is selected and exists in the database
    /**
     * Gets the VideoGame instance currently being edited.
     *
     * @return the VideoGame being edited
     */
    public VideoGame getGameBeingEdited() {
        return gameBeingEdited;
    }

    /**
     * Sets the VideoGame instance to be edited.
     * If there are no games in the database, a popup alert is shown.
     *
     * @param gameBeingEdited the VideoGame to be edited
     */
    public void setGameBeingEdited(VideoGame gameBeingEdited) {
        if (VideoGamesDAO.getAllVideoGamesFromDB().isEmpty()) {
            noGamesInDBPopup();
        }

        else {
            this.gameBeingEdited = gameBeingEdited;
        }
    }
}