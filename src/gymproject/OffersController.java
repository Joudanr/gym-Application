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


public class OffersController  {

    @FXML
    private TextField coupontxt;

    @FXML
    private TextField occasiontxt;

    @FXML
    private TextField discounttxt;
    
     @FXML
    private TextField ExpirDate;

    @FXML
    private Label resultlbl;
    
     private handler handler = new handler();

    @FXML
    private void handleSubmit() throws SQLException {
        String couponval = coupontxt.getText();
        String occasion = occasiontxt.getText();
        String discount = discounttxt.getText();
        String ExpirDatee = ExpirDate.getText();
       
        
        if (!coupontxt.getText().isEmpty() && !occasiontxt.getText().isEmpty() &&
            !discounttxt.getText().isEmpty() && !ExpirDate.getText().isEmpty()) {
            handler.insertOffer(couponval, occasion, discount, ExpirDatee);
            resultlbl.setText("Discount " + discounttxt.getText() + "% is added successfully.");
        } else {
            resultlbl.setText("Some field is empty");
        }
    }

    
    @FXML
      private void back(ActionEvent event){
          GymProject.administratorView();
      } 
    
}
