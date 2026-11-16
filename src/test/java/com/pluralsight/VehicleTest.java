package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void getVehicleType_CheckReturnType_returnString(){
        //Arrange
        Vehicle vehicle = new Vehicle(123, 1999, "toyota","corolla","car","blue", 12500, new BigDecimal("4000.00"));


        //Acts
        String result = vehicle.getVehicleType();


        //Assert
        assertEquals("car", result);
    }

    @Test
    public void getOdometer_checkTheMiles_returnInt(){
        //Arrange
        Vehicle secondVehicle = new Vehicle(456,2005,"Toyota","rav4", "suv","red", 12355, new BigDecimal("2000.00") );


        //Act
        int number = secondVehicle.getOdometer();


        //Assert
        assertEquals(12355, number);
    }


}