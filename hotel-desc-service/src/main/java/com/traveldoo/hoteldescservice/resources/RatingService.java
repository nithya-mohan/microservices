package com.traveldoo.hoteldescservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.traveldoo.hoteldescservice.models.Hotel;
import com.traveldoo.hoteldescservice.models.Rating;
import com.traveldoo.hoteldescservice.respository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);

    @HystrixCommand(fallbackMethod = "getFallbackRating")
    public Rating getRating(Hotel hotel, RatingRepository ratingRepository) {
        Rating rating = restTemplate.getForObject("http://ratings-data-service/ratings/hotels/" + hotel.getHotelId(), Rating.class);
        try{
            ratingRepository.save(rating);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return rating;
    }

    public Rating getFallbackRating(com.traveldoo.hoteldescservice.models.Hotel hotel, RatingRepository ratingRepository) {
        logger.info("Inside getFallbackRating()");
        Rating rating = null;
        try{
            rating = ratingRepository.findById(hotel.getHotelId());
        }catch (Exception exception){
            exception.printStackTrace();
        }

        if(null == rating){
            rating = new Rating("", 0);
        }

        return rating;
    }
}
