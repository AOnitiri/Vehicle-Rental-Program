/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Adesimisola Onitiri
// Assignment 3 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is a abstract classs that is used to store data types SUV, Car and Truck 
// -----------------------------------------------------------------------------------------------------------
public abstract class Vehicle{
    //declaring private variables
    private String description;
    private int mpg;
    private String vin;
    private Reservation resv;
    //contructor to pass values into the class
    public Vehicle(String description, int mpg, String vin){
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;
    }
    // method to get the MPG value
    public int getMPG(){
        return mpg;
    }
    // method to get the VIN value
    public String getVIN(){
        return vin;
    }
    //method to return the value of the description
    public String getDescription(){
        return description;
    }
    //method to return the reservation made
    public Reservation getReservation(){
        return resv;
    }
    //abstrack method for other classes to use
    public abstract String toString();
    //method to return boolean value
    public boolean isReserved(){
        if(resv == null){
            return false;
        }
        else
            return true;
    }
    //method to change to private reservation value
    public void reserve(Reservation r) throws ReservedVehicleException{
       if(resv != null){
           throw new ReservedVehicleException();
       }
       else{
          resv = r;
    }
    }
    // method to set the reservation value to null
    public void cancelReservation() throws UnReservedVehicleException{
        if(resv == null)
            throw new UnReservedVehicleException();
        resv = null;  
    }
}
