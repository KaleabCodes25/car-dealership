package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

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

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){


     return null;

    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){


    return null;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max ){

        return null;

    }
    public List<Vehicle> getVehiclesByColor(String color){

        return null;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){

        return null;

    }
    public List<Vehicle> getVehiclesByType(String type){

        return null;

    }
    public List<Vehicle> getAllVehicles(){

        return null;
    }
    public void addVehicle(Vehicle vehicle){

    }
    public void removeVehicle(Vehicle vehicle){


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
}
