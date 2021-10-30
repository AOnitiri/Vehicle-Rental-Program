/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Adesimisola Onitiri // Assignment 5 – Vehicles collection class //
 * Adesimisola Onitiri // COSC 237-004 (or COSC 237 005) // Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used as the User Interface for Managers
// -----------------------------------------------------------------------------------------------------------
public class ManagerUI implements UserInterface {

    private boolean quit = false;

    public void start(Scanner input) {
        int selection;
        // command loop
        while (!quit) {
            displayMenu();
            selection = getSelection(input);
            execute(selection, input);
        }
    }

    private void execute(int selection, Scanner input) {
        int veh_type;
        String vin, creditcard_num;
        String[] display_lines = null;
        switch (selection) {
// View/Update rates ***
            case 1:
                System.out.print("View rates or update rates (type 1 or 2)");
                int num = input.nextInt();
                if (num == 1) {
                    veh_type = getVehicleType(input);
                    switch (veh_type) {
                        case 1:
                            display_lines = SystemInterface.getCarRates();
                            break;
                        case 2:
                            display_lines = SystemInterface.getSUVRates();
                            break;
                        case 3:
                            display_lines = SystemInterface.getTruckRates();
                            break;
                    }
                } else if (num == 2) {
                    veh_type = getVehicleType(input);
                    switch(veh_type){
                       case 1:
                            System.out.println("New daily rate");
                            double d = input.nextDouble();
                            System.out.println("New weekly rate");
                            double w = input.nextDouble();
                            System.out.println("New monthly rate");
                            double m = input.nextDouble();
                            System.out.println("New mileage charge");
                            double mile = input.nextDouble();
                            System.out.println("New daily insurance rate");
                            double rate = input.nextDouble();
                            VehicleRates r = new CarRates(d,w,m,mile,rate);
                            display_lines = SystemInterface.updateCarRates(r);
                            break;
                        case 2:
                            System.out.println("New daily rate");
                            double da = input.nextDouble();
                            System.out.println("New weekly rate");
                            double we = input.nextDouble();
                            System.out.println("New monthly rate");
                            double mo = input.nextDouble();
                            System.out.println("New mileage charge");
                            double mi = input.nextDouble();
                            System.out.println("New daily insurance rate");
                            double ra = input.nextDouble();
                            VehicleRates q = new TruckRates(da,we,mo,mi,ra);
                            display_lines = SystemInterface.updateSUVRates(q);
                            break;
                        case 3:
                            System.out.println("New daily rate");
                            double day = input.nextDouble();
                            System.out.println("New weekly rate");
                            double wee = input.nextDouble();
                            System.out.println("New monthly rate");
                            double mon = input.nextDouble();
                            System.out.println("New mileage charge");
                            double mil = input.nextDouble();
                            System.out.println("New daily insurance rate");
                            double rat = input.nextDouble();
                            VehicleRates c = new TruckRates(day,wee,mon,mil,rat);
                            display_lines = SystemInterface.updateTruckRates(c);
                            break;
                    }
                } else {

                }

                displayResults(display_lines);
                break;
// display All vehicles (done)
            case 2:
                display_lines = SystemInterface.getAllVehicles();
                displayResults(display_lines);
                break;
// Add Account (done)
            case 3:
                System.out.println("Enter the information to add Account");
                System.out.println("Enter creditcard");
                String card = input.next();
                System.out.println("Enter company name");
                String name = input.next();
                System.out.println("Prime Customer? (True or false)");
                boolean prime = input.nextBoolean();
                display_lines = SystemInterface.addAccount(card, name, prime);
                displayResults(display_lines);
                break;

            // View All reservation
            case 4:
                display_lines = SystemInterface.getAllReservations();
                displayResults(display_lines);
                break;
// View all Accounts
            case 5:
                display_lines = SystemInterface.getAllAccounts();
                displayResults(display_lines);
                break;
// view corporate account (and company reservations)
            case 6:
                display_lines = SystemInterface.getAllTransactions();
                displayResults(display_lines);
                break;

// quit program
            case 7:
                quit = true;
        }
    }

    // displays the menu of options
    private void displayMenu() {
        System.out.println("MAIN MENU - MANAGER");
        System.out.println("1 - View/Update Rates ... allows updating of rental and insurance rates");
        System.out.println("2 - View All Vehicles ... displays all vehicles of the agency");
        System.out.println("3 - Add Account ... allows entry of a new customer account");
        System.out.println("4 - View All Reservations ... displays all current reservations");
        System.out.println("5 - View All Accounts ... displays all customer accounts");
        System.out.println("6 - View Transactions ... displays all transactions");
        System.out.println("7 - Quit");

    }
    // prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)

    private int getSelection(Scanner input) {
        System.out.println("Enter Selection");
        int selc = input.nextInt();
        if (selc < 1 || selc > 8) {
            return getSelection(input);
        } else {
            return selc;
        }
    }

    // prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) { }
    private int getVehicleType(Scanner input) {
        System.out.println("Enter 1,2 or 3 for vehicle type");
        int type = input.nextInt();
        if (type < 1 || type > 3) {
            return getVehicleType(input);
        } else {
            return type;
        }
    }

    private void displayResults(String[] lines) {
        String[] a = lines;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
    

}
