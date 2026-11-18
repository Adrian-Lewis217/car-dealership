package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    // Methods
    public static Dealership getDealership() {
        Dealership dealership = null;

        try {
            String fileName = "inventory.csv";
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            if ((line = br.readLine()) != null) {

                String[] sections = line.split("\\|");

                String name = sections[0];
                String address = sections[1];
                String phone = sections[2];

                // save the dealership from CSV file
                dealership = new Dealership(name, address, phone);

            }
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership){
        String fileName = "inventory.csv";
        // D & B Used Cars|111 Old Benbrook Rd|817-555-5555
        String name = "D & B Used Cars";
        String address = "111 Old Benbrook Rd";
        String phoneNumber = "817-555-5555";
        try {
            // Remake the header for Dealership from the CSV File
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(name + "|" + address + "|" + phoneNumber);
            bw.newLine();

            for (Vehicle vehicle : Dealership.getInventory()) {
                bw.write(
                        vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
                );
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
