package gymproject;

import database.handler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import uml.Classes;

public class GroupClassesController {

    @FXML
    private ComboBox<String> classComboBox;

    @FXML
    private Label lbl;

    private handler handler = new handler();

    public static List<String> memberClass;

    public void showClass() throws SQLException {
        List<Classes> list = handler.retrieveAllClasses();
        for (Classes ele : list) {
            classComboBox.getItems().add(ele.toString());
        }
    }

    @FXML
    private void handleJoin(ActionEvent event) {

        String selectedClass = classComboBox.getSelectionModel().getSelectedItem();  // Get the selected service
        memberClass = new ArrayList<>();

        if (selectedClass != null) {
            memberClass.add(selectedClass);
            lbl.setText("You join a class");
        } else {
            lbl.setText("Please select a class");
        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.memberView();
    }

    @FXML
    public void initialize() throws SQLException {
        showClass();
    }
}
