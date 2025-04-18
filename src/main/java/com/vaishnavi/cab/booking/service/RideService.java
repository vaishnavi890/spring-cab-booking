package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import java.sql.SQLException;
import java.util.List;

public class RideService {
    private RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void bookRide(Ride ride) throws SQLException {
        ride.setFare(calculateFare(ride)); // business logic
        ride.setStatus("Booked");
        rideRepository.addRide(ride);
    }

    private double calculateFare(Ride ride) {
        return 50.0 + (ride.getPickupLocation().length() + ride.getDropoffLocation().length()) * 2; // dummy logic
    }

    public List<Ride> getAllRides() throws SQLException {
        return rideRepository.getAllRides();
    }
}



