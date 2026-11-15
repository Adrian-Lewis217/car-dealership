package com.pluralsight;

public class UserInterface {
    private Dealership dealership = new Dealership("Potato and Tomato Used Cars","2627 John Farmer Rd","(876)-640-5210");

    // Constructor


    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    // Getter
    // Setter
    // Methods
    public static void display(){}

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
