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
// This program is used to store data as type transactions used in conjuction with the transaction class
// -----------------------------------------------------------------------------------------------------------
public class Transactions {

    private Transaction[] all_transactions;
    private int current;
    
    // constructor
    public Transactions(){
        all_transactions = new Transaction[100];
        initToNulls(all_transactions);
    }
    
    // general methods
    
    public void add(Transaction trans) throws InsufficientSpaceException {
        all_transactions[findFirstNull(all_transactions)] = trans;
    }
    
    //iterator methods
    
    public void reset(){
        current = 0;
    }
    
    public boolean hasNext(){
    // check if another vehicle to return with changing iterator var current
        
        int index = current;
        
        while(index < all_transactions.length && all_transactions[index] == null)
            index = index + 1;
        
        // vehicle not found if reach end of string
        if(index < all_transactions.length)
            return true;
        else
            return false;
    } 
    
    public Transaction getNext(){
        return all_transactions[current++];
    }
        
    private void initToNulls(Transaction[] transactions){
        for(int i = 0; i < transactions.length; i++){
            transactions[i] = null;
        }
    }
    
    private int findFirstNull(Transaction[] trans){
        int i = 0;
        while(i < trans.length && trans[i] != null)
            i = i + 1;
        
        if(i == trans.length)
            throw new InsufficientSpaceException();
        
        return i;
    }

    int size() {
        return all_transactions.length; //To change body of generated methods, choose Tools | Templates.
    }
    }

