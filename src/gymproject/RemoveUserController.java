package gymproject;

import database.handler;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uml.User;

public class RemoveUserController {

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
                User user = handler.getUserById(userId);

                if (user != null) {
                    //============Alert
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Remove User");
                    alert.setHeaderText("ALL THE INFORMATION FOR THIS USER WILL BE REMOVED!");
                    alert.setContentText("This User will be removed.");

                    if (alert.showAndWait().get() == ButtonType.OK) {
                        handler.deleteTrackProgress(userId);
                        handler.deleteClassByTrainerId(userId);
                        handler.deleteUser(userId);
                        IDtxt.clear();
                        removelbl.setText("Removed Successfully");
                        System.out.println("User has been removed");
                    }
                    //============
                } else {
                    System.out.println("No such user.");
                    removelbl.setText("Invalid ID");
                }
            }
        } catch (NumberFormatException ex) {
            removelbl.setText("Invalid ID format");
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void back(ActionEvent event
    ) {
        GymProject.UsersManagementView();
    }

}
