/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.SessionInfo;
import database.handler;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import uml.User;

public class MemberEditInfoController implements Initializable {

    @FXML
    private TextField nametxt;
    @FXML
    private TextField phoneNumtxt;
    @FXML
    private TextField emailtxt;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    private TextField DOBtxt;

    @FXML
    private Label savelbl;
    
    private handler handler = new handler();

    @FXML
    private void handelSaveChanges(ActionEvent event) throws SQLException {

        String nameVal = nametxt.getText();

        String passwordVal = passwordtxt.getText();
        String emailVal = emailtxt.getText();
        String dateOfBirthlVal = DOBtxt.getText();
        String phoneNumberVal = phoneNumtxt.getText();

        User user = SessionInfo.getInstance().getCurrentUser();
        int id = user.getUserID();

        if (!nameVal.isEmpty() && !dateOfBirthlVal.isEmpty() && !passwordVal.isEmpty()
                && !emailVal.isEmpty() && !phoneNumberVal.isEmpty()) {

            handler.updateUser( id, passwordVal, emailVal, nameVal, Date.valueOf(dateOfBirthlVal), phoneNumberVal, "MEMBER");
            savelbl.setText("Saved Successfully");
        } else {
            savelbl.setText("Some field is empty");
        }

    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.memberView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            User user = SessionInfo.getInstance().getCurrentUser();
            int userId = user.getUserID();
            nametxt.setText(user.getFullName());
            DOBtxt.setText(user.getDateofBirth());
            phoneNumtxt.setText(user.getPhoneNumber());
            emailtxt.setText(user.getEmail());
            passwordtxt.setText(user.getPassWord());
        } catch (Exception ex) {
            System.out.println("!!");
        }

    }
}
