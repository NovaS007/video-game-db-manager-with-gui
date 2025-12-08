package edu.wsu.nova.homework_5_nsmith.controllers;

import edu.wsu.nova.homework_5_nsmith.model.persistence.VideoGamesDAO;
import edu.wsu.nova.homework_5_nsmith.model.domain.VideoGame;
import edu.wsu.nova.homework_5_nsmith.infrastructure.SceneSwitcher;
import edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static edu.wsu.nova.homework_5_nsmith.ui.ControllerAlerts.noSelectedGamePopup;

public class GameListController {

    @FXML
    public ListView<VideoGame> VideoGamePOJOList;

    @FXML
    public Button AddNewGameButton;

    @FXML
    public Button EditGameButton;

    @FXML
    public Button DeleteGameButton;

    @FXML
    public TextField TitleToFilterByButton;

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
    public void initialize() {
        List<VideoGame> gamesFromDb = VideoGamesDAO.getAllVideoGamesFromDB();

        ObservableList<VideoGame> observableGames =
                FXCollections.observableArrayList(gamesFromDb);

        VideoGamePOJOList.setItems(observableGames);
    }

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
                "/edu/wsu/nova/homework_5_nsmith/views/game-edit-view.fxml",
                EditGameButton
        );

        editController.setGameBeingEdited(selectedGame);
        editController.setGameToEdit();
    }

    @FXML
    public void switchToGameAdder() throws IOException{
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScenes("/edu/wsu/nova/homework_5_nsmith/views/game-adder-view.fxml",
                AddNewGameButton);
    }

    @FXML
    public void deleteSelectedGame() throws SQLException {
        VideoGame selectedGame = VideoGamePOJOList.getSelectionModel().getSelectedItem();

        if (selectedGame == null){
            noSelectedGamePopup();
            return;
        }

        if (ControllerAlerts.confirmGameDeletion()) {
            VideoGamesDAO.deleteGameFromDB(selectedGame);
        }

        initialize();
    }
}
