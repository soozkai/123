module com.example.cab302_week9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.kordamp.bootstrapfx.core;
    opens com.example.cab302_week9 to javafx.fxml;
    exports com.example.cab302_week9;
}