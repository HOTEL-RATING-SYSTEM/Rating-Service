package com.oshayer.ratingservice.controllers;

import com.oshayer.ratingservice.entities.RatingEntity;
import com.oshayer.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    // ✅ Create a new rating
    @PostMapping("/create")
    public ResponseEntity<RatingEntity> createRating(@RequestBody RatingEntity rating) {
        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    // ✅ Get all ratings
    @GetMapping("/all")
    public ResponseEntity<List<RatingEntity>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    // ✅ Get rating by ID
    @GetMapping("/{id}")
    public ResponseEntity<RatingEntity> getRatingById(@PathVariable String id) {
        return ResponseEntity.ok(ratingService.getRatingById(id));
    }

    // ✅ Get ratings by User ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingEntity>> getRatingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    // ✅ Get ratings by Hotel ID
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingEntity>> getRatingsByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

    // ✅ Update rating
    @PutMapping("/update/{id}")
    public ResponseEntity<RatingEntity> updateRating(@PathVariable String id, @RequestBody RatingEntity rating) {
        return ResponseEntity.ok(ratingService.updateRating(id, rating));
    }

    // ✅ Delete rating
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
