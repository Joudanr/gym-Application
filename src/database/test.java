package database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import uml.Member;
import uml.Service;
import uml.offer;

public class test {

    public static void main(String[] args) {
        handler dbHandler = null;

        try {
            dbHandler = new handler();
            dbHandler.getUserById(2);

//            dbHandler.insertUser("48922", "1@gmail.com", "user1", Date.valueOf("1995-05-15"), "051", "MEMBER");
//            System.out.println("User inserted successfully.");
//           =======================================================================
//            dbHandler.updateUser(1, "123", "1@gmail.com", "Layan", Date.valueOf("1995-05-15"), "052", "TRAINER");
//            System.out.println("User Update successfully.");
//           =======================================================================
//            dbHandler.deleteUser(1);
//            System.out.println("User delete successfully.");
//           =======================================================================
//              dbHandler.insertUser("48922", "4@gmail.com", "user5", Date.valueOf("1995-05-15"), "051", "MEMBER");
//              dbHandler.insertUser("48922", "6@gmail.com", "user6", Date.valueOf("1995-05-15"), "051", "MEMBER");
//              System.out.println("User inserted successfully.");
            //System.out.println(dbHandler.getTrainerDetails(99));  
            //System.out.println(dbHandler.retrieveAllClassesforT(25));
//            System.out.println(dbHandler.getClassById(2));
            //dbHandler.deleteClass(2);
//           dbHandler.insertService("CCC");
//            System.out.println("service added");
//
//dbHandler.deleteService("DDD");
//dbHandler.deleteService("FFF");
//dbHandler.deleteService("EEE");
//            System.out.println("deleted");
//           List<Service> list  = dbHandler.getAllServices();
//            System.out.println(list);
//            dbHandler.deleteUser(28);
//            System.out.println("removed");

boolean a = dbHandler.deleteTrackProgress(25);
if(a){
   System.out.println("removed");  
}else{
    System.out.println("aaa");
}

//            List<Member> m = dbHandler.retrieveAllMembers();
//            System.out.println(m);
//              dbHandler.insertTrackProgress(29, 50.0, 160.0,"9", "7");
//              System.out.println("progress added");
//            dbHandler.insertOffer("15", "FatherDay","20%", "2024-12-03");
//            System.out.println("Offer is added");
//             List<offer> o =dbHandler.getAllOffers();
//             System.out.println(o);
//           dbHandler.insertOffer("58wrrrr344h", "mothers day", "10%", "11-5");
//           System.out.println("User inserted successfully.");
//            
//           dbHandler.insertAdmin(14344, "Admin Name", "admin@example.com", "555-1234");
//           System.out.println("Admin inserted successfully.");
//// int classId, String className, String day, String time, int max_capacity)
//          dbHandler.insertClass(32455553,"Yoa", "monday", "09:00:00", 56);
//          System.out.println("Class inserted successfully.");
////
//          dbHandler.insertMember(358536353, "Active", Date.valueOf("2023-01-01"));
//          System.out.println("Member inserted successfully.");
////
//        dbHandler.insertService("Personal Training");//          Missing IN or OUT parameter at index: 2
//
//          System.out.println("Service inserted successfully.");
//            System.out.println(dbHandler.getAllOffers());
//            System.out.println(dbHandler.retrieveAllUsers());// error table or view does not exist
////
//          dbHandler.insertTrainer(53532534, "Yoga Instructor", Date.valueOf("2022-06-01"));
//          System.out.println("Trainer inserted successfully.");
//      insertMembership(int classId, int memberId, String membershipType, Date startDate, Date endDate)
//        dbHandler.insertMembership(32, 878, "Monthly", Date.valueOf("2023-01-01"), Date.valueOf("2023-02-01"));
//        System.out.println("Membership inserted successfully.");
        } catch (Exception e) {
            if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
                System.out.println("Error: username is taken.");
            }
            e.printStackTrace();

        }
    }
}
