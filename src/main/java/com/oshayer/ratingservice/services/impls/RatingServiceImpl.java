package com.oshayer.ratingservice.services.impls;

import com.oshayer.ratingservice.entities.RatingEntity;
import com.oshayer.ratingservice.repositories.RatingRepository;
import com.oshayer.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public RatingEntity createRating(RatingEntity rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<RatingEntity> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public RatingEntity getRatingById(String id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + id));
    }

    @Override
    public List<RatingEntity> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<RatingEntity> getRatingsByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public RatingEntity updateRating(String id, RatingEntity rating) {
        Optional<RatingEntity> existing = ratingRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Rating not found with id: " + id);
        }
        RatingEntity toUpdate = existing.get();
        toUpdate.setRating(rating.getRating());
        toUpdate.setFeedback(rating.getFeedback());
        // You can also update userId/hotelId if needed
        return ratingRepository.save(toUpdate);
    }
}
