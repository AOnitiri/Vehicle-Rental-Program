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
// This program car class that is used to store data as type car
// -----------------------------------------------------------------------------------------------------------
public class Car extends Vehicle {
    //declairing  private variables
    private int seating;
    //constructor to pass data into the vehicle class and into the private variables 
    public Car(String description, int mpg, int seating,String vin){
        super(description,mpg,vin);
        this.seating=seating;
    }
    //Method to convert the variables into a string
     public String toString(){
         return   super.getDescription() + "(Car), MPG: " + super.getMPG()+ " Seating: "+ seating+ " VIN: " + super.getVIN();
     }
    
}
