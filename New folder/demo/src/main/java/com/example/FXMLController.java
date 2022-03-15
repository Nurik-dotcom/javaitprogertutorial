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
import java.sql.*;

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
    void btnClickAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        String loginText = usrnmButton.getText().trim();
        String loginPassword = pswrdBtn.getText().trim();

        if(!loginText.equals("") && !loginPassword.equals(""))
            loginUser(loginText, loginPassword);
        else
            System.out.println("Cannot be empty");
        
    }

    private void loginUser(String loginText, String loginPassword) throws ClassNotFoundException, SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.SetUserName(loginText);
        user.SetPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;
        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        if(counter >= 1){
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
        else
            System.out.println("Wrong username or password");

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