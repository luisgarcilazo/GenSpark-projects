package com.example.humanvsgoblinsgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane initialGrid = new GridPane();
        initialGrid.setAlignment(Pos.CENTER);
        initialGrid.setHgap(10);
        initialGrid.setVgap(10);
        initialGrid.setPadding(new Insets(25,25,25,25));

        Text welcomeTitle = new Text("Welcome to Human Vs Goblins");
        initialGrid.add(welcomeTitle,0,0,2,1);

        Label name = new Label("Your name: ");
        initialGrid.add(name,0,1);

        TextField nameTextField = new TextField();
        initialGrid.add(nameTextField,1,1);

        Label difficultyLabel = new Label("Difficulty: ");
        ObservableList<String> difficultyList =
                FXCollections.observableArrayList(
                        "Easy",
                        "Medium",
                        "Hard"
                );
        ComboBox difficultyBox = new ComboBox(difficultyList);
        initialGrid.add(difficultyLabel, 0,2);
        initialGrid.add(difficultyBox,1,2);

        Button startButton = new Button();
        startButton.setText("Start");

        Scene startScene = new Scene(initialGrid,700,700);
        stage.setTitle("Human Vs Goblins");
        stage.setScene(startScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}