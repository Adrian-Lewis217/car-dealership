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
    private int min;
    private int max;
    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        ArrayList<Vehicle> inventory = new ArrayList<>();
    }

    // Getter
    // Setter
    // Methods
    public static List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        String fileName = "";
        getAllVehicles(fileName);
        List<Vehicle> vehiclesPrices = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0){
                vehiclesPrices.add(vehicle);
            }
        }

        return vehiclesPrices;
    }

    public static String getVehiclesByMakeModel(make,model){
        return null;
    }

    public static int getVehiclesByYear(min,max){
        return null;
    }

    public static String getVehiclesByColor(color){
        return null;
    }

    public static int getVehiclesByMileage(min,max){
        return null;
    }

    public static String[] getVehiclesByType(vehicleType){
        return null;
    }

    public static ArrayList<Vehicle> getAllVehicles(String fileName){
        // Display all vehicles in file
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
                String[] vehicleType = new String[4];
                String color = sections[5];
                int odometer = Integer.parseInt(sections[6]);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(sections[7]));
                inventory.add(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
            }
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return null;
    }
    public static void addVehicles(vehicle){
        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        // prompt user for vehicle info
        try {

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
        String[] vehicleType = new String[]{input.nextLine()};
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

    public static void removeVehicles(vehicle){}
    // ToString
}
