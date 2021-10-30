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
// This program is a Truck class that is used to store data as type Truck
// -----------------------------------------------------------------------------------------------------------
public class Truck extends Vehicle {
    //declaring private variable
   private int load;
   //constructor that is used to pass data into the private variables and the super class
    public Truck(String description, int mpg,int load,String vin){
        //super
        super(description,mpg,vin);
        //assign values into the private
        this.load = load;
        
    }
    //method to convert to the variable to a string
     public String toString(){
         return super.getDescription() + "(Truck), MPG: " + super.getMPG()+" Load capacity: " + load+" Ibs" + " VIN: " + super.getVIN();
     }
    
}
