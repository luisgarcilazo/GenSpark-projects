module com.example.humanvsgoblinsgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.humanvsgoblinsgui to javafx.fxml;
    exports com.example.humanvsgoblinsgui;
}