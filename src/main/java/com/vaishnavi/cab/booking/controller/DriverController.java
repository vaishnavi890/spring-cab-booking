package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import java.sql.SQLException;
import java.util.List;

public class DriverController {
    private DriverService driverService;

    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    public void createDriver(Driver driver) {
        try {
            driverService.registerDriver(driver);
            System.out.println("Driver registered successfully.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void listAllDrivers() {
        try {
            List<Driver> drivers = driverService.getAllDrivers();
            drivers.forEach(d -> System.out.println(d.getDriverId() + " | " + d.getName()));
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void addDriver(Driver driver) {
    }
}



