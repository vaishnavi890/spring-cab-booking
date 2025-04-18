package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import java.sql.SQLException;
import java.util.List;

public class RatingController {
    private RatingService ratingService;

    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    public void rate(Rating rating) {
        try {
            ratingService.submitRating(rating);
            System.out.println("Rating submitted.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Rating error: " + e.getMessage());
        }
    }

    public void listRatings() {
        try {
            List<Rating> ratings = ratingService.getAllRatings();
            ratings.forEach(r -> System.out.println(r.getRatingId() + " | " + r.getRating() + " Stars | " + r.getReview()));
        } catch (SQLException e) {
            System.err.println("Error fetching ratings: " + e.getMessage());
        }
    }

    public void addRating(Rating rating) {
    }

    public void listAllRatings() {
    }
}



