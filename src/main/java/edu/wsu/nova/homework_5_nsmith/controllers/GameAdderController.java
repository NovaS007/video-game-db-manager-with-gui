package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.infrastructure.SceneSwitcher;
import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO;
import edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts.emptyFieldsAlert;

public class GameAdderController {
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

    public void initialize() {
        clearInputFields();
    }

    public void clearInputFields() {
        GameTitleTextBox.clear();
        ReleaseDatePicker.setValue(null);
        PlatformTextBox.clear();
        DeveloperTextBox.clear();
        PublisherTextBox.clear();
    }

    @FXML
    public void addGame() throws SQLException {
        String title = GameTitleTextBox.getText();
        LocalDate releaseDate = ReleaseDatePicker.getValue();
        ArrayList<String> platforms = new ArrayList<>(List.of(PlatformTextBox.getText().split(",\\s*")));
        ArrayList<String> developers = new ArrayList<>(List.of(DeveloperTextBox.getText().split(",\\s*")));
        ArrayList<String> publishers = new ArrayList<>(List.of(PublisherTextBox.getText().split(",\\s*")));

        if (title.isEmpty() ||
                releaseDate == null ||
                platforms.isEmpty() ||
                developers.isEmpty() ||
                publishers.isEmpty()) {
            emptyFieldsAlert();
        }

        else {
            VideoGamesDAO.addGameToDB(new VideoGame(
                    VideoGamesDAO.getAllVideoGamesFromDB().size() + 1,
                    title,
                    releaseDate,
                    developers,
                    publishers,
                    platforms));
            ControllerAlerts.gameAddedSuccessfullyAlert();
            clearInputFields();
        }
    }

    @FXML
    public void switchToGameView() throws IOException {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScenes("/edu/wsu/nova/homework_5_nsmith/views/game-list-view.fxml",
                SwitchToGameViewButton);
    }
}
