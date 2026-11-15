package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==========DEALERSHIP MENU===========");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            int command = 0;
            try {
                System.out.print("Choose an option: ");
                command = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Enter a number Please!!" + e.getMessage());
            }
            scanner.nextLine();

            switch (command) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehicleRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> {
                    System.out.println("Thank you for your business!");
                    running = false;
                }
                default -> {
                    System.out.println("Enter the required command!!");
                }


            }


        }

    }

    private Dealership init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        return this.dealership = dealershipFileManager.getDealership();
    }
    private void displayVehicles(List<Vehicle> list){

        System.out.printf("%-4s | %-8s | %-6s | %-12s | %-12s | %-10s | %-10s | %-10s | %-12s\n","#","Vin","Year","Make","Model","Vehicle Type","Color","Odometer","Price" );
        int counter = 1;
        for (Vehicle vehicle : list ) {
            System.out.printf("%-4d | %-8d | %-6d | %-12s | %-12s | %-12s | %-10s | %-10d | %-12.2f\n", counter,
                    vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());
            counter++;
        }

    }


    public void processGetByPriceRequest() {


    }

    public void processGetByMakeModelRequest() {


    }

    public void processGetByYearRequest() {


    }

    public void processGetByColorRequest() {


    }

    public void processGetByMileageRequest() {


    }

    public void processGetByVehicleTypeRequest() {


    }

    public void processGetAllVehicleRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {



    }

    public void processRemoveVehicleRequest() {

    }


}
