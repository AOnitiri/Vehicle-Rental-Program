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
// This program is used to store data as Current rates used in conjunction with the VehicleRates object
// -----------------------------------------------------------------------------------------------------------/
public class CurrentRates {
    private VehicleRates[ ] rates = new VehicleRates[3];
    
    public CurrentRates(){
        rates[0] = new CarRates(24.95,159.95,514.95,.15,14.95);
        rates[1] = new SUVRates(29.95,189.95,679.95,.15,14.95);
        rates[2] = new TruckRates(35.95,224.95,787.95,.26,22.95);
    } 
    
    public VehicleRates getCarRates(){
        return rates[0];
    }
    
    public VehicleRates getSUVRates(){
        return rates[1];
    }
    
    public VehicleRates getTruckRates(){
        return rates[2];
    }
    public void setCarRates(CarRates car_rates){
        rates[0] = car_rates;
    }
    public void setSUVRates(SUVRates SUV_rates){
        rates[1] = SUV_rates;
    }
    public void setTruckRates(TruckRates Truck_rates){
        rates[1] = Truck_rates;
    }
    
    
    public double calcEstimatedCost(String vehicleType, String estimatedRentalPeriod, int estimatedNumMiles,
 boolean dailyInsur, boolean primeCustomer){
        String str = estimatedRentalPeriod;

            str = str.replaceAll("\\D+","");
            int inum = Integer.valueOf(str);

         if(vehicleType.equals("car")||vehicleType.equals("Car")){

         if(estimatedRentalPeriod.startsWith("d")||estimatedRentalPeriod.startsWith("D")){

            if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum);
                if(estimatedNumMiles < 100)
                    return (getCarRates().getDailyRate()* inum) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getCarRates().getDailyRate()* inum) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getCarRates().getDailyRate()* inum);
            }
            else
                return (getCarRates().getDailyRate()*inum)+ (getCarRates().getMileageChrg()*estimatedNumMiles);
                
         }
         
         if(estimatedRentalPeriod.startsWith("W")||estimatedRentalPeriod.startsWith("w")){
               if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum*7);
                if(estimatedNumMiles < 100)
                    return (getCarRates().getWeeklyRate()* inum) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getCarRates().getWeeklyRate()* inum) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getCarRates().getWeeklyRate()* inum);
            }
            else
                return (getCarRates().getWeeklyRate()*inum)+ (getCarRates().getMileageChrg()*estimatedNumMiles);
         }
         
         if(estimatedRentalPeriod.startsWith("M")||estimatedRentalPeriod.startsWith("m")){
             if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum*30);
                if(estimatedNumMiles < 100)
                    return (getCarRates().getMonthlyRate()* inum) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getCarRates().getMonthlyRate()* inum) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getCarRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getCarRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getCarRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getCarRates().getMonthlyRate()* inum);
            }
            else
                return (getCarRates().getMonthlyRate()*inum)+ (getCarRates().getMileageChrg()*estimatedNumMiles);
         }
    }
       if(vehicleType.equals("SUV")||vehicleType.equals("Suv")){
         if(estimatedRentalPeriod.startsWith("d")||estimatedRentalPeriod.startsWith("D")){
            if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum);
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getDailyRate()* inum) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getSUVRates().getDailyRate()* inum) + (estimatedNumMiles * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getDailyRate()* inum);
            }
            else
                return (getSUVRates().getDailyRate()*inum)+ (getSUVRates().getMileageChrg()*estimatedNumMiles);
         }
         
         if(estimatedRentalPeriod.startsWith("W")||estimatedRentalPeriod.startsWith("w")){
               if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum*7);
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getWeeklyRate()* inum) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getSUVRates().getWeeklyRate()* inum) + (estimatedNumMiles * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getWeeklyRate()* inum);
            }
            else
                return (getSUVRates().getWeeklyRate()*inum)+ (getSUVRates().getMileageChrg()*estimatedNumMiles);
         }
         
         if(estimatedRentalPeriod.startsWith("M")||estimatedRentalPeriod.startsWith("m")){
             if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum*30);
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getMonthlyRate()* inum) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getSUVRates().getMonthlyRate()* inum) + (estimatedNumMiles * getCarRates().getMileageChrg()) + (getSUVRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getSUVRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getSUVRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getSUVRates().getMonthlyRate()* inum);
            }
            else
                return (getSUVRates().getMonthlyRate()*inum)+ (getSUVRates().getMileageChrg()*estimatedNumMiles);
         }
    }
       if(vehicleType.equals("Truck")||vehicleType.equals("truck")){
         if(estimatedRentalPeriod.startsWith("d")||estimatedRentalPeriod.startsWith("D")){
            if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum);
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getDailyRate()* inum) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getTruckRates().getDailyRate()* inum) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getDailyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getDailyRate()* inum);
            }
            else
                return (getTruckRates().getDailyRate()*inum)+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
         }
         
         if(estimatedRentalPeriod.startsWith("W")||estimatedRentalPeriod.startsWith("W")){
               if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum*7);
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getWeeklyRate()* inum) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getTruckRates().getWeeklyRate()* inum) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getWeeklyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getWeeklyRate()* inum);
            }
            else
                return (getTruckRates().getWeeklyRate()*inum)+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
         }
         
         if(estimatedRentalPeriod.startsWith("M")||estimatedRentalPeriod.startsWith("M")){
             if(dailyInsur && primeCustomer == true){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum*30);
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getMonthlyRate()* inum) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(dailyInsur == true && primeCustomer == false){
                return (getTruckRates().getMonthlyRate()* inum) + (estimatedNumMiles * getTruckRates().getMileageChrg()) + (getTruckRates().getDailyInsurRate()*inum);
            }
            else if(primeCustomer ==true && dailyInsur ==false){
                if(estimatedNumMiles > 100)
                    return (getTruckRates().getMonthlyRate()* inum) + ((estimatedNumMiles - 100) * getTruckRates().getMileageChrg());
                if(estimatedNumMiles < 100)
                    return (getTruckRates().getMonthlyRate()* inum);
            }
            else
                return (getTruckRates().getMonthlyRate()*inum)+ (getTruckRates().getMileageChrg()*estimatedNumMiles);
         }
    }
        return 0;
    }
    public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven,
 boolean dailyInsur, boolean primeCustomer){
        if(dailyInsur && primeCustomer == true){
            if(NumMilesDriven < 100){
            if(numDaysUsed < 7){
                return (rates.getDailyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate());
            }
            else if(numDaysUsed>7&& numDaysUsed<30){
                return (rates.getWeeklyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate());
            }
            else {
                return (rates.getMonthlyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate());
            }
        }
        if(NumMilesDriven > 100){
            if(numDaysUsed < 7){
                return (rates.getDailyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed-100)*rates.getMileageChrg());
            }
            else if(numDaysUsed>7&& numDaysUsed<30){
                return (rates.getWeeklyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed-100)*rates.getMileageChrg());
            }
            else {
                return (rates.getMonthlyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed-100)*rates.getMileageChrg());
            }
        }
        }
        else if(dailyInsur && primeCustomer == false){
            if(numDaysUsed < 7){
                return (rates.getDailyRate()* numDaysUsed)+((numDaysUsed)*rates.getMileageChrg());
            }
            else if(numDaysUsed>7&& numDaysUsed<30){
                return (rates.getWeeklyRate()* numDaysUsed)+((numDaysUsed)*rates.getMileageChrg());
            }
            else {
                return (rates.getMonthlyRate()* numDaysUsed)+((numDaysUsed)*rates.getMileageChrg());
            }
        }
        else if(dailyInsur == true && primeCustomer ==false){
            if(numDaysUsed < 7){
                return (rates.getDailyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed)*rates.getMileageChrg());
            }
            else if(numDaysUsed>7&& numDaysUsed<30){
                return (rates.getWeeklyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed)*rates.getMileageChrg());
            }
            else {
                return (rates.getMonthlyRate()* numDaysUsed)+(numDaysUsed*rates.getDailyInsurRate())+((numDaysUsed)*rates.getMileageChrg());
            }
        }
        else{ //if prime is true and insurance is false
            if(numDaysUsed < 7){
                return (rates.getDailyRate()* numDaysUsed)+((numDaysUsed-100)*rates.getMileageChrg());
            }
            else if(numDaysUsed>7&& numDaysUsed<30){
                return (rates.getWeeklyRate()* numDaysUsed)+((numDaysUsed-100)*rates.getMileageChrg());
            }
            else {
                return (rates.getMonthlyRate()* numDaysUsed)+((numDaysUsed-100)*rates.getMileageChrg());
            }
        }    
        return 0;
        
        
    }
    
}
