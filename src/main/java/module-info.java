module com.example.weatherbroadcast {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.weatherbroadcast to javafx.fxml;
    exports com.example.weatherbroadcast;
    exports com.example.weatherbroadcast.Controllers;
    opens com.example.weatherbroadcast.Controllers to javafx.fxml;
}