/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;



import java.util.List;


public class Admin extends User implements Manageable{

    public Admin(String fullName, String PhoneNumber, String DateofBirth, String Email, String PassWord, String Role, int userID) {
        super(fullName, PhoneNumber, DateofBirth, Email, PassWord, Role, userID);
    }
    
   
    
    
    @Override
    public void addUser(User user) {
        System.out.println("Adding user: " + user.getFullName());
    }

    @Override
    public void removeUser(User user) {
        System.out.println("Removing user: " + user.getFullName() );
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Updating user: " + user.getFullName() );
    }

    
    public void displayMenu() {
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Update User");
    }


    
    
}
