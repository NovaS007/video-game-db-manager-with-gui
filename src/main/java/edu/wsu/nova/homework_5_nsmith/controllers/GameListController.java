package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.infrastructure.fileio.FileOutput;
import edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO;
import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.infrastructure.util.navigation.SceneSwitcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ListCell;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Confirmation.confirmGameDeletion;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Errors.noSelectedGamePopup;
import static edu.wsu.nova.homework_5_nsmith.infrastructure.util.controlleralerts.Information.noGamesMatchFilterAlert;

/**
 * Controller class for managing the video game list view.
 */
public class GameListController {

    // FXML UI Components
    @FXML
    public ListView<VideoGame> VideoGamePOJOList;

    @FXML
    public Button AddNewGameButton;

    @FXML
    public Button EditGameButton;

    @FXML
    public Button DeleteGameButton;

    @FXML
    public Text TitleDisplayText;

    @FXML
    public Text DateDisplayText;

    @FXML
    public Text DeveloperDisplayText;

    @FXML
    public Text PublisherDisplayText;

    @FXML
    public Text ConsoleDisplayText;

    @FXML
    public Button ExportCSVButton;

    @FXML
    public Button FilterButton;

    @FXML
    public TextField TitleToFilterByText;


    /**
     * Initializes the controller after the FXML components have been loaded.
     * Sets up the ListView and selection listener.
     */
    @FXML
    public void initialize() {
        refreshGamesListFromDB();

        // Use ListViewString() for how each VideoGame is shown in the ListView
        VideoGamePOJOList.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(VideoGame game, boolean empty) {
                super.updateItem(game, empty);
                if (empty || game == null) {
                    setText(null);
                } else {
                    setText(game.listViewString());
                }
            }
        });

        // Listener for selection changes
        VideoGamePOJOList.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldGame, newGame) -> displaySelectedGameDetails());

        if (!VideoGamePOJOList.getItems().isEmpty()) {
            VideoGamePOJOList.getSelectionModel().selectFirst();
            displaySelectedGameDetails();
        }
    }

    /**
     * Switches to the game editor view for the selected video game.
     */
    @FXML
    public void switchToEditor() throws IOException {
        VideoGame selectedGame = VideoGamePOJOList
                .getSelectionModel()
                .getSelectedItem();

        if (selectedGame == null) {
            noSelectedGamePopup();
            return;
        }

        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        GameEditController editController = sceneSwitcher.switchScenes(
                "/edu/wsu/nova/homework_5_nsmith/views/fxml/game-edit-view.fxml",
                EditGameButton
        );

        editController.setGameBeingEdited(selectedGame);
        editController.initializeTextBoxes();
    }

    /**
     * Switches to the game adder view to add a new video game.
     */
    @FXML
    public void switchToGameAdder() throws IOException {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScenes("/edu/wsu/nova/homework_5_nsmith/views/fxml/game-adder-view.fxml",
                AddNewGameButton);
    }

    /**
     * Deletes the selected video game from the database after user confirmation.
     *
     * @throws SQLException if a database access error occurs
     */
    @FXML
    public void deleteSelectedGame() throws SQLException {
        VideoGame selectedGame = VideoGamePOJOList.getSelectionModel().getSelectedItem();

        if (selectedGame == null) {
            noSelectedGamePopup();
            return;
        }

        if (confirmGameDeletion()) {
            VideoGamesDAO.deleteGameFromDB(selectedGame);
            refreshGamesListFromDB();
        }

    }

    /**
     * Filters the video games list by title based on user input.
     * Displays an alert if no games match the filter.
     */
    @FXML
    public void filterGamesByTitle() {
        String titleFilter = TitleToFilterByText.getText().toLowerCase();

        ObservableList<VideoGame> filteredGames = FXCollections.observableArrayList();

        for (VideoGame game : VideoGamesDAO.getAllVideoGamesFromDB()) {
            if (game.getGameTitle().toLowerCase().contains(titleFilter)) {
                filteredGames.add(game);
            }
        }

        if (filteredGames.isEmpty()) {
            noGamesMatchFilterAlert();
        } else if (titleFilter.isBlank()) {
            VideoGamePOJOList.setItems(FXCollections.observableArrayList(
                    VideoGamesDAO.getAllVideoGamesFromDB()
            ));
        } else {
            VideoGamePOJOList.setItems(filteredGames);
        }
    }

    /**
     * Exports the list of video games to a CSV file.
     */
    @FXML
    public void exportGamesToCSV() {
        FileOutput.saveAsCSV(VideoGamesDAO.getAllVideoGamesFromDB());
    }

    /**
     * Displays the details of the selected video game in the UI text fields.
     */
    @FXML
    public void displaySelectedGameDetails() {
        VideoGame selectedGame = VideoGamePOJOList.getSelectionModel().getSelectedItem();

        if (selectedGame != null) {
            TitleDisplayText.setText(selectedGame.getGameTitle());
            DateDisplayText.setText(selectedGame.getReleaseDate().toString());
            DeveloperDisplayText.setText(String.join(", ", selectedGame.getDevelopers()));
            PublisherDisplayText.setText(String.join(", ", selectedGame.getPublishers()));
            ConsoleDisplayText.setText(String.join(", ", selectedGame.getConsoles()));
        }
    }

    /**
     * Refreshes the video games list from the database and updates the ListView.
     */
    @FXML
    public void refreshGamesListFromDB() {
        List<VideoGame> gamesFromDb = VideoGamesDAO.getAllVideoGamesFromDB();
        ObservableList<VideoGame> observableGames =
                FXCollections.observableArrayList(gamesFromDb);
        VideoGamePOJOList.setItems(observableGames);
    }
}
