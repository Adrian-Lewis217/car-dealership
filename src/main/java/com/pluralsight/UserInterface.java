package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    // Constructor
    public UserInterface() {}

    // Methods
    public void display(){
        Scanner input = new Scanner(System.in);

        init();

        // Menu
        boolean running = true;
        while (running){
            // Prompts
            System.out.println("Please choose a option by number.");
            System.out.println("1. Find vehicles within a price range.");
            System.out.println("2. Find vehicles by make / model.");
            System.out.println("3. Find vehicles by year range.");
            System.out.println("4. Find vehicles by color.");
            System.out.println("5. Find vehicles by mileage range.");
            System.out.println("6. Find vehicles by type(car,truck,SUV,van).");
            System.out.println("7. List All vehicles.");
            System.out.println("8. Add a vehicle.");
            System.out.println("9. Remove a vehicle.");
            System.out.println("10. Quit");
            System.out.print("Your Choose: ");
            String option = input.nextLine();

            // Switch Statement
            switch (option){
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehiclesRequest();
                case "9" -> processRemoveVehiclesRequest();
                case "10" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void processGetByPriceRequest(){
        Scanner input = new Scanner(System.in);
        BigDecimal min;
        BigDecimal max;

        // Prompt user for their min and max price
        System.out.print("Enter your min price: ");
        min = input.nextBigDecimal();
        input.nextLine();
        System.out.print("Enter your max price: ");
        max = input.nextBigDecimal();
        input.nextLine();

        // calling getByPriceRequest() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByPrice(min,max));
        displayVehicles(results);
    }

    public static void processGetByMakeModelRequest(){
        Scanner input = new Scanner(System.in);

        // Prompt user for their min and max price
        System.out.print("Enter the make of vehicle: ");
        String make = input.nextLine();
        System.out.print("Enter the model of vehicle: ");
        String model = input.nextLine();

        // calling getVehiclesByMakeModel() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByMakeModel(make,model));
        displayVehicles(results);
    }

    public static void processGetByYearRequest(){
        Scanner input = new Scanner(System.in);
        // Try LocalDate for year, not int
        int min;
        int max;

        // Prompt user for their min and max price
        System.out.print("Enter min year: ");
        min = input.nextInt();
        input.nextLine();
        System.out.print("Enter max year: ");
        max = input.nextInt();
        input.nextLine();

        // calling getVehiclesByYear() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByYear(min,max));
        displayVehicles(results);

    }

    public static void processGetByColorRequest(){
        Scanner input = new Scanner(System.in);

        // Prompt user for color of vehicle
        System.out.print("Enter the color of vehicle: ");
        String color = input.nextLine();

        // calling getVehiclesByColor() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByColor(color));
        displayVehicles(results);
    }

    public static void processGetByMileageRequest(){
        Scanner input = new Scanner(System.in);
        int min;
        int max;

        // Prompt user for their min and max mileage
        System.out.print("Enter min mileage: ");
        min = input.nextInt();
        input.nextLine();
        System.out.print("Enter max mileage: ");
        max = input.nextInt();
        input.nextLine();

        // calling getVehiclesByMileage() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByMileage(min,max));
        displayVehicles(results);
    }

    public static void processGetByVehicleTypeRequest(){
        Scanner input = new Scanner(System.in);

        // Prompt user for color of vehicle
        System.out.print("Enter the vehicle type: ");
        String vehicleType = input.nextLine();

        // calling getVehiclesByType() from Dealership call
        ArrayList<Vehicle> results = new ArrayList<>(Dealership.getVehiclesByType(vehicleType));
        displayVehicles(results);
    }

    public static void processGetAllVehiclesRequest(){
        // Get the full inventory from file and display all vehicles
        ArrayList<Vehicle> inventory = Dealership.getAllVehicles("inventory.csv");
        displayVehicles(inventory);
    }

    public static void processAddVehiclesRequest(){
        Dealership.addVehicles();
    }

    public static void processRemoveVehiclesRequest(){
        Scanner input = new Scanner(System.in);

        // Remove vehicle by entering Vin
        System.out.print("Enter Vehicle's VIN to remove: ");
        int vehicleVIN = input.nextInt();
        input.nextLine();

        Dealership.removeVehicles(vehicleVIN);
    }
    
    // Helper Methods
    private void init(){
        // use the first line of the CSV file for name
        this.dealership = DealershipFileManager.getDealership();
    }
    
    private static void displayVehicles(ArrayList<Vehicle> inventory){
        // print all vehicles in inventory
        try {
            for (Vehicle vehicle : inventory) {
                System.out.println(vehicle);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    // ToString
}
