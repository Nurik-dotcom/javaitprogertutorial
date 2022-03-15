package com.example;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField mailField;

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton pol;

    @FXML
    private RadioButton pol2;

    @FXML
    private TextField pswrdField;

    @FXML
    private Button registerBTN;

    @FXML
    private TextField rptpswrdField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField usrnmField;

    @FXML
    void btnRegisteredclick(ActionEvent event) throws ClassNotFoundException, SQLException {
        SignUpNewUser();

        // dbHandler.signUp(nameField.getText(), surnameField.getText(), usrnmField.getText(), pswrdField.getText(), rptpswrdField.getText(), mailField.getText(), "Male");
        registerBTN.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/primary.fxml"));
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.print(e);
        }
        Parent root =fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void SignUpNewUser() throws SQLException, ClassNotFoundException {
        String nam = nameField.getText();
        String surname = surnameField.getText();
        String usrname = usrnmField.getText();
        String pswrd = pswrdField.getText();
        String location = rptpswrdField.getText();
        String email = mailField.getText();
        String gender = "";
        if (pol.isSelected())
            gender = "Male";
        else
            gender = "Female";
            
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User(nam, surname, usrname, pswrd, location, email, gender);
        dbHandler.signUp(user);
    }
}