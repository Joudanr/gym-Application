package database;

import gymproject.GymProject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import uml.Admin;
import uml.Classes;
import uml.Member;
import uml.Service;
import uml.Trianer;
import uml.User;
import uml.offer;

public class handler {

    private Connection conn = null;

    //=============USER=================
    public void insertUser(String password, String email, String fullName, Date dateOfBirth, String phoneNumber, String role) throws SQLException {
        String sql = "INSERT INTO useerss_ ( password, email, full_name, date_of_birth, phone_number, role) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql)) {
            //stmt.setInt(1, userId);
            stmt.setString(1, password);
            stmt.setString(2, email);
            stmt.setString(3, fullName);
            stmt.setDate(4, dateOfBirth);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, role);
            stmt.executeUpdate();
        }
    }

    // Update User
    public void updateUser(int userId, String password, String email, String fullName, Date dateOfBirth, String phoneNumber, String role) throws SQLException {
        String sql = "UPDATE useerss_ SET password = ?, email = ?, full_name = ?, date_of_birth = ?, phone_number = ?, role =? WHERE user_id = ?";
        try ( PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql)) {
            stmt.setString(1, password);
            stmt.setString(2, email);
            stmt.setString(3, fullName);
            stmt.setDate(4, dateOfBirth);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, role);
            stmt.setInt(7, userId);

            stmt.executeUpdate();
        }
    }

    // Delete User
    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM useerss_ WHERE user_id = ?";
        try ( PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    //Get User By Id
    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM useerss_ WHERE user_id = ?";
        PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        User user = null;
        while (rs.next()) {
            String password = rs.getString("password");
            String email = rs.getString("email");
            String fullName = rs.getString("full_name");
            Date dateOfBirth = rs.getDate("date_of_birth");
            String phoneNumber = rs.getString("phone_number");
            String role = rs.getString("role");

            if (role.equalsIgnoreCase("ADMIN")) {
                user = new Admin(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId);
            } else if (role.equalsIgnoreCase("TRAINER")) {
                user = new Trianer(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId);
            } else if (role.equalsIgnoreCase("MEMBER")) {
                user = new Member(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId);

            }

        }
        return user;
    }

    // Retrieve All Users
    public List<User> retrieveAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, password, email, full_name, date_of_birth, phone_number FROM useerss_";
        try ( PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String fullName = rs.getString("full_name");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String phoneNumber = rs.getString("phone_number");
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("ADMIN")) {
                    users.add(new Admin(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId));
                } else if (role.equalsIgnoreCase("TRAINER")) {
                    users.add(new Trianer(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId));
                } else if (role.equalsIgnoreCase("MEMBER")) {
                    users.add(new Member(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId));

                }
            }

        }
        return users;
    }
