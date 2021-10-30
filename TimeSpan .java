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
// This program is a TimeSpan class that is used to store data as type TimeSpan
// -----------------------------------------------------------------------------------------------------------
class TimeSpan {
    //declaring private variables
    private char timeUnit;
    private int numUnits;
    private String time;
    //contructor to pass variables into the private variables
    public TimeSpan(char timeUnits, int numUnits){
        this.timeUnit = timeUnit;
        this.numUnits = numUnits;
    }
    //method to return the timeUnit characters
    public char getTimeUnits(){
        return timeUnit;
    }
    //method to return the numUnits value
    public int getNumUnits(){
        return numUnits;
    }
    //method to convert all the variables to string
    public String toString(){
        return "you have rented for "+ numUnits +" "+ timeUnit;
        
    }
    
}
