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
// This program is a SUV class that is used to store data as type SUV
// -----------------------------------------------------------------------------------------------------------
public class SUV extends Vehicle {
    //declaring private variables
    private int seating;
    private int cargo;
    //constructor that is used to pass data into the private variables
    public SUV(String description, int mpg, int seating,int cargo,String vin){
        super(description,mpg,vin);
        this.seating=seating;
        this.cargo = cargo;
    }
    
     public String toString(){
         return  super.getDescription() + "(SUV), MPG: " + super.getMPG()+ " Seating: "+ seating+ " Storage: " + cargo + " cu. ft"+" VIN: " + super.getVIN();
     }
    
}

