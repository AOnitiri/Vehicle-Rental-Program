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
// This program is used to store data as type TruckRates to store rates for Truck rentals
// -----------------------------------------------------------------------------------------------------------/
public class TruckRates extends VehicleRates {
    //constructor
    public TruckRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
 double daily_insur_rate){
        super(daily_rate,weekly_rate,monthly_rate,mileage_chrg,daily_insur_rate);
    }

    
    
    //to String method
    public String toString(){
        return "(Truck) Daily Rate: $" +getDailyRate()+ ", Weekly Rate: $"+ getWeeklyRate()+ ", Monthly Rate: $" + getMonthlyRate()+ ", Mileage charge: $"+ getMileageChrg()+" / miles, Insurance Rate: $" + getDailyInsurRate() +" / day";
    }
}
