package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.infrastructure.SceneSwitcher;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO.updateDB;
import static edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts.confirmCancellationAlert;
import static edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts.confirmEditAlert;


public class GameEditController {
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

    private VideoGame gameBeingEdited;

    public void setGameBeingEdited(VideoGame gameBeingEdited) {
        this.gameBeingEdited = gameBeingEdited;
    }

    public void initialize(){
    }

    public void setGameToEdit() {
        EditGameTitleTextBox.setText(gameBeingEdited.getGameTitle());
        EditDeveloperTextBox.setText(String.join(", ", gameBeingEdited.getDevelopers()));
        EditPublisherTextBox.setText(String.join(", ", gameBeingEdited.getPublishers()));
        EditPlatformTextBox.setText(String.join(", ", gameBeingEdited.getConsoles()));
        EditReleaseDatePicker.setValue(gameBeingEdited.getReleaseDate().toLocalDate());
    }

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

    @FXML
    public void cancelChangesAndReturn() throws IOException {
        if (confirmCancellationAlert()) {
            SceneSwitcher sceneSwitcher = new SceneSwitcher();
            sceneSwitcher.switchScenes(
                    "/edu/wsu/nova/homework_5_nsmith/views/game-list-view.fxml",
                    CancelChangesButton);
        }
    }
}