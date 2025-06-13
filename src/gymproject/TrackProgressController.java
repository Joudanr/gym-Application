/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gymproject;

import database.handler;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uml.User;

public class TrackProgressController implements Initializable {

    @FXML
    private Label invalid;

    @FXML
    private Label result;

    @FXML
    private Label submit;

    @FXML
    private TextField ID;
    @FXML
    private TextField weight;
    @FXML
    private TextField height;
    @FXML
    private TextField MusclePercentage;
    @FXML
    private TextField FatPercentage;

    private handler handler = new handler();

    @FXML
    private void handelShow(ActionEvent event) {

        try {
            if (ID.getText().isEmpty()) {
                invalid.setText("Enter the ID");
            } else {
                int userId = Integer.parseInt(ID.getText());
                User user = handler.getUserById(userId);

                if (user != null) {
                    weight.setEditable(true);
                    height.setEditable(true);
                    MusclePercentage.setEditable(true);
                    FatPercentage.setEditable(true);

                    invalid.setText("Correct ID");

                } else {
                    weight.setEditable(false);
                    height.setEditable(false);
                    MusclePercentage.setEditable(false);
                    FatPercentage.setEditable(false);
                    System.out.println("No such user.");
                    invalid.setText("Invalid ID");

                }
            }
        } catch (NumberFormatException ex) {
            invalid.setText("Invalid ID format");
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void handelSubmit(ActionEvent event) throws SQLException {
        String FatPercentageval = FatPercentage.getText();
        String MusclePercentageval = MusclePercentage.getText();
        String weightval = weight.getText();
        String heightval = height.getText();
        String idt = ID.getText();

        if (!FatPercentage.getText().isEmpty() && !MusclePercentage.getText().isEmpty()
                && !weight.getText().isEmpty() && !height.getText().isEmpty()) {
            int id = Integer.parseInt(idt);
            User user = handler.getUserById(id);
            if (user != null) {
                double w = Double.parseDouble(weightval);
                double h = Double.parseDouble(heightval);

                String mss = calc(w, h);
                handler.insertTrackProgress(id, w, h, MusclePercentageval, FatPercentageval);
                result.setText(mss);
                submit.setText("Added Successfully");
            } else {
                invalid.setText("invalid ID");
            }
        } else {
            submit.setText("Some field is empty");

        }
    }

    @FXML
    private void back(ActionEvent event) {
        GymProject.trainerView();
    }

    public String calc(double weightVal, double heightValCm) {
        double heightValM = heightValCm / 100;

        if (heightValM == 0) {
            return "Invalid height";
        }

        double bmi = weightVal / (heightValM * heightValM);

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        weight.setEditable(false);
        height.setEditable(false);
        MusclePercentage.setEditable(false);
        FatPercentage.setEditable(false);
    }

}
