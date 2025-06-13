/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;

import java.util.List;

public class Classes {

    private String className, day, time;
    private int class_id;
    private Trianer trianer;
    private int max_capacity;

    public Classes() {
    }
    
    

    public Classes(String className, String day, String time, int class_id, Trianer trianer, int max_capacity) {
        this.className = className;
        this.day = day;
        this.time = time;
        this.class_id = class_id;
        this.trianer = trianer;
       
        this.max_capacity = max_capacity;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Trianer getTrianer() {
        return trianer;
    }

    public void setTrianer(Trianer trianer) {
        this.trianer = trianer;
    }

    @Override
    public String toString() {
        return "className: " + className + "  (" + time + "PM)";
    }

}
