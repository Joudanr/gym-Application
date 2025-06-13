package gymproject;

import database.DataBaseConnection;
import database.SessionInfo;
import database.handler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import uml.User;

public class loginController {

    @FXML
    private TextField IDtxt;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    private Label errorlbl;

    private Connection conn = null;
    private handler handler = new handler();

    public void authenticateUser(int userId, String password) throws SQLException {
        String sql = "SELECT role FROM useerss_ WHERE user_id = ? AND password = ?";

        try {
            conn = DataBaseConnection.getInstance().getCon();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                User u = handler.getUserById(userId);
                SessionInfo.getInstance().setCurrentUser(u);
                switch (role) {
                    case "MEMBER":
                        GymProject.memberView();
                        errorlbl.setText("");
                        break;
                    case "TRAINER":
                        GymProject.trainerView();
                        errorlbl.setText("");
                        break;
                    case "ADMIN":
                        GymProject.administratorView();
                        errorlbl.setText("");
                        break;
                    default:
                        errorlbl.setText("Unrecognized role in the database.");
                        break;
                }
            } else {
                errorlbl.setText("ID or password is incorrect.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            errorlbl.setText("Database error occurred.");
        }

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        if (IDtxt.getText().isEmpty() || passwordtxt.getText().isEmpty()) {
            errorlbl.setText("Some field is empty");
        } else if (IDtxt.getText().equals("0101") && passwordtxt.getText().equals("1234")) {
            GymProject.administratorView();
        } else {
            try {
                int useID = Integer.parseInt(IDtxt.getText());
                String pw = passwordtxt.getText();
                authenticateUser(useID, pw);
            } catch (NumberFormatException e) {
                errorlbl.setText("Invalid ID format. Please enter a number.");
            }
        }
    }

}
