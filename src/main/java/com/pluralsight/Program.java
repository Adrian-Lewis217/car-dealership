package com.pluralsight;

public class Program {

    public static String FILE_NAME = "inventory.csv";

    public static void main(String[] args) {
        // Load the inventory
        Dealership.getAllVehicles(FILE_NAME);

        // Display User Interface
        UserInterface ui = new UserInterface();
        ui.display();
    }
}