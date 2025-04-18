package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DBConnection;
import com.vaishnavi.cab.booking.model.Ride;
import java.sql.*;
import java.util.*;

public class RideRepository {
    public void addRide(Ride ride) throws SQLException {
        String sql = "INSERT INTO rides (ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ride.getRideId());
            ps.setInt(2, ride.getUserId());
            ps.setInt(3, ride.getDriverId());
            ps.setString(4, ride.getPickupLocation());
            ps.setString(5, ride.getDropoffLocation());
            ps.setDouble(6, ride.getFare());
            ps.setString(7, ride.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Ride> getAllRides() throws SQLException {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rides.add(new Ride(
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup_location"),
                        rs.getString("dropoff_location"),
                        rs.getDouble("fare"),
                        rs.getString("status")
                ));
            }
        }
        return rides;
    }

    // updateRide, deleteRide can be added similarly
}



