package com.pluralsight;

public class CarDealership {

    public static final String FILE_NAME = "inventory.csv";

    public static void main(String[] args) {
        // Load the inventory
        Dealership.getAllVehicles(FILE_NAME);

        // Display User Interface
        UserInterface ui = new UserInterface();
        ui.display();
    }
}