package com.traveldoo.ratingsdataservice.resources;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveldoo.ratingsdataservice.model.Rating;


@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    private static final Logger logger = LoggerFactory.getLogger(RatingsResource.class);

    @RequestMapping("/hotels/{hotelId}")
    public Rating getHotelRating(@PathVariable("hotelId") String hotelId) {
        logger.info("Trying to fetch ratings for hotel with id " + hotelId);
        return new Rating(hotelId, getRandomNumberInRange());
    }

    private  int getRandomNumberInRange() {
        Random r = new Random();
    	return r.nextInt(6);
    }


}
