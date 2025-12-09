package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.infrastructure.util.navigation.SceneSwitcher;
import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Errors.databaseErrorAlert;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Errors.emptyFieldsAlert;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Information.gameAddedSuccessfullyAlert;


/**
 * Controller class for adding new video games to the database.
 */
public class GameAdderController {

    // FXML UI Components
    @FXML
    public TextField GameTitleTextBox;

    @FXML
    public DatePicker ReleaseDatePicker;

    @FXML
    public TextField PlatformTextBox;

    @FXML
    public TextField DeveloperTextBox;

    @FXML
    public TextField PublisherTextBox;

    @FXML
    public Button AddGameButton;

    @FXML
    public Button SwitchToGameViewButton;

    /**
     * Initializes the controller by clearing all input fields.
     */
    @FXML
    public void initialize() {
        clearInputFields();
    }

    /**
     * Adds a new game to the database using the input from the form fields.
     * Validates input fields and shows alerts for empty fields or database errors.
     */
    @FXML
    public void addGame() {
        try {
            String title = GameTitleTextBox.getText().trim();
            String platformText = PlatformTextBox.getText().trim();
            String developerText = DeveloperTextBox.getText().trim();
            String publisherText = PublisherTextBox.getText().trim();
            LocalDate releaseDate = ReleaseDatePicker.getValue();

            if (title.isBlank() ||
                    releaseDate == null ||
                    platformText.isBlank() ||
                    developerText.isBlank() ||
                    publisherText.isBlank()) {
                emptyFieldsAlert();
                return;
            }

            ArrayList<String> platforms = new ArrayList<>(List.of(platformText.split(",\\s*")));
            ArrayList<String> developers = new ArrayList<>(List.of(developerText.split(",\\s*")));
            ArrayList<String> publishers = new ArrayList<>(List.of(publisherText.split(",\\s*")));

            VideoGamesDAO.addGameToDB(new VideoGame(
                    VideoGamesDAO.getNextGameID(),
                    title,
                    releaseDate,
                    developers,
                    publishers,
                    platforms));

            gameAddedSuccessfullyAlert();
            clearInputFields();


        }

        catch (SQLException e) {
            databaseErrorAlert();
        }
    }


    /**
     * Switches the scene to the game list view.
     *
     * @throws IOException if an I/O error occurs during scene switching
     */
    @FXML
    public void switchToGameView() throws IOException {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScenes("/edu/wsu/nova/homework_5_nsmith/views/fxml/game-list-view.fxml",
                SwitchToGameViewButton);
    }

    /**
     * Clears all input fields in the form.
     */
    @FXML
    public void clearInputFields() {
        GameTitleTextBox.clear();
        ReleaseDatePicker.setValue(null);
        PlatformTextBox.clear();
        DeveloperTextBox.clear();
        PublisherTextBox.clear();
    }
}
