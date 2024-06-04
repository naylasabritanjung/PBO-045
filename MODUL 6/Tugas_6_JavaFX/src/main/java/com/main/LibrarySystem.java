package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LibrarySystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("UMM Library");

        // Label
        Label sceneTitle = new Label("UMM Library");
        Label loginLabel = new Label("Pilih jenis login:");

        // Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        // Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        // Button
        Button adminButton = new Button("Admin");
        Button userButton = new Button("User");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0, 0);
        grid.add(loginLabel, 0, 1);
        grid.add(adminButton, 0, 2);
        grid.add(userButton, 0, 3);

        grid.setVgap(10);

        // Create Window
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Action Button
        adminButton.setOnAction(event -> loginAdmin(primaryStage));
        userButton.setOnAction(event -> loginStudent(primaryStage));
    }

    private void loginAdmin(Stage primaryStage) {
        Admin adminObj = new Admin();
        primaryStage.setTitle("Admin Login");

        // Label
        Label sceneTitle = new Label("Admin Login");
        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        Label errorLoginMessage = new Label("Username atau password salah");

        // Field
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        // Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        usernameLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        passwordLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        errorLoginMessage.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 12));

        // Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        errorLoginMessage.setStyle("-fx-text-fill: #FF1E1E;");

        // Font visible Settings
        errorLoginMessage.setVisible(false);

        // Button
        Button loginButton = new Button("Login");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0, 0);
        grid.add(usernameLabel, 0, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(errorLoginMessage, 0, 3);
        grid.add(usernameField, 1, 1);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 1, 3);

        grid.setVgap(10);
        grid.setHgap(5);

        // Create Window
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Action Button
        loginButton.setOnAction(event -> {
            if (usernameField.getText().equals(Admin.adminusername) && passwordField.getText().equals(Admin.adminpassword)) {
                adminObj.menu();
                primaryStage.close();
            } else {
                errorLoginMessage.setVisible(true);
            }
        });
    }

    private void loginStudent(Stage primaryStage) {
        Student studentObj = new Student();
        primaryStage.setTitle("Student Login");

        // Label
        Label sceneTitle = new Label("Student Login");
        Label nimLabel = new Label("NIM");
        Label errorLoginMessage = new Label("masukan NIM yang sesuai!");

        // Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        nimLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        errorLoginMessage.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 12));

        // Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        errorLoginMessage.setStyle("-fx-text-fill: #FF1E1E;");

        // Font visible Settings
        errorLoginMessage.setVisible(false);

        // Field
        TextField nimField = new TextField();

        // Button
        Button loginButton = new Button("Login");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0, 0);
        grid.add(nimLabel, 0, 1);
        grid.add(nimField, 1, 1);
        grid.add(errorLoginMessage, 0, 2, 2, 1); // Spanning across two columns
        grid.add(loginButton, 1, 3);

        grid.setVgap(10);
        grid.setHgap(5);

        // Create Window
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Action Button
        loginButton.setOnAction(event -> {
            try {
                if (!studentObj.isStudents(nimField)) {
                    primaryStage.close();
                } else {
                    studentObj.menu();
                }
            } catch (IllegalAdminAccess e) {
                errorLoginMessage.setVisible(true); // Show error message0
            }
        });
    }
}
