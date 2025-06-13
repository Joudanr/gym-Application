/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;


import database.handler;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uml.Service;


public class ManageGymServicesController  {

    @FXML
    private ComboBox<String> servicesComboBox; 

    @FXML
    private Label addlbl;
    @FXML
    private Label removelbl; 
    @FXML
    private Label lbl;

    @FXML
    private TextField addServicetxt;


    private ObservableList<String> gymServices;
    private handler handler = new handler();

    @FXML
    public void initialize()  throws SQLException{
        List<Service> list = handler.getAllServices();
        for (Service ele : list) {
           servicesComboBox.getItems().add(ele.toString());
        }
    }

    @FXML
    private void handleAddService(ActionEvent event) {
        lbl.setText("");
        
        String newService = addServicetxt.getText();
        if (!newService.isEmpty()) {
            handler.insertService(newService);
           servicesComboBox.getItems().add(newService);
            addServicetxt.clear(); 
            lbl.setText("Added ");
        } else {
            lbl.setText("Please enter a service to add.");
        }
    }

    @FXML
    private void handleRemoveService(ActionEvent event) throws SQLException {
        lbl.setText("");
        String selectedService = servicesComboBox.getSelectionModel().getSelectedItem();  // Get the selected service
        
        if (selectedService != null) {
            handler.deleteService(selectedService);

            int index = servicesComboBox.getSelectionModel().getSelectedIndex();
            servicesComboBox.getItems().remove(index);
           lbl.setText("Removed");
        } else {
            lbl.setText("Please select a service to remove.");
        }
    }
    

    @FXML
    private void back(ActionEvent event){
        GymProject.administratorView();
    } 
}

