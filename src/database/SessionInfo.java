/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import uml.User;

public class SessionInfo {

    private static SessionInfo instance;
    private User currentUser;

    private SessionInfo() {
    }

    public static SessionInfo getInstance() {
        if (instance == null) {
            instance = new SessionInfo();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
//
//    public Classes getCurrentClass() {
//        return currentClass;
//    }
//
//    public void setCurrentClass(Classes currentClass) {
//        this.currentClass = currentClass;
//    }
    
    
}