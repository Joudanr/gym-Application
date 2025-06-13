/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;

/**
 *
 * @author leuna
 */
public class TrackProgress {
    
    private Member memberID;
    double weight, height;
    private String MusclePercentage , FatPercentage;

    public TrackProgress(Member memberID, double weight, double height, String MusclePercentage, String FatPercentage) {
        this.memberID = memberID;
        this.weight = weight;
        this.height = height;
        this.MusclePercentage = MusclePercentage;
        this.FatPercentage = FatPercentage;
    }

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getMusclePercentage() {
        return MusclePercentage;
    }

    public void setMusclePercentage(String MusclePercentage) {
        this.MusclePercentage = MusclePercentage;
    }

    public String getFatPercentage() {
        return FatPercentage;
    }

    public void setFatPercentage(String FatPercentage) {
        this.FatPercentage = FatPercentage;
    }

    @Override
    public String toString() {
        return "TrackProgress{" + "memberID=" + memberID + ", weight=" + weight + ", height=" + height + ", MusclePercentage=" + MusclePercentage + ", FatPercentage=" + FatPercentage + '}';
    }
     
    
}
