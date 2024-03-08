module com.example.sudokudemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.sudokudemo to javafx.fxml;
    exports com.example.sudokudemo;
}