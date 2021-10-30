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
// This program is a reservation class that is used to store data as type reservation
// -----------------------------------------------------------------------------------------------------------
public class Reservation {
    //declaring private variables
    private String creditCardNum;
    private TimeSpan rentalPeriod;
    private boolean insuranceSelected;
    //constructor that is used to pass data into the private variables
    public Reservation(String creditCardNum,TimeSpan rentalPeriod, boolean insuranceSelected){
        this.creditCardNum = creditCardNum;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }
    //method to return the credit card number
    public String getCardNum(){
        return creditCardNum;
    }
    //method to return the value stored in the rental period data type
    public TimeSpan getRentalPeriod(){
        return rentalPeriod;
    }
    //method to return boolean of if insurance is selected
    public boolean getIsInsuranceSelected(){
        return insuranceSelected == true;
    }
    //method to convert all the variables into one string 
    public String toString(){
        return "Card number is " + creditCardNum + ", rental period is "+ rentalPeriod + " , insurance: " + getIsInsuranceSelected();   
    }
        
    
}
