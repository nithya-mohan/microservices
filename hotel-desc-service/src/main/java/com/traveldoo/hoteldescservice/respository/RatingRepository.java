package com.traveldoo.hoteldescservice.respository;

import com.traveldoo.hoteldescservice.models.Rating;
import java.util.Map;
public interface RatingRepository {

    void save(Rating rating);
    Map<String, Rating> findAll();
    Rating findById(String id);
    void update(Rating rating);
    void delete(String id);
}
