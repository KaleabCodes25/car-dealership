package com.pluralsight;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    public Dealership getDealership(){
        String line;
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv")); //create a buffer reader to loop through the file.

            while ((line = reader.readLine()) != null){
                String[] tokens = line.split("\\|");

                if(dealership == null){  // the first line in the csv file gets saved to the dealership.
                    dealership = new Dealership(tokens[0], tokens[1],tokens[2]);
                }else {
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                BigDecimal price = new BigDecimal(tokens[7]);

                dealership.addVehicle( new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));}

            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error reading file" + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership){

        try { // create buffer writer to save the dealership's information
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle :dealership.getAllVehicles() ) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear()+ "|" + vehicle.getMake() +
                        "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() +
                        "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                writer.newLine();

            }
            writer.close();

        } catch (Exception e) {
            System.err.println("Error saving dealership!! " + e.getMessage());
        }


    }


}
