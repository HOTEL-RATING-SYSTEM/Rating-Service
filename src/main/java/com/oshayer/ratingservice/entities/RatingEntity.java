package com.oshayer.ratingservice.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RatingEntity {

    @Id
    private String id; // MongoDB will use ObjectId

    // Reference to User (from UserService)
    private Long userId;

    // Reference to Hotel (from HotelService)
    private Long hotelId;

    private int rating;       // e.g., 1 to 5
    private String feedback;



}
