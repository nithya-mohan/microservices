package com.traveldoo.hoteldescservice.respository;

import com.traveldoo.hoteldescservice.models.Rating;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RatingRepositoryImpl implements RatingRepository{

    private HashOperations hashOperations;

    public RatingRepositoryImpl(RedisTemplate<String, Rating> redisTemplate){
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Rating rating) {
        hashOperations.put("RATING", rating.getHotelId(), rating);
    }

    @Override
    public Map<String, Rating> findAll() {
        return hashOperations.entries("RATING");
    }

    @Override
    public Rating findById(String id) {
        return (Rating)hashOperations.get("RATING", id);
    }

    @Override
    public void update(Rating rating) {
        save(rating);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("RATING", id);
    }
}
