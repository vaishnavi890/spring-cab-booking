package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import java.sql.SQLException;
import java.util.List;

public class RideController {
    private RideService rideService;

    public void setRideService(RideService rideService) {
        this.rideService = rideService;
    }

    public void bookRide(Ride ride) {
        try {
            rideService.bookRide(ride);
            System.out.println("Ride booked successfully.");
        } catch (SQLException e) {
            System.err.println("Error booking ride: " + e.getMessage());
        }
    }

    public void listRides() {
        try {
            List<Ride> rides = rideService.getAllRides();
            rides.forEach(r -> System.out.println(r.getRideId() + " | " + r.getPickupLocation() + " -> " + r.getDropoffLocation()));
        } catch (SQLException e) {
            System.err.println("Error fetching rides: " + e.getMessage());
        }
    }

    public void createRide(int rideUserId, int rideDriverId, String pickup, String dropoff) {
    }

    public void listAllRides() {
    }
}



