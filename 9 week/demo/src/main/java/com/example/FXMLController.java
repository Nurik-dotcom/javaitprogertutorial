package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController {

    @FXML
    private Button RegisterBtn;

    @FXML
    private Label lblOut;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField pswrdBtn;

    @FXML
    private TextField usrnmButton;


    @FXML
    void btnClickAction(ActionEvent event) {
        loginBtn.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/second.fxml"));
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.print(e);
        }
        Parent root =fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void btnRegisterclick(ActionEvent event) {
        RegisterBtn.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/register.fxml"));
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.print(e);
        }
        Parent root =fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}