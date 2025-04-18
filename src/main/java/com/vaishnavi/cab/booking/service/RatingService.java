package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import java.sql.SQLException;
import java.util.List;

public class RatingService {
    private RatingRepository ratingRepository;

    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void submitRating(Rating rating) throws SQLException {
        if (rating.getRating() >= 1 && rating.getRating() <= 5) {
            ratingRepository.rateDriver(rating);
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }

    public List<Rating> getAllRatings() throws SQLException {
        return ratingRepository.getAllRatings();
    }
}


