/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Adesimisola Onitiri
// Assignment 4 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is a vehicles class that is can be used to manipulate the data in the array 
// -----------------------------------------------------------------------------------------------------------
public class Vehicles{
    //declaring private variables
    private Vehicle[] agency_vehicles = new Vehicle[25] ; 
    private int current;
    static Scanner cin = new Scanner(System.in);
    
    //default contructor
    public Vehicles(){
        //assigning values to the array
        current = 0;
        agency_vehicles[0] = new Car("Chevrolet Camaro - 2018",30,2,"HK4GM4564GD");
        agency_vehicles[1] = new Car("Ford Fusion - 2018",34,2,"AB4EG5689GM");
        agency_vehicles[2] = new Car("Ford Fusion Hybrid - 2017",32,4,"KU4EG3245RW");
        agency_vehicles[3] = new Car("Chevrolet Impala - 2019",30,4,"RK3BM4356YH");
        
        agency_vehicles[4] = new SUV("Honda Odyssey - 2020",28,7,6,"VM9RE2635TD");
        agency_vehicles[5] = new SUV("Dodge Caravan - 2019",25,5,4,"QK3FL4273ME");
        agency_vehicles[6] = new SUV("Ford Expedition - 2018",20,5,3,"JK2RT9264HY");
        
        agency_vehicles[7] = new Truck("Ten-Foot",12,2810,"EJ5KU2435BC");
        agency_vehicles[8] = new Truck("Eighteenteen-Foot",10,5930,"KG4DM5472RK");
        agency_vehicles[9] = new Truck("Twenty-Four-Foot",8,6500,"EB2WR3082QB");
        agency_vehicles[10] = new Truck("Twenty-Four-Foot",8,6500,"TV3GH4290EK");
        
    }
    
    
    
  
    public Vehicle getVehicle(String vin) throws VINNotFoundException{
        int index = 0;
        boolean found = false;
        
        while(index < agency_vehicles.length && !found){
            if(agency_vehicles[index] != null && agency_vehicles[index].getVIN().equals(vin))
                found = true;
            else
                index = index + 1;
        } 
        
        // VIN not found if reach end of array
        if(!found)
            throw new VINNotFoundException();
        
        // return vehicle found
        return agency_vehicles[index];
    }
    
    public void add(Vehicle veh) throws ArrayFullException{
        
       for(int i=0; i<agency_vehicles.length;i++){
           if(agency_vehicles[i] == null){
               agency_vehicles[i] = veh;
               break;
           }
       }
    }
    
    
    public void remove(String VIN) throws VINNotFoundException {
        int index = 0;
        int removed_loc;
        boolean vehicle_found = false;
        
        while(index < agency_vehicles.length && agency_vehicles[index] != null && !vehicle_found){
            if (agency_vehicles[index].getVIN().equals(VIN))
                vehicle_found = true;
            else
                index = index + 1;
        }
        
        // VIN not found if reach end of string
        if(!vehicle_found)
            throw new VINNotFoundException();
        else
            removed_loc = index;
        
        // remove all following vehicles up one location
        for(int i = removed_loc; i < agency_vehicles.length - 1; i++)
            agency_vehicles[i] = agency_vehicles[i+1];
    }
    
    //iterator methods
    
    public void reset(){
        current = 0;
    }
    
    public boolean hasNext(){
    // check if another vehicle to return with changing iterator var current
        
        int index = current;
        
        while(index < agency_vehicles.length && agency_vehicles[index] == null)
            index = index + 1;
        
        // vehicle not found if reach end of string
        if(index < agency_vehicles.length)
            return true;
        else
            return false;
    }   
        
    public Vehicle getNext(){
        return agency_vehicles[current++];
    }
   
    // supporting methods
    
    private void initToNulls(Vehicle[] vehs){
        for(int i = 0; i < vehs.length; i++){
            vehs[i] = null;
        }
    }
    
    private int findFirstNull(Vehicle[] vehs){
        int i = 0;
        while(i < vehs.length && vehs[i] != null)
            i = i + 1;
        
        if(i == vehs.length)
            throw new ArrayFullException();
        
        return i;
    }
}
