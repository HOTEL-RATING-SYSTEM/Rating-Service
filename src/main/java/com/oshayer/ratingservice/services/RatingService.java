package com.oshayer.ratingservice.services;

import com.oshayer.ratingservice.entities.RatingEntity;

import java.util.List;

public interface RatingService {

    RatingEntity createRating(RatingEntity rating);

    List<RatingEntity> getAllRatings();

    RatingEntity getRatingById(String id);

    List<RatingEntity> getRatingsByUserId(Long userId);

    List<RatingEntity> getRatingsByHotelId(Long hotelId);

    void deleteRating(String id);

    RatingEntity updateRating(String id, RatingEntity rating);
}
