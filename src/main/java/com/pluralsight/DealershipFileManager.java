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
        try {
            // Save the Dealership from the CSV File
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
