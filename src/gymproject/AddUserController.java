
package gymproject;

import database.handler;
import java.sql.Date;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddUserController {

    @FXML
    private TextField nametxt;
    
    @FXML
    private TextField DOBtxt;
    @FXML
    private TextField phoneNumtxt;
    @FXML
    private TextField emailtxt;
    @FXML
    private PasswordField passwordtxt;
    
    @FXML
    private RadioButton member;
    @FXML
    private RadioButton trainer;
    @FXML
    private RadioButton admin;

    @FXML
    private Label lbl;

    private handler handler = new handler();


    @FXML
    private void handelConfirm(ActionEvent event) throws SQLException {

        String nameVal = nametxt.getText();
        String passwordVal = passwordtxt.getText();
        String emailVal = emailtxt.getText();
        String dateOfBirthlVal = DOBtxt.getText();
        String phoneNumberVal = phoneNumtxt.getText();

        if (!nameVal.isEmpty() 
                && !dateOfBirthlVal.isEmpty() && !phoneNumberVal.isEmpty()
                && !emailVal.isEmpty() && !passwordVal.isEmpty()) {

            String role = "";

            if (member.isSelected()) {
                role = "MEMBER";
            } else if (trainer.isSelected()) {
                role = "TRAINER";
            } else if (admin.isSelected()) {
                role = "ADMIN";
            }

            try {
                handler.insertUser( passwordVal, emailVal, nameVal, Date.valueOf(dateOfBirthlVal), phoneNumberVal, role);
                lbl.setText("User added successfully");
                nametxt.clear();
                passwordtxt.clear();
                emailtxt.clear();
                DOBtxt.clear();
                phoneNumtxt.clear();
            } catch (SQLException ex) {
                lbl.setText("Error:" + ex);
            }
        } else {
            lbl.setText("Some field is empty");
        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.UsersManagementView();
    }

    }


