package com.oshayer.ratingservice.repositories;

import com.oshayer.ratingservice.entities.RatingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<RatingEntity, String> {

    // Custom finder methods
    List<RatingEntity> findByUserId(Long userId);

    List<RatingEntity> findByHotelId(Long hotelId);
}