//
//    
//    public List<Member> retrieveAllMembers() {
//        List<Member> members = new ArrayList<>();
//        String sql = "SELECT * FROM useerss_ WHERE role = 'MEMBER'";
//
//        try ( Connection conn = DataBaseConnection.getInstance().getCon();  PreparedStatement stmt = conn.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                int userId = rs.getInt("user_id");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//                String fullName = rs.getString("full_name");
//                Date dateOfBirth = rs.getDate("date_of_birth");
//                String phoneNumber = rs.getString("phone_number");
//                String role = rs.getString("role");
//
//                // Check if the role is "MEMBER"
//                if (role.equalsIgnoreCase("MEMBER")) {
//                    members.add(new Member(fullName, phoneNumber, dateOfBirth.toString(), email, password, role, userId));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return members;
//    }

    //===============Classes=====================
    public void insertClass(String className, String day, String time, int max_capacity, int trainerId) throws SQLException {
        String sql = "INSERT INTO Classes__ (class_name, day, time, max_capacity, trainer_id) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = DataBaseConnection.getInstance().getCon();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, className);
            stmt.setString(2, day);
            stmt.setString(3, time);
            stmt.setInt(4, max_capacity);
            stmt.setInt(5, trainerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Class
    public boolean updateClass(int classId, String className, String time) {
        String checkSql = "SELECT class_id FROM Classes__ WHERE class_id = ?";
        String updateSql = "UPDATE Classes__ SET class_name = ?, time = ? WHERE class_id = ?";

        try ( Connection conn = DataBaseConnection.getInstance().getCon()) {

            // Step 1: Check if the class_id exists in the database
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, classId);
            ResultSet rs = checkStmt.executeQuery();

            // If no class_id is found, return false
            if (!rs.next()) {
                return false;
            }

            // Step 2: If class_id exists, perform the update
            PreparedStatement stmt = conn.prepareStatement(updateSql);
            stmt.setString(1, className);
            stmt.setString(2, time);
            stmt.setInt(3, classId);

            int rowsUpdated = stmt.executeUpdate();

            // If the update was successful, return true
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false in case of an exception
        }
    }

    public boolean deleteClass(int classId) {
        String checkSql = "SELECT class_id FROM Classes__ WHERE class_id = ?";
        String deleteSql = "DELETE FROM Classes__ WHERE class_id = ?";

        try ( Connection conn = DataBaseConnection.getInstance().getCon()) {

            // Step 1: Check if the class_id exists in the database
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, classId);
            ResultSet rs = checkStmt.executeQuery();

            // If no class_id is found, return false
            if (!rs.next()) {
                return false;  // Class ID does not exist
            }

            // Step 2: If class_id exists, proceed with the deletion
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setInt(1, classId);

            int rowsDeleted = deleteStmt.executeUpdate();

            // If the class was deleted successfully, return true
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false in case of an error
        }
    }

    public boolean deleteClassByTrainerId(int trainerId) throws SQLException {
        String checkSql = "SELECT trainer_id FROM Classes__ WHERE trainer_id = ?";  // Check if trainer_id exists
        String deleteSql = "DELETE FROM Classes__ WHERE trainer_id = ?";  // Delete the class records for the given trainer_id

        try ( Connection conn = DataBaseConnection.getInstance().getCon();  PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            // Step 1: Check if the trainer_id exists in the database
            checkStmt.setInt(1, trainerId);
            try ( ResultSet rs = checkStmt.executeQuery()) {
                if (!rs.next()) {
                    // If trainer_id is not found, return false
                    return false;
                }
            }

            // Step 2: If trainer_id exists, perform the deletion
            try ( PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                deleteStmt.setInt(1, trainerId);
                int rowsDeleted = deleteStmt.executeUpdate();

                // If the deletion was successful (at least one row affected), return true
                return rowsDeleted > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if an error occurs
        }
    }

    public List<Classes> retrieveAllClasses() {
        List<Classes> classes = new ArrayList<>();
        String sql = "SELECT * FROM Classes__ ";

        try ( Connection conn = DataBaseConnection.getInstance().getCon();  PreparedStatement stmt = conn.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int classId = rs.getInt("class_id");
                String className = rs.getString("class_name");
                String day = rs.getString("day");
                String time = rs.getString("time");
                int maxCapacity = rs.getInt("max_capacity");
                int trainerid = rs.getInt("trainer_id");

                Trianer t = new Trianer(" ", " ", " ", " ", " ", " ", trainerid);
                // List<Member> m = retrieveAllMembers();
                classes.add(new Classes(className, day, time, classId, t, maxCapacity));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    //========================
    public void insertTrackProgress(int memberId, double weight, double height, String musclePercentage, String fatPercentage) throws SQLException {
        String sql = "INSERT INTO traProgres__ (member_id, weight, height, MusclePercentage, FatPercentage) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = DataBaseConnection.getInstance().getCon();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, memberId);
            stmt.setDouble(2, weight);
            stmt.setDouble(3, height);
            stmt.setString(4, musclePercentage);
            stmt.setString(5, fatPercentage);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteTrackProgress(int id) throws SQLException {
        String checkSql = "SELECT member_id FROM traProgres__ WHERE member_id = ?";
        String deleteSql = "DELETE FROM traProgres__ WHERE member_id = ?";

        try ( Connection conn = DataBaseConnection.getInstance().getCon();  PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            // Check if the member_id exists
            checkStmt.setInt(1, id);
            try ( ResultSet rs = checkStmt.executeQuery()) {
                if (!rs.next()) {
                    // If member_id is not found, return false
                    return false;
                }
            }

            //If member_id exists
            try ( PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                deleteStmt.setInt(1, id);
                int rowsDeleted = deleteStmt.executeUpdate();

                return rowsDeleted > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if an exception occurs
        }
    }

    //========================
    public void insertOffer(String coupon, String occasion, String discount, String expireDate) throws SQLException {
        String sql = "INSERT INTO Offer (coupon, occasion, discount, expireDate) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        conn = DataBaseConnection.getInstance().getCon();

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, coupon);
            stmt.setString(2, occasion);
            stmt.setString(3, discount);
            stmt.setString(4, expireDate);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
        }
    }

    public List<offer> getAllOffers() throws SQLException {
        String sql = "SELECT * FROM Offer";
        List<offer> offers = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DataBaseConnection.getInstance().getCon();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

                offers.add(new offer(
                        rs.getString("coupon"),
                        rs.getString("occasion"),
                        rs.getString("discount"),
                        rs.getString("expireDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            closeStatement(stmt);
        }
        return offers;
    }

    //========================Service=================================================================
    public void insertService(String serviceName) {
        String sql = "INSERT INTO services (service_name) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            conn = DataBaseConnection.getInstance().getCon();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, serviceName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
        }
    }

    public void deleteService(String serviceName) throws SQLException {
        String sql = "DELETE FROM services WHERE service_name = ?";
        try ( PreparedStatement stmt = DataBaseConnection.getInstance().getCon().prepareStatement(sql)) {
            stmt.setString(1, serviceName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Service> getAllServices() throws SQLException {
        String sql = "SELECT * FROM services";
        List<Service> services = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DataBaseConnection.getInstance().getCon();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                services.add(new Service(rs.getString("service_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            closeStatement(stmt);
        }
        return services;
    }

    //==============================================================
    
    private void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
