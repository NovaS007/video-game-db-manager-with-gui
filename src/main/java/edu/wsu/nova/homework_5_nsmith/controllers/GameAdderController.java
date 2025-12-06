package edu.wsu.nova.homework_5_nsmith.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
}
