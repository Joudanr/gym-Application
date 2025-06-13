
package uml;

public class Member extends User {

    public Member(String fullName, String PhoneNumber, String DateofBirth, String Email, String PassWord, String Role, int userID) {
        super(fullName, PhoneNumber, DateofBirth, Email, PassWord, Role, userID);
    }
    
   

    @Override
    public String toString() {
        return "Member{" + super.toString() + '}';
    }

    
    

    
    
    
    
    

}