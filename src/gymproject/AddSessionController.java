package gymproject;

import database.handler;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uml.User;

public class AddSessionController {

    @FXML
    private TextField nametxt;
    @FXML
    private TextField daytxt;
    @FXML
    private TextField timetxt;
    @FXML
    private TextField seatstxt;
    @FXML
    private TextField idtxt;
    @FXML
    private Label lbl;

    private handler handler = new handler();

    @FXML
    private void handelAdd(ActionEvent event) throws SQLException {
        String name = nametxt.getText();
        String day = daytxt.getText();
        String time = timetxt.getText();
        String seats = seatstxt.getText();
        String id = idtxt.getText();

        if (!name.isEmpty() && !day.isEmpty() && !time.isEmpty() && !seats.isEmpty()) {
            try {
                int seat = Integer.parseInt(seats);
                int Tid = Integer.parseInt(id);

                User user = handler.getUserById(Tid);

                if (user == null) {
                    lbl.setText("Trainer with this ID does not exist.");
                    idtxt.clear();
                } else if (!user.getRole().equals("TRAINER")) {
                    lbl.setText("This ID does not have trainer privileges!");
                    idtxt.clear();
                } else {
                    
                    handler.insertClass(name, day, time, seat, Tid);
                    lbl.setText("Class added successfully");
                }
            } catch (NumberFormatException e) {
                lbl.setText("Invalid input for seats or ID. Please enter numbers.");
            } catch (SQLException e) {
                lbl.setText("Error adding class: " + e.getMessage());
                e.printStackTrace(); 
            }
        } else {
            lbl.setText("Some fields are empty.");
        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.trainerView();
    }

}
