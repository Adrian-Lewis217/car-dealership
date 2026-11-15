package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership = new Dealership("Potato and Tomato Used Cars","2627 John Farmer Rd","(876)-640-5210");

    // Constructor


    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    // Getter

    // Setter

    // Methods
    public static void display(){
        Scanner input = new Scanner(System.in);
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

    public static void processGetByPriceRequest(){}

    public static void processGetByMakeModelRequest(){}

    public static void processGetByYearRequest(){}

    public static void processGetByColorRequest(){}

    public static void processGetByMileageRequest(){}

    public static void processGetByVehicleTypeRequest(){}

    public static void processGetAllVehiclesRequest(){}

    public static void processAddVehiclesRequest(){}

    public static void processRemoveVehiclesRequest(){}
    // ToString
}
