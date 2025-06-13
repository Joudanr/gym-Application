/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import uml.User;

public class UpdateUserController implements Initializable {

    @FXML
    private TextField nametxt;
    @FXML
    private TextField IDtxt;
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
    private Label showlbl;
    @FXML
    private Label changelbl;

    private handler handler = new handler();

    private ToggleGroup tg = new ToggleGroup();

    @FXML
    private void handelShow(ActionEvent event) {
        try {
            if (IDtxt.getText().isEmpty()) {
                showlbl.setText("Enter the ID");

                nametxt.setEditable(false);
                DOBtxt.setEditable(false);
                phoneNumtxt.setEditable(false);
                emailtxt.setEditable(false);
                passwordtxt.setEditable(false);
            } else {
                int userId = Integer.parseInt(IDtxt.getText());
                User user = handler.getUserById(userId);

                if (user != null) {
                    System.out.println(user);
                    showlbl.setText("Correct ID");
                    nametxt.setEditable(true);
                    DOBtxt.setEditable(true);
                    phoneNumtxt.setEditable(true);
                    emailtxt.setEditable(true);
                    passwordtxt.setEditable(true);

                    // Fill the fields with user data
                    nametxt.setText(user.getFullName());
                    DOBtxt.setText(user.getDateofBirth());
                    phoneNumtxt.setText(user.getPhoneNumber());
                    emailtxt.setText(user.getEmail());
                    passwordtxt.setText(user.getPassWord());

                    if (user.getRole().equals("MEMBER")) {
                        tg.selectToggle(member);
                    } else if (user.getRole().equals("TRAINER")) {
                        tg.selectToggle(trainer);
                    } else {
                        tg.selectToggle(admin);
                    }
                } else {
                    System.out.println("No such user.");
                    showlbl.setText("Invalid ID");
                    
                    nametxt.clear();
                    DOBtxt.clear();
                    phoneNumtxt.clear();
                    emailtxt.clear();
                    passwordtxt.clear();
                    
                    nametxt.setEditable(false);
                    DOBtxt.setEditable(false);
                    phoneNumtxt.setEditable(false);
                    emailtxt.setEditable(false);
                    passwordtxt.setEditable(false);
                }
            }
        } catch (NumberFormatException ex) {
            showlbl.setText("Invalid ID format");
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void handelConfirm(ActionEvent event) {

        String idVal = IDtxt.getText();
        String nameVal = nametxt.getText();
        String passwordVal = passwordtxt.getText();
        String emailVal = emailtxt.getText();
        String dateOfBirthlVal = DOBtxt.getText();
        String phoneNumberVal = phoneNumtxt.getText();

        if (!nameVal.isEmpty() || !idVal.isEmpty()
                || !dateOfBirthlVal.isEmpty() || !phoneNumberVal.isEmpty()
                || !emailVal.isEmpty() || !passwordVal.isEmpty()) {

            String role = "";

            if (member.isSelected()) {
                role = "MEMBER";
            } else if (trainer.isSelected()) {
                role = "TRAINER";
            } else if (admin.isSelected()) {
                role = "ADMIN";
            }

            try {
                int userId = Integer.parseInt(idVal);
                handler.updateUser(userId, passwordVal, emailVal, nameVal, Date.valueOf(dateOfBirthlVal), phoneNumberVal, role);
                changelbl.setText("User updated successfully");
            } catch (SQLException ex) {
                changelbl.setText("Error:" + ex);
            }
        } else {
            changelbl.setText("Some field is empty");
        }

    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.UsersManagementView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        member.setToggleGroup(tg);
        trainer.setToggleGroup(tg);
        admin.setToggleGroup(tg);
        nametxt.setEditable(false);
        DOBtxt.setEditable(false);
        phoneNumtxt.setEditable(false);
        emailtxt.setEditable(false);
        passwordtxt.setEditable(false);
    }

}
