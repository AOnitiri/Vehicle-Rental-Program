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
// This program is used to store data as type account
// -----------------------------------------------------------------------------------------------------------/
public class Account {
    private String creditcard_num;
    private String company_name;
    private boolean prime_customer;
    
    public Account(String num, String name, boolean prime){
        creditcard_num = num;
        company_name = name;
        prime_customer = prime;
    }
    
    public String getCreditCardNum(){
        return creditcard_num;
    }
    public String getCompanyName(){
        return company_name;
    }
    public boolean primeCustomer(){
        return prime_customer;
    }
    
    public String toString(){
        return "Card number: " + creditcard_num + ", Company: " + company_name + ", Prime customer: " + prime_customer; 
    }
}
