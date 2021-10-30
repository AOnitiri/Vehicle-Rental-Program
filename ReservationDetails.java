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
// This program is used to hold inforamation about reservation
// -----------------------------------------------------------------------------------------------------------
class ReservationDetails {
    String VIN;
   String acctNum;
   TimeSpan rentalPeriod;
   boolean insuranceOpted;

   public ReservationDetails(String VIN, String acctNum, TimeSpan rentalPeriod, boolean insuranceOpted)
   {
       this.VIN = VIN;
       this.acctNum = acctNum;
       this.rentalPeriod = rentalPeriod;
       this.insuranceOpted = insuranceOpted;
   }

   public String getVIN()
   {
       return VIN;
   }

   public String getAcctNum()
   {
       return acctNum;
   }

   public TimeSpan getRentalPeriod()
   {
       return rentalPeriod;
   }

   public boolean isInsuranceOpted()
   {
       return insuranceOpted;
   }
}
