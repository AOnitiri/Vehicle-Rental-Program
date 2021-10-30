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
// This abstract program is used to store data as type carRates,SUVRates and TruckRates
// -----------------------------------------------------------------------------------------------------------
public abstract class VehicleRates {
//variables
    private double daily;
    private double weekly;
    private double monthly;
    private double mileage_charge;
    private double daily_insur_rate;
    //constructor
    public VehicleRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
 double daily_insur_rate){
        daily = daily_rate;
        weekly = weekly_rate;
        monthly = monthly_rate;
        mileage_charge = mileage_chrg;
        this.daily_insur_rate = daily_insur_rate;
    }
    //get daily rate
    public  double getDailyRate(){
        return daily;
    }
//get weekly rates
    public  double getWeeklyRate(){
        return weekly;
    }
//get monthly rates
    public  double getMonthlyRate(){
        return monthly;
    }
	// get charge per miles
    public  double getMileageChrg(){
        return mileage_charge;
    }
    //get daily insurance rates
    public  double getDailyInsurRate(){
        return daily_insur_rate;
    }
    //to string method  
    public abstract String toString();
}
