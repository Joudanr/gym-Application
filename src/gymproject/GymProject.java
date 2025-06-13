/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package gymproject;


//Final
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class GymProject extends Application {

    private static Stage primeryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primeryStage = stage;
        loginView();
        stage.setOnCloseRequest(event -> {
            event.consume();
            handelClose("There is some unsaved info.. ");
        });
    }

    // ------------------- LOGIN --------------------------
    public static void loginView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("login.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("If you exit, all info will be deleted.. ");
            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //---------------- MEMBER CONTROLLES ------------------
    public static void memberView() {
        Parent root;
        try {

            root = FXMLLoader.load(GymProject.class.getResource("memberView.fxml"));
            System.out.println("22");
            Scene scene = new Scene(root);
            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("If you exit, all info will be deleted.. ");
            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }

    }

    public static void groupClassView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("groupClasses.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("If you exit, all info will be deleted.. ");
            });

        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    public static void MemberEditInfoView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("MemberEditInfo.fxml"));
            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");
            });

        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("invaled");
        }
    }

    //---------------- TRAINER CONTROLLES ------------------
    public static void trainerView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("TrainerView.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    public static void editClassView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("EditClass.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    public static void RemoveClassView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("RemoveClass.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    public static void addSeccionView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("addSession.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    public static void trackProgressView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("trackProgress.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //---------------- ADMINISTATOR CONTROLLES ------------------
    public static void administratorView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("administratorView.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //1
    public static void UsersManagementView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("UsersManagement.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //2
    public static void manageGymServicessView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("manageGymServices.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //3
    public static void offersView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("offers.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //1.1
    public static void AddUserView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("addUser.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //1.2
    public static void RemoveUserView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("removeUser.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //1.3
    public static void UpdateUserView() {
        Parent root;
        try {
            root = FXMLLoader.load(GymProject.class.getResource("updateUser.fxml"));

            Scene scene = new Scene(root);

            primeryStage.setScene(scene);
            primeryStage.show();
            primeryStage.setOnCloseRequest(event -> {
                event.consume();
                handelClose("There is some unsaved info.. ");

            });
        } catch (IOException ex) {
            System.out.println("invaled");
        }
    }

    //----------------------------------------
    private static void handelClose(String massage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close App");
        alert.setHeaderText("Are you sure you want to close the App?");
        alert.setContentText(massage);

        if (alert.showAndWait().get() == ButtonType.OK) {
            primeryStage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
