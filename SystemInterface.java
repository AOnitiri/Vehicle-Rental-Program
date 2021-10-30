/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Adesimisola Onitiri // Assignment 5 – Vehicles collection class //
 * Adesimisola Onitiri // COSC 237-004 (or COSC 237 005) // Spring 2020
 */
// -----------------------------------------------------------------------------------------------------------
// This program is system interface class that is used in managerUI and employeeUI
// -----------------------------------------------------------------------------------------------------------
public class SystemInterface {

    static DecimalFormat dfTwo = new DecimalFormat("#.00");
    private static CurrentRates agency_rates = new CurrentRates();
    private static Vehicles agency_vehicles = new Vehicles();
    private static Accounts accounts = new Accounts();
    private static Transactions transactions_history = new Transactions();
// used to init static variables (in place of a constructor)

    public static void initSystem(CurrentRates r, Vehicles v, Accounts a, Transactions t) {
        agency_rates = r;
        agency_vehicles = v;
        accounts = a;
        transactions_history = t;
    }

    // Current Rates Related Methods
    public static String[] getCarRates() {
        return new String[]{agency_rates.getCarRates().toString()};
    }

    public static String[] getSUVRates() {
        return new String[]{agency_rates.getSUVRates().toString()};
    }

    public static String[] getTruckRates() {
        return new String[]{agency_rates.getTruckRates().toString()};
    }

    public static String[] updateCarRates(VehicleRates r) {

        VehicleRates q = new CarRates(r.getDailyRate(), r.getWeeklyRate(), r.getMonthlyRate(), r.getMileageChrg(), r.getDailyInsurRate());

        agency_rates.setCarRates((CarRates) q);
        return new String[]{"New rate is " + q.toString()};
    }

    public static String[] updateSUVRates(VehicleRates r) {
        VehicleRates q = new SUVRates(r.getDailyRate(), r.getWeeklyRate(), r.getMonthlyRate(), r.getMileageChrg(), r.getDailyInsurRate());
        agency_rates.setSUVRates((SUVRates) q);
        return new String[]{"New rate is " + q.toString()};
    }

    public static String[] updateTruckRates(VehicleRates r) {
        VehicleRates q = new TruckRates(r.getDailyRate(), r.getWeeklyRate(), r.getMonthlyRate(), r.getMileageChrg(), r.getDailyInsurRate());
        agency_rates.setTruckRates((TruckRates) q);
        return new String[]{"New rate " + q.toString()};
    }

    public static String[] estimatedRentalCost(RentalDetails details) {
        return new String[]{"Estimated costs is:$ " + dfTwo.format(agency_rates.calcEstimatedCost(details.vehicleType, details.rentalPeriod, details.numMilesDriven, details.insurance, details.primeCustomer))};
    }

