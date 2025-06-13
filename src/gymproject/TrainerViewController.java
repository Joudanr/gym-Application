/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.handler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class TrainerViewController  {

    private handler handler = new handler();

    @FXML
    private GridPane classGridPane;
    @FXML
    private Label namelbl;

    @FXML
    private Button Edit;
    @FXML
    private Button Remove;

    @FXML
    private void handelEdit(ActionEvent event) {
        GymProject.editClassView();
    }

    @FXML
    private void handelManageSession(ActionEvent event) {
        GymProject.addSeccionView();
    }

    @FXML
    private void handelRemove(ActionEvent event) {
        GymProject.RemoveClassView();
    }

    @FXML
    private void handelTrackProgressView(ActionEvent event) {
        GymProject.trackProgressView();
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.loginView();
    }


}
