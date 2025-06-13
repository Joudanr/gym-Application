/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class UsersManagementController {

    @FXML
    private void handelAddUser(ActionEvent event) {
        GymProject.AddUserView();
    }

    @FXML
    private void handelRemoveUser(ActionEvent event) {
        GymProject.RemoveUserView();
    }

    @FXML
    private void handelUpdateUser(ActionEvent event) {
        GymProject.UpdateUserView();
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.administratorView();
    }
}
