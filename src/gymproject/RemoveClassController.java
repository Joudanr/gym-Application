/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.handler;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RemoveClassController {

    @FXML
    private Label removelbl;

    @FXML
    private TextField IDtxt;

    private handler handler = new handler();

    @FXML
    private void handelRemove(ActionEvent event) throws SQLException {
        try {
            if (IDtxt.getText().isEmpty()) {
                removelbl.setText("Enter the ID");
            } else {
                int userId = Integer.parseInt(IDtxt.getText());
                Boolean check = handler.deleteClass(userId);
                if(check.equals(true)){
                  IDtxt.clear();
                  removelbl.setText("Removed Successfully");  
                }else{
                    removelbl.setText("invalid ID");
                    IDtxt.clear();
                }

            }
        } catch (NumberFormatException ex) {
            removelbl.setText("Invalid ID format");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.trainerView();
    }

}
