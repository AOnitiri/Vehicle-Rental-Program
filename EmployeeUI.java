/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Adesimisola Onitiri
// Assignment 5 – Vehicles collection class
// Adesimisola Onitiri
// COSC 237-004 (or COSC 237 005)
// Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used as the User Interface for Employees
// -----------------------------------------------------------------------------------------------------------
public class EmployeeUI implements UserInterface {
    private boolean quit = false;
    public void start(Scanner input) {
    int selection;
    // command loop
    while(!quit){
        displayMenu();
        selection = getSelection(input);
        execute(selection, input); 
    }
}
    private void execute(int selection, Scanner input){
        int veh_type;
        String vin, creditcard_num; String[] display_lines = null;
        RentalDetails rental_details; 
        ReservationDetails reserv_details;
        switch(selection) {
// display rental rates
            case 1: 
                veh_type = getVehicleType(input);
                switch(veh_type){
                case 1: display_lines = SystemInterface.getCarRates(); break;
                case 2: display_lines = SystemInterface.getSUVRates(); break;
                case 3: display_lines = SystemInterface.getTruckRates(); break;
            }
            displayResults(display_lines);
            break;
// display available vehicles
            case 2: veh_type = getVehicleType(input);
                switch(veh_type){
                case 1: display_lines = SystemInterface.getAvailCars(); break;
                case 2: display_lines = SystemInterface.getAvailSUVs(); break;
                case 3: display_lines = SystemInterface.getAvailTrucks(); break;
            }
            displayResults(display_lines);
            break;
// display estimated rental cost
            case 3: rental_details = getRentalDetails(input);
            display_lines = SystemInterface.estimatedRentalCost(rental_details);
            displayResults(display_lines);
            break;

 // make a reservation
            case 4: reserv_details = getReservationDetails(input);
            display_lines = SystemInterface.makeReservation(reserv_details);
            displayResults(display_lines);
            break;
// cancel a reservation
            case 5: vin = getVIN(input);
            display_lines = SystemInterface.cancelReservation(vin);
            displayResults(display_lines);
            break;
// view corporate account (and company reservations)
            case 6: creditcard_num = getCreditCardNum(input);
            display_lines = SystemInterface.getAccount(creditcard_num);
            displayResults(display_lines);
            break;
// process returned vehicle
            case 7: creditcard_num = getCreditCardNum(input);
            vin = getVIN(input);
            System.out.println("How many days used");
            int num_day_used = input.nextInt();
            System.out.println("How many miles driven");
            int num_miles_driven = input.nextInt();
            display_lines = SystemInterface.processReturnedVehicle(creditcard_num,vin,num_day_used,num_miles_driven);
            displayResults(display_lines);
            break;
// quit program
            case 8: quit = true;
        }
    }
    // displays the menu of options
   private void displayMenu() {
       System.out.println("MAIN MENU - EMPLOYEE");
       System.out.println("1 - Veiw Current Rates");
       System.out.println("2 - Veiw Available Vehicles");
       System.out.println("3 - Calc Estimated Rental Cost");
       System.out.println("4 - Make a Reservation");
       System.out.println("5 - Cancel Reservation");
       System.out.println("6 - Veiw Corporate Account");
       System.out.println("7 - Process Returned Vehicle");
       System.out.println("8 - Quit");
   }
        // prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)

    private int getSelection(Scanner input) {
        System.out.println("Enter Selection");
        int selc = input.nextInt();
        if(selc <1 || selc> 8){
           return getSelection(input);
        }
        else
            return selc;
    }
        // prompts user to enter VIN for a given vehicle (does not do any error checking on the input) { }

    private String getVIN(Scanner input){
        System.out.println("Enter VIN");
        String VIN = input.next();
        return VIN;
    }
        // prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) { }

    private int getVehicleType(Scanner input){
        System.out.println("Enter 1,2 or 3 for vehicle type");
        int type = input.nextInt();
        if(type<1||type>3){
            return getVehicleType(input);
        }
        else 
            return type;
    }
    // prompts user to enter required information for an estimated rental cost (vehicle type, estimated
    // number of miles expected to be driven, rental period (number of days, weeks or months), and
    // insurance option, returning the result packaged as a RentalDetails object (to be passed in method
    // calls to the SystemInterface) { }
    private RentalDetails getRentalDetails(Scanner input){
        System.out.println("Enter the information to get estimated rental cost");
        System.out.println("Enter Vehicle type (in words)");
        String type = input.next();
        System.out.println("Enter estimated number of miles");
        int miles = input.nextInt();
        System.out.println("Enter rental period (in this format ex d2 for 2 days, w2 for 2 weeks and m2 for 2 months)");
        String period = input.next();
        System.out.println("Would you like insurance?");
        boolean ins = input.nextBoolean();
        System.out.println("Are you a prime customer?");
        boolean prime = input.nextBoolean();
        
        return new RentalDetails(type,miles,period,ins,prime);
    }
    // prompts user to enter required information for making a reservation (VIN of vehicle to reserve,
    // credit card num, rental period, and insurance option), returning the result packaged as a
    // ReservationDetails object (to be passed in method calls to the SystemInterface) { }
    private ReservationDetails getReservationDetails(Scanner input){
        System.out.println("Enter information pertaining your reservation");
        System.out.println("Enter VIN");
        String VIN = input.next();
        System.out.println("Enter card");
        String card = input.next();
        System.out.println("Are you renting for d(days),w(weeks) or m(months) ");
        String str = input.next();
        char rental = str.charAt(0);
        System.out.println("How many "+rental+"s");
        int units = input.nextInt();
        System.out.println("Do you want to rent with insurance? (True or false)");
        boolean ins = input.nextBoolean();
        
        return new ReservationDetails(VIN,card,new TimeSpan(rental,units),ins);
        
    }

    // displays the array of strings passed, one string per screen line { }        
    private void displayResults(String[] lines){
        String[] a = lines;
        for (int i = 0;i<a.length;i++)
               System.out.println(a[i]);

    }

    private String getCreditCardNum(Scanner input) {
        System.out.println("Enter your card number");
        String card = input.next();
        return card;
    }
}
