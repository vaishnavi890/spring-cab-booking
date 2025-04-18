package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DBConnection;
import com.vaishnavi.cab.booking.model.Driver;
import java.sql.*;
import java.util.*;

public class DriverRepository {

    public void addDriver(Driver driver) throws SQLException {
        String sql = "INSERT INTO drivers (driver_id, name, email, phone, cab_details) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, driver.getDriverId());
            ps.setString(2, driver.getName());
            ps.setString(3, driver.getEmail());
            ps.setString(4, driver.getPhone());
            ps.setString(5, driver.getCabDetails());
            ps.executeUpdate();
        }
    }

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                drivers.add(new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("cab_details")
                ));
            }
        }
        return drivers;
    }

    // updateDriver, deleteDriver, getDriverById
}



