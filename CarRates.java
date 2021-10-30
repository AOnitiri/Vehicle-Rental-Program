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
// This program is used to store data as type CarRates
// -----------------------------------------------------------------------------------------------------------
public class CarRates extends VehicleRates {
    private double daily = 24.95;
    private double weekly= 159.95;
    private double monthly= 514.95;
    private double mileage_charge= .15;
    private double daily_insur_rate= 14.95;
    
    public CarRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
 double daily_insur_rate){
        super(daily_rate,weekly_rate,monthly_rate,mileage_chrg,daily_insur_rate);
      
    }
    
        
    
    
    
    
    public String toString(){
        return "(Car) Daily Rate: $" +super.getDailyRate()+ ", Weekly Rate: $"+ super.getWeeklyRate()+ ", Monthly Rate: $" + super.getMonthlyRate()+ ", Mileage charge: $"+ super.getMileageChrg()+" / miles, Insurance Rate: $" + super.getDailyInsurRate() +" / day";
    }
    
}
