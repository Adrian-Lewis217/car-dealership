package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    // Constructor

    // Getter

    // Setter

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
    public static void saveDealership(){
        String fileName = "";
        try {
            // Save the Dealership from the CSV File
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("D & B Used Cars|111 Old Benbrook Rd|817-555-5555");
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
