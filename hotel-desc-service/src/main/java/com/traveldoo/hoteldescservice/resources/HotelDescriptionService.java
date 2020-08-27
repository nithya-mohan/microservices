package com.traveldoo.hoteldescservice.resources;

import com.traveldoo.hoteldescservice.models.HotelDesc;
import com.traveldoo.hoteldescservice.models.HotelInfoRS;
import com.traveldoo.hoteldescservice.models.Rating;
import com.traveldoo.hoteldescservice.respository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
public class HotelDescriptionService {

    @Autowired
    HotelInfoService hotelInfoService;

    @Autowired
    RatingService ratingService;

    private static final Logger logger = LoggerFactory.getLogger(HotelDescriptionService.class);

    private RatingRepository ratingRepository;

    public HotelDescriptionService(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @RequestMapping("/ratings/all")
    public Map<String, Rating> getRatings(){
        logger.info("Fetching all cached ratings");
        return ratingRepository.findAll();
    }

   @RequestMapping("/hotelDesc")
   public List<HotelDesc> getHotelDesc() {
        logger.info("Fetching all hotel details");
        HotelInfoRS hotelInfoRS = hotelInfoService.getHotelInfo();
        return hotelInfoRS.getHotels().stream()
                .map(hotel -> {
                    Rating rating = ratingService.getRating(hotel, ratingRepository);
                    return new HotelDesc(hotel.getHotelId(),hotel.getName(), hotel.getLocation(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}