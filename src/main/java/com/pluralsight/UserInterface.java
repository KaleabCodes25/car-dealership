package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

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

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }
    private void displayVehicles(List<Vehicle> list){

        System.out.print("==========================================DEALERSHIP INVENTORY==========================================");
        System.out.printf("%-4s | %-8s | %-6s | %-12s | %-12s | %-10s | %-10s | %-10s | %-12s\n","#","Vin","Year","Make","Model","Vehicle Type","Color","Odometer","Price" );

        int count = 1;
        for (Vehicle v : list) {
            System.out.printf("%-4d | %-8d | %-6d | %-12s | %-12s | %-12s | %-10s | %-10d | %-12.2f%n", count,
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
            count++;
        }

    }

    public void processGetByPriceRequest() {
        BigDecimal min = null;
        BigDecimal max = null;
        try {
            System.out.print("Enter the minimum price : ");
            min = new BigDecimal(scanner.nextLine().trim());
            System.out.print("Enter the maximum price : ");
            max = new BigDecimal(scanner.nextLine().trim());
        } catch (Exception e) {
            System.err.println("Enter number values only!! " + e.getMessage());
            return;
        }

        List<Vehicle> priceList = dealership.getVehiclesByPrice(min,max);
        displayVehicles(priceList);
        if(priceList.isEmpty()){
            System.out.println("No vehicles that match provided price range!!");
        }
    }

    public void processGetByMakeModelRequest() {

        System.out.print("Enter the Make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Enter the Model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> mmlist = dealership.getVehiclesByMakeModel(make,model);
        displayVehicles(mmlist);
        if(mmlist.isEmpty()){
            System.out.println("No vehicles that much the provided M/M!!");
        }
    }

    public void processGetByYearRequest() {
        int min = 0;
        int max = 0;
        try {
            System.out.print("Enter the minimum year: ");
            min = scanner.nextInt();
            System.out.print("Enter the maximum year: ");
            max = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Enter a valid number!! " + e.getMessage());
            scanner.nextLine();
            return;
        }

        List<Vehicle> yearList = dealership.getVehiclesByYear(min,max);
        displayVehicles(yearList);

        if(yearList.isEmpty()){
            System.out.println("No vehicles that match the provided year range!!");
        }

    }

    public void processGetByColorRequest() {
        System.out.print("Enter the color: ");
        String color = scanner.nextLine().trim();

        List<Vehicle> colorList = dealership.getVehiclesByColor(color);
        displayVehicles(colorList);

        if(colorList.isEmpty()){
            System.out.println("No vehicles match that color!!");
        }


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
