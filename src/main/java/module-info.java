module edu.wsu.nova.homework_5_nsmith {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens   edu.wsu.nova.homework_5_nsmith.controllers to javafx.fxml;
    exports edu.wsu.nova.homework_5_nsmith.controllers;

    exports edu.wsu.nova.homework_5_nsmith.app;
    exports edu.wsu.nova.homework_5_nsmith.model.domain;
}