    public static String[] processReturnedVehicle(String creditcard_num, String vin, int num_days_used, int num_miles_driven) throws VINNotFoundException, AccountNotFoundException {

        try {
            String cost;
            VehicleRates rates = null;
            if (!agency_vehicles.getVehicle(vin).getVIN().equals(vin)) {
                throw new VINNotFoundException();
            } else if (agency_vehicles.getVehicle(vin) instanceof Car) {
                rates = agency_rates.getCarRates();
                String days = num_days_used + " days";
                cost = "$" + dfTwo.format(agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().getIsInsuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getCardNum()).primeCustomer()));
                Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);
                transactions_history.add(trans);
                agency_vehicles.getVehicle(vin).cancelReservation();
                System.out.println("Vehicle has been returned");
            } else if (agency_vehicles.getVehicle(vin) instanceof SUV) {
                rates = agency_rates.getSUVRates();
                String days = num_days_used + " days";
                cost = "$" + dfTwo.format(agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().getIsInsuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getCardNum()).primeCustomer()));
                Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);
                transactions_history.add(trans);
                agency_vehicles.getVehicle(vin).cancelReservation();
                System.out.println("Vehicle has been returned");
            } else {
                rates = agency_rates.getTruckRates();
                String days = num_days_used + " days";
                cost = "$" + dfTwo.format(agency_rates.calcActualCost(rates, num_days_used, num_miles_driven, agency_vehicles.getVehicle(vin).getReservation().getIsInsuranceSelected(), accounts.getAccount(agency_vehicles.getVehicle(vin).getReservation().getCardNum()).primeCustomer()));
                Transaction trans = new Transaction(creditcard_num, accounts.getAccount(creditcard_num).getCompanyName(), "Car", days, cost);
                transactions_history.add(trans);
                agency_vehicles.getVehicle(vin).cancelReservation();
                System.out.println("Vehicle has been returned");
            }

            return new String[]{"Actual cost of " + agency_vehicles.getVehicle(vin) + " for " + num_days_used + "days and " + num_miles_driven + " miles driven @" + rates.getMileageChrg() + "/mile and daily Insurance @" + rates.getDailyInsurRate() + "/day (with 100 miles credit as Prime customer) is: " + cost};
        } catch (VINNotFoundException e) {
            return new String[]{"VIN not found"};
        } catch (AccountNotFoundException e) {
            return new String[]{"Account not found"};
        }
    }

    // Vehicle Related Methods
    public static String[] getAvailCars() {
        System.out.println("---- ALL AVAILABLE (unreserved) Cars");
        System.out.println();  // skip line
        int counter = 0;
        // display vehicles
        agency_vehicles.reset();
        Vehicle veh;

        while (agency_vehicles.hasNext()) {
            veh = agency_vehicles.getNext();
            if (veh instanceof Car) {
                if (!veh.isReserved()) {
                    System.out.println(veh);
                }
            }
        }

        return new String[]{""};
    }

    public static String[] getAvailSUVs() {
        System.out.println("---- ALL AVAILABLE (unreserved) Cars");
        System.out.println();  // skip line
        int counter = 0;
        // display vehicles
        agency_vehicles.reset();
        Vehicle veh;

        while (agency_vehicles.hasNext()) {
            veh = agency_vehicles.getNext();
            if (veh instanceof SUV) {
                if (!veh.isReserved()) {
                    System.out.println(veh);
                }
            }
        }

        return new String[]{""};
    }

    public static String[] getAvailTrucks() {
        System.out.println("---- ALL AVAILABLE (unreserved) Cars");
        System.out.println();  // skip line
        int counter = 0;
        // display vehicles
        agency_vehicles.reset();
        Vehicle veh;

        while (agency_vehicles.hasNext()) {
            veh = agency_vehicles.getNext();
            if (veh instanceof Truck) {
                if (!veh.isReserved()) {
                    System.out.println(veh);
                }
            }
        }

        return new String[]{""};
    }

    public static String[] getAllVehicles() {
        System.out.println("---- ALL VEHICLES (reserved and unreserved)");
        System.out.println("");  // skip line

        agency_vehicles.reset();

        while (agency_vehicles.hasNext()) {
            Vehicle temp = agency_vehicles.getNext();
            if (temp.isReserved() == true) {
                System.out.println("(RESERVED) " + temp);
            } else {
                System.out.println(temp);
            }
        }

        return new String[]{""};
    }

    public static String[] makeReservation(ReservationDetails details) throws ReservedVehicleException {
        String vin = details.VIN;

        try {
            if (agency_vehicles.getVehicle(vin).isReserved() == false) {
                Reservation r = new Reservation(details.getAcctNum(), details.getRentalPeriod(), details.isInsuranceOpted());
                agency_vehicles.getVehicle(vin).reserve(r);
                return new String[]{"Your reservation has been made for " + agency_vehicles.getVehicle(vin) + " for " + details.getRentalPeriod() + " with Insurance: " + details.isInsuranceOpted()};
            } else {
                throw new ReservedVehicleException();
            }
        } catch (ReservedVehicleException e) {
            return new String[]{"There is no resevation available for this vehicle"};
        }
        
    }

    public static String[] cancelReservation(String vin) throws UnReservedVehicleException, VINNotFoundException {
        try {
            agency_vehicles.reset();
            if (!agency_vehicles.getVehicle(vin).getVIN().equals(vin)) {
                throw new VINNotFoundException();
            } else if (agency_vehicles.getVehicle(vin).isReserved() == true) {
                agency_vehicles.getVehicle(vin).cancelReservation();
                return new String[]{"This vehicle has been unreserved: " + agency_vehicles.getVehicle(vin)};
            } else {
                throw new UnReservedVehicleException();
            }
        } catch (UnReservedVehicleException e) {
            return new String[]{"There was no reservation found"};
        } catch (VINNotFoundException e) {
            return new String[]{"VIN not dound"};
        }
    }

    public static String[] getReservation(String vin) throws UnReservedVehicleException, VINNotFoundException {
        try {
            agency_vehicles.reset();
            if (!agency_vehicles.getVehicle(vin).getVIN().equals(vin)) {
                throw new VINNotFoundException();
            } else if (agency_vehicles.getVehicle(vin).isReserved() == true) {
                return new String[]{"Your reservation is: " + agency_vehicles.getVehicle(vin).getReservation().toString()};
            } else {
                throw new UnReservedVehicleException();
            }
        } catch (UnReservedVehicleException e) {
            return new String[]{"Vehicle is not reserved"};
        } catch (VINNotFoundException e) {
            return new String[]{"VIN not dound"};
        }
    }

    public static String[] getAllReservations() {
        System.out.println("---- ALL AVAILABLE (unreserved) Cars");
        System.out.println();  // skip line
        int counter = 0;
        // display vehicles
        agency_vehicles.reset();
        Vehicle temp;

        while (agency_vehicles.hasNext()) {
            temp = agency_vehicles.getNext();
            if (temp.isReserved()) {
                System.out.println(temp);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No reserved vehciles");
        }

        return new String[]{""};
    }

    // Customer Accounts Related Methods
    public static String[] addAccount(String creditcard, String company_name, boolean prime_cust) throws InvalidCreditCardException {
        Account temp = new Account(creditcard, company_name, prime_cust);
        boolean lenght = false;
        while (!lenght) {
            try {

                if (temp.getCreditCardNum().length() != 16) {
                    throw new InvalidCreditCardException();
                } else {
                    lenght = true;
                }
            } catch (InvalidCreditCardException e) {
                System.out.println("Card is not 16 digits");
                System.out.println("Enter new card information");
                Scanner cin = new Scanner(System.in);
                String card = cin.next();
                temp = new Account(card, company_name, prime_cust);
            }
        }
        accounts.add(temp);
        return new String[]{"Your account has been added for " + temp.toString()};
    }

    public static String[] getAccount(String creditcard_num) throws InvalidCreditCardException, AccountNotFoundException {

        boolean lenght = false;
        boolean found = false;
        String card = creditcard_num;
        while (!lenght & !found) {
            try {
                if (card.length() == 16) {
                    lenght = true;
                    if (accounts.getAccount(card).getCreditCardNum().equals(card)) {
                        found = true;
                    }

                } else if (card.length() != 16) {
                    throw new InvalidCreditCardException();
                } else {
                    throw new AccountNotFoundException();
                }
            } catch (InvalidCreditCardException e) {
                System.out.println("Card is not 16 digits");
                System.out.println("Enter new card information");
                Scanner cin = new Scanner(System.in);
                card = cin.next();
            } catch (AccountNotFoundException e) {
                found = true;
                return new String[]{"Account not found"};

            }
        }
        return new String[]{"Your account associated with " + creditcard_num + " is " + accounts.getAccount(card).toString()};

    }

    public static String[] getAllAccounts() {
        System.out.println("---- ALL ACCOUNTS ----");
        System.out.println();  // skip line
        int counter = 0;
        for (int count = 0; count < accounts.size(); count++) {
            while (accounts.hasNext()) {
                System.out.println(accounts.getNext());
                counter++;
            }
            
        }
        if (counter == 0) {
            System.out.println("There are currently no accounts");
        }
        return new String[]{""};
    }

    // transactions-related methods
    public static String[] getAllTransactions() {
        System.out.println("---- ALL TRANSACTIONS ----");
        System.out.println();  // skip line
        int counter = 0;
        Transaction temp;
        while (transactions_history.hasNext()) {
            temp = transactions_history.getNext();
            if (temp != null) {
                counter++;
                System.out.println(temp);
            }
        }
        if (counter == 0) {
            System.out.println("No transactions");
        }
        return new String[]{""};
    }

}
//for(int count =0; count< transactions_history.size();count++){
//            if(transactions_history.get)
//                System.out.println(transactions_history.getNext());
//            }
