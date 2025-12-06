package edu.wsu.nova.homework_5_nsmith.infrastructure;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SceneSwitcher {
    public static Window getCurrentWindow() {
        return Stage.getWindows()
                .stream()
                .filter(Window::isShowing)
                .findFirst()
                .orElse(null);
    }

    public <T> T switchScenes(String fxmlPath, Node node) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

        return loader.getController();
    }
}
