/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Adesimisola Onitiri // Assignment 5 – Vehicles collection class //
 * Adesimisola Onitiri // COSC 237-004 (or COSC 237 005) // Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is used to to run and call the other methods and classes in this project
// -----------------------------------------------------------------------------------------------------------
public class AgencyRentalProgram {

    public static void main(String[] args) {
// Provide Hard-coded Current Agency Rates
        CurrentRates agency_rates = new CurrentRates();
// Create an Initially Empty Vehicles Collection, and Populate
        Vehicles agency_vehicles = new Vehicles();
// supporting private static method (to be added)
// Create Initially Empty Accounts and Transactions Objects
        Accounts accounts = new Accounts();
        Transactions transactions = new Transactions();
// Establish User Interface
        Scanner input = new Scanner(System.in);
        UserInterface ui;
        boolean quit = false;
// Create Requested UI and Begin Execution
        while (!quit) { // (allows switching between Employee and Manager user interfaces while running)
            ui = getUI(input);
            if (ui == null) {
                quit = true;
            } else {
// Init System Interface with Agency Data (if not already initialized)
//if(!SystemInterface.initialized())
// SystemInterface.initSystem(agency_rates, agency_vehicles, accounts, transactions);
// Start User Interface

                ui.start(input);
            }
        }
    }

    public static UserInterface getUI(Scanner input) {
        UserInterface i = null;
        boolean valid_selection = false;
        while (!valid_selection) {
            System.out.print("1 – Employee, 2 – Manager, 3 – quit: ");
            int selection = input.nextInt();
            if (selection == 1) {
                i = new EmployeeUI();
                valid_selection = true;
            } else if (selection == 2) {
                i = new ManagerUI();
                valid_selection = true;
            } else if (selection == 3) {
                i = null;
                valid_selection = true;
            } else {
                System.out.println("Invalid selection – please reenter");
            }
        }
        return i;
    }
}
