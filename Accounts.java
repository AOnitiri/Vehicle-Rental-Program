
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Adesimisola Onitiri
// Assignment 4 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used to store data as type accounts used in conjunction with the Account class
// -----------------------------------------------------------------------------------------------------------/
public class Accounts {
    private Account[] accts;
    private int current;
    
    // constructor
    public Accounts(){
        accts = new Account[50];
        initToNulls(accts);
    }
    
    // general methods
    
    public Account getAccount(String credit_card) throws AccountNotFoundException{
        int index = 0;
        boolean found = false;
        
        while(index < accts.length && !found){
            if(accts[index] != null && accts[index].getCreditCardNum().equals(credit_card))
                found = true;
            else
                index = index + 1;
        } 
        
        // VIN not found if reach end of array
        if(!found)
            throw new AccountNotFoundException();
        
        // return vehicle found
        return accts[index];
    }
    
    public void add(Account acct) throws InsufficientSpaceException{
        accts[findFirstNull(accts)] = acct;
    }
    
    public void remove(String credit_card) throws AccountNotFoundException {
        int index = 0;
        int removed_loc;
        boolean account_found = false;
        
        while(index < accts.length && accts[index] != null && !account_found){
            if (accts[index].getCreditCardNum().equals(credit_card))
                account_found = true;
            else
                index = index + 1;
        }
        
        // VIN not found if reach end of string
        if(!account_found)
            throw new AccountNotFoundException();
        else
            removed_loc = index;
        
        // remove all following vehicles up one location
        for(int i = removed_loc; i < accts.length - 1; i++)
            accts[i] = accts[i+1];
    }
    
    //iterator methods
    
    public void reset(){
        current = 0;
    }
    
    public boolean hasNext(){
    // check if another vehicle to return with changing iterator var current
        
        int index = current;
        
        while(index < accts.length && accts[index] == null)
            index = index + 1;
        
        // vehicle not found if reach end of string
        if(index < accts.length)
            return true;
        else
            return false;
    }   
        
    public Account getNext(){
        return accts[current++];
    }
   
    // supporting methods
    
    private void initToNulls(Account[] accts){
        for(int i = 0; i < accts.length; i++){
            accts[i] = null;
        }
    }
    
    private int findFirstNull(Account[] accts){
        int i = 0;
        while(i < accts.length && accts[i] != null)
            i = i + 1;
        
        if(i == accts.length)
            throw new InsufficientSpaceException();
        
        return i;
    }
    public int size(){
        return accts.length;
    }
}