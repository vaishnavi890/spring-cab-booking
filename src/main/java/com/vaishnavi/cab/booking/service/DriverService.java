package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import java.sql.SQLException;
import java.util.List;

public class DriverService {
    private DriverRepository driverRepository;

    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void registerDriver(Driver driver) throws SQLException {
        if (driver.getName() != null && !driver.getName().isEmpty()) {
            driverRepository.addDriver(driver);
        } else {
            throw new IllegalArgumentException("Driver name is required.");
        }
    }

    public List<Driver> getAllDrivers() throws SQLException {
        return driverRepository.getAllDrivers();
    }
}




