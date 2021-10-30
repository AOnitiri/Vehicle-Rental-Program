/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Adesimisola Onitiri
// Assignment 4 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used to store data as type transaction. stores it by using card number, company name, vehicle type, rental period and rental cost
// -----------------------------------------------------------------------------------------------------------/
public class Transaction {
    private String creditcard_num;
    private String company_name;
    private String vehicle_type; // car, SUV or Truck
    private String rental_period; // days, week, months
    private String rental_cost;

    public Transaction(String card, String name, String type, String period, String cost){
        creditcard_num = card;
        company_name = name;
        vehicle_type = type;
        rental_period = period;
        rental_cost = cost;
    }
    
    public String toString(){
        return "Card: " + creditcard_num + ", Company name: " + company_name + ", Vehicle type: " + vehicle_type + ", Rental Period: " + rental_period + ", Rental Cost: " + rental_cost;
    }
}
