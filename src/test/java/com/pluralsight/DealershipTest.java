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

}