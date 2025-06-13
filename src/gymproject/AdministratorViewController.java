/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class AdministratorViewController  {

    @FXML
    private void handelUsersManagement(ActionEvent event){
       GymProject.UsersManagementView();
    }
    
    @FXML
    private void handelManageGymServicess(ActionEvent event){
       GymProject.manageGymServicessView();
    }
    @FXML
    private void handelOffers(ActionEvent event){
       GymProject.offersView();
    }
   
    @FXML
      private void back(ActionEvent event){
          GymProject.loginView();
      }
    
}
