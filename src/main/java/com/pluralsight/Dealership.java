package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();

    }

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {

        List<Vehicle> priceList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if(v.getPrice().compareTo(min) >= 0 && v.getPrice().compareTo(max) <= 0 ){
                priceList.add(v);
            }
        }

        return priceList;

    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> mmList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                mmList.add(v);
            }
        }

        return mmList;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> yearList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                yearList.add(vehicle);
            }

        }

        return yearList;

    }

    public List<Vehicle> getVehiclesByColor(String color) {

        return null;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {

        return null;

    }

    public List<Vehicle> getVehiclesByType(String type) {

        return null;

    }

    public List<Vehicle> getAllVehicles() {

        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);


    }

    public void removeVehicle(Vehicle vehicle) {


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /*public void displayFormat(List<Vehicle> list){
        int count = 1;
        for (Vehicle v : inventory) {
            System.out.printf("%-4d | %-8d | %-6d | %-12s | %-12s | %-12s | %-10s | %-10d | %-12.2f%n",count,
                    v.getVin(),v.getYear(),v.getMake(),v.getModel(),v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
            count++;
        }


    }*/
}
