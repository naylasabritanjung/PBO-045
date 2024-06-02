package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Login");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Halaman Login");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(titleLabel, 0, 0, 2, 1);

        Label userLabel = new Label("Username:");
        grid.add(userLabel, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Label errorMessage = new Label();
        errorMessage.setTextFill(Color.RED);
        grid.add(errorMessage, 1, 3);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        loginButton.setOnAction(event -> {
            String user = userTextField.getText();
            String password = passwordField.getText();

            if (authenticate(user, password)) {
                Stage successStage = new Stage();
                successStage.setTitle("Welcome");

                VBox vbox = new VBox(10);
                vbox.setAlignment(Pos.CENTER);

                // Add the greeting label
                Label successLabel = new Label("Halo " + user + "!");
                vbox.getChildren().add(successLabel);

                // Add the "Kembali" button
                Button backButton = new Button("Kembali");
                vbox.getChildren().add(backButton);

                backButton.setOnAction(e -> {
                    successStage.close();
                    primaryStage.show();
                });

                Scene successScene = new Scene(vbox, 300, 200);
                successStage.setScene(successScene);
                successStage.show();
                primaryStage.close();
            } else {
                errorMessage.setText("Username atau Password salah");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean authenticate(String username, String password) {

        String correctUsername = "nayla";
        String correctPassword = "sabri";

        return username.equals(correctUsername) && password.equals(correctPassword);
    }
}