/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditClassController {

    @FXML
    private Label confirmMassage;

    @FXML
    private TextField txtfld1;

    @FXML
    private TextField txtfld2;

    @FXML
    private TextField txtID;

    private handler handler = new handler();

    @FXML
    private void handelConfirm(ActionEvent event) {
        String id = txtID.getText();
        String name = txtfld1.getText();
        String time = txtfld2.getText();
        if (!name.isEmpty() && !time.isEmpty() && !id.isEmpty()) {

            int userId = Integer.parseInt(id);
            Boolean check = handler.updateClass(userId, name, time);
            if (check.equals(true)) {
                confirmMassage.setText("Class is updated.");
            } else {
                confirmMassage.setText("invalid ID");
                txtID.clear();
                txtfld1.clear();
                txtfld2.clear();
            }

        } else {
            confirmMassage.setText("some felid empty");
        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.trainerView();
    }

}
