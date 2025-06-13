/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml;

public class Service {
    
    private String serviceName;


    public Service(String serviceName) {
        this.serviceName = serviceName;
 
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }



    @Override
    public String toString() {
        return serviceName ;
    }

   
    
}