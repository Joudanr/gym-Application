/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;



public class Trianer extends User {

    public Trianer(String fullName, String PhoneNumber, String DateofBirth, String Email, String PassWord,  String Role, int userID) {
        super(fullName, PhoneNumber, DateofBirth, Email, PassWord, Role, userID);
    }

    @Override
    public String toString() {
        return "Trianer{"+ super.toString()+ '}';
    }
    
   
    
 
}