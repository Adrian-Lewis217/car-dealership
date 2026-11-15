package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();
    // Constructor

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter
    // Setter
    // Methods
    public static int getVehiclesByPrice(min,max){}
    public static String getVehiclesByMakeModel(make,model){}
    public static int getVehiclesByYear(min,max){}
    public static String getVehiclesByColor(color){}
    public static int getVehiclesByMileage(min,max){}
    public static String[] getVehiclesByType(vehicleType){}
    public static void getAllVehicles(String fileName){
        // Display all vehicles in file
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

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
                int year = Integer.parseInt(sections[1]);;
                String make = sections[2];
                String model = sections[3];
                String[] vehicleType;
                String color = sections[5];
                int odometer = Integer.parseInt(sections[6]);;
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(sections[7]));
                inventory.add(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
            }
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public static void addVehicles(vehicle){

    }
    public static void removeVehicles(vehicle){}
    // ToString
}
