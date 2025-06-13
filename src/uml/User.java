/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;


public abstract class User {

    private String fullName, PhoneNumber, DateofBirth, Email, PassWord, Role;
    private int userID;

    public User(String fullName, String PhoneNumber, String DateofBirth, String Email, String PassWord, String Role, int userID) {
        this.fullName = fullName;
        this.PhoneNumber = PhoneNumber;
        this.DateofBirth = DateofBirth;
        this.Email = Email;
        this.PassWord = PassWord;
        this.Role = Role;
        this.userID = userID;
    }

    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", PhoneNumber=" + PhoneNumber + ", DateofBirth=" + DateofBirth + ", Email=" + Email + ", PassWord=" + PassWord + ", Role=" + Role + ", userID=" + userID + '}';
    }

}
