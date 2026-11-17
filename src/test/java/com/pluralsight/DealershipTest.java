package com.pluralsight;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    public void getVehiclesByYear_validYearRange_returnsMatchingVehicles(){
        //Arrange
        Dealership dealership = new Dealership("Priority", "123-nowhere","456-780-1355");
        Vehicle firstVehicle = new Vehicle(123, 2002, "Toyota","camry", "car", "brown",25666,new BigDecimal("1553.00"));
        Vehicle secondVehicle = new Vehicle(767, 2005, "Toyota","lexus", "car", "grey",30000,new BigDecimal("2003.00"));
            int min = 2000;
            int max = 2026;
            dealership.addVehicle(firstVehicle);
            dealership.addVehicle(secondVehicle);

        //Act
        List<Vehicle> list = dealership.getVehiclesByYear(min,max);


        //Assert
        assertEquals(2,list.size());
    }

    @Test
    public void getVehiclesByYear_NotMatchingVehicles_returnsEmpty(){
        //Arrange
        Dealership dealership = new Dealership("Priority", "123-nowhere","456-780-1355");
        Vehicle firstVehicle = new Vehicle(123, 2010, "Toyota","camry", "car", "brown",25666,new BigDecimal("1553.00"));
        Vehicle secondVehicle = new Vehicle(767, 2026, "BMW","m4", "car","white",6000, new BigDecimal("45000.00"));

        int min = 2000;
        int max = 2009;
        dealership.addVehicle(firstVehicle);
        dealership.addVehicle(secondVehicle);

        //Act
        List<Vehicle> list = dealership.getVehiclesByYear(min,max);

        //Assert
        assertTrue(list.isEmpty());

    }

    @Test
    public void getVehiclesByPrice_checkThePriceRange_returnListThatMatch(){
        //Arrange
        Dealership dealership = new Dealership("Koons", "123-nowhere", "123-324-2521");
        Vehicle firstVehicle = new Vehicle(341,2015,"Honda","civic", "car", "White", 66000, new BigDecimal("7000.00"));
        Vehicle secondVehicle = new Vehicle(511,2019,"Honda","accord", "car", "Grey", 60000, new BigDecimal("10000.00"));

        BigDecimal min = new BigDecimal("5000.00");
        BigDecimal max = new BigDecimal("20000.00");

        dealership.addVehicle(firstVehicle);
        dealership.addVehicle(secondVehicle);

        //Act

        List<Vehicle> list = dealership.getVehiclesByPrice(min,max);

        //Assert

        assertEquals(2,list.size());

    }

    @Test
    public void getVehiclesByPrice_priceRangeIsNotaMatch_returnsEmptyList(){
        //Arrange
        Dealership dealership = new Dealership("Koons", "123-nowhere", "123-324-2521");

        Vehicle firstVehicle = new Vehicle(789,2022,"Toyota","prius", "car", "blue", 56000, new BigDecimal("19000.00"));
        Vehicle secondVehicle = new Vehicle(511,2019,"Toyota","lexus", "car", "Red", 21000, new BigDecimal("20000.00"));

        BigDecimal min = new BigDecimal("12000.00");
        BigDecimal max = new BigDecimal("18000.00");

        dealership.addVehicle(firstVehicle);
        dealership.addVehicle(secondVehicle);


        //Act
        List<Vehicle> list = dealership.getVehiclesByPrice(min,max);


        //assert
        assertTrue(list.isEmpty());



    }

}