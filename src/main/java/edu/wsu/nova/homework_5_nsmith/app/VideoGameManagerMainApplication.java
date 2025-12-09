package edu.wsu.nova.homework_5_nsmith.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the Video Game Manager JavaFX application.
 */
public class VideoGameManagerMainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VideoGameManagerMainApplication.class.getResource("/edu/wsu/nova/homework_5_nsmith/views/fxml/game-list-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Video Game Manager");
        stage.setScene(scene);
        stage.show();

    }
}
