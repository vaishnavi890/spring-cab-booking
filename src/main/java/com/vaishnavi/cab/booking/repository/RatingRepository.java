package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DBConnection;
import com.vaishnavi.cab.booking.model.Rating;
import java.sql.*;
import java.util.*;

public class RatingRepository {
    public void rateDriver(Rating rating) throws SQLException {
        String sql = "INSERT INTO ratings (rating_id, ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rating.getRatingId());
            ps.setInt(2, rating.getRideId());
            ps.setInt(3, rating.getUserId());
            ps.setInt(4, rating.getDriverId());
            ps.setInt(5, rating.getRating());
            ps.setString(6, rating.getReview());
            ps.executeUpdate();
        }
    }

    public List<Rating> getAllRatings() throws SQLException {
        List<Rating> list = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                ));
            }
        }
        return list;
    }
}



