package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter
    // Setter
    // Methods
    public static List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){

        List<Vehicle> matchingPrices = new ArrayList<>();

        // Search in the inventory for vehicles in between min and max
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0){
                matchingPrices.add(vehicle);
            }
        }

        return matchingPrices;
    }

    public static List<Vehicle> getVehiclesByMakeModel(String make,String model){
        List<Vehicle> matchingMakeModel = new ArrayList<>();

        // Search for vehicles with matching make or model
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                matchingMakeModel.add(vehicle);
            }
        }
        return matchingMakeModel;
    }

    public static List<Vehicle> getVehiclesByYear(int min,int max){
        List<Vehicle> matchingYear = new ArrayList<>();

        // Search for vehicles in between min and max year
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                matchingYear.add(vehicle);
            }
        }
        return matchingYear;
    }

    public static List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> matchingColor = new ArrayList<>();

        // Search for vehicles with matching color
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                matchingColor.add(vehicle);
            }
        }
        return matchingColor;
    }

    public static List<Vehicle> getVehiclesByMileage(int min,int max){
        List<Vehicle> matchingMileage = new ArrayList<>();

        // Search for vehicles in between min and max year
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                matchingMileage.add(vehicle);
            }
        }
        return matchingMileage;
    }

    public static List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> matchingType = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                matchingType.add(vehicle);
            }
        }
        return matchingType;
    }

    public static List<Vehicle> getAllVehicles(String fileName){
        // Display all vehicles in file

        // Clears for each call to avoid duplicates
        inventory.clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            br.readLine();

            while((line = br.readLine()) != null){

                if (line.isBlank()){
                    continue;
                }
                String[] sections = line.split("\\|");

                if (sections.length != 8){
                    System.out.println("Invalid Record: " + line);
                    continue;
                }

                int vin = Integer.parseInt(sections[0]);
                int year = Integer.parseInt(sections[1]);
                String make = sections[2];
                String model = sections[3];
                String vehicleType = sections[4];
                String color = sections[5];
                int odometer = Integer.parseInt(sections[6]);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(sections[7]));
                inventory.add(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
            }
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return inventory;
    }
    public static void addVehicles(){
        Scanner input = new Scanner(System.in);
        String fileName = "inventory.csv";

        // prompt user for vehicle info
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

            System.out.print("Enter Vehicle's VIN: ");
            int vin = input.nextInt();
            System.out.print("Enter Vehicle's Year: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Enter The Make of Vehicle: ");
            String make = input.nextLine();
            System.out.print("Enter The Model of Vehicle: ");
            String model = input.nextLine();
            System.out.print("Enter Vehicle's Type: ");
            String vehicleType = input.nextLine();
            System.out.print("Enter Vehicle's Color: ");
            String color = input.nextLine();
            System.out.print("Enter Vehicle's Odometer: ");
            int odometer = input.nextInt();
            input.nextLine();
            System.out.print("Enter Vehicle's Price: ");
            BigDecimal price = input.nextBigDecimal();
            input.nextLine();

            inventory.add(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
            bw.write(vin + "|" + year + "|"  + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price);
            bw.newLine();

            bw.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void removeVehicles(List<Vehicle> vehicle){
        Scanner input = new Scanner(System.in);
        String fileName = "inventory.csv";

        // prompt user for vehicle info
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            // Remove vehicle by entering Vin
            System.out.print("Enter Vehicle's VIN to remove: ");
            int vinRemove = input.nextInt();
            input.nextLine();

            // Remove vehicle from inventory if VIN matches
            inventory.removeIf(vehicle1 -> vehicle1.getVin() == vinRemove);

            // Rewrite the file after removing
            Dealership dealership = null;
            DealershipFileManager.saveDealership(dealership);

            for (Vehicle vehicle1 : inventory) {
                bw.write(
                        vehicle1.getVin() + "|" + vehicle1.getYear() + "|" + vehicle1.getMake() + "|" +
                                vehicle1.getModel() + "|" + vehicle1.getVehicleType() + "|" +
                                vehicle1.getColor() + "|" + vehicle1.getOdometer() + "|" + vehicle1.getPrice()
                        );
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}