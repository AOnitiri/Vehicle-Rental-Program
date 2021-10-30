/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Adesimisola Onitiri
// Assignment 5 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used to hold inforamation about rentals
// -----------------------------------------------------------------------------------------------------------
public class RentalDetails {
   String vehicleType;
   int numMilesDriven;
   boolean primeCustomer;
   String rentalPeriod;
   boolean insurance;

   public RentalDetails(String vehicleType, int numMilesDriven, String rentalPeriod,boolean ins, boolean primeCustomer)
   {
       this.vehicleType = vehicleType;
       this.numMilesDriven = numMilesDriven;
       this.primeCustomer = primeCustomer;
       this.rentalPeriod = rentalPeriod;
       this.insurance = ins;
   }

   public String getVehicleType()
   {
       return vehicleType;
   }

   public int getNumMilesDriven()
   {
       return numMilesDriven;
   }

   public boolean primeCustomer()
   {
       return primeCustomer;
   }

   public String getRentalPeriod()
   {
       return rentalPeriod;
   }

   public boolean isInsuranceOpted()
   {
       return insurance;
   }
}
