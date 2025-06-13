/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.SessionInfo;
import database.handler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import uml.User;
import uml.offer;

public class MemberViewController {

    @FXML
    private Label memberNumlbl;
    @FXML
    private Label namelbl;

    @FXML
    private ComboBox oferCompo;
    
    @FXML
    private Text classtxt;

    private handler handler = new handler();


    private void upcomingClass() {
        List<String> list = GroupClassesController.memberClass;
        if(list == null){
        list = new ArrayList<>();
        }
        if(!list.isEmpty())
        for (String ele : list) {
            classtxt.setText(ele + "\n");
        }else{
         classtxt.setText("You didn't schedule anything");
        }

    }

    public void showOffer() throws SQLException {
        List<offer> list = handler.getAllOffers();

        for (offer ele : list) {
            oferCompo.getItems().add(ele.toString());
        }
        System.out.println("end showOffer");
    }


    @FXML
    private void handleGroupClass(ActionEvent event) {
        GymProject.groupClassView();
    }

    @FXML
    private void handleEditProfile(ActionEvent event) {
        GymProject.MemberEditInfoView();
    }

    @FXML
    public void initialize() {
        try {
            showOffer();
            upcomingClass();
            User user = SessionInfo.getInstance().getCurrentUser();
            int userId = user.getUserID();
            memberNumlbl.setText(String.valueOf(userId));
            namelbl.setText(user.getFullName());
        } catch (SQLException ex) {
            System.out.println("Exception");
        }

    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.loginView();
    }

}
