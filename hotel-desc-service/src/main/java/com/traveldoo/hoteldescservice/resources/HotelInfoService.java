package com.traveldoo.hoteldescservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.traveldoo.hoteldescservice.models.Hotel;
import com.traveldoo.hoteldescservice.models.HotelInfoRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class HotelInfoService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(HotelInfoService.class);

    @HystrixCommand(fallbackMethod = "getFallbackHotelInfo")
    public HotelInfoRS getHotelInfo() {
        HotelInfoRS hotelInfoRS = restTemplate.getForObject("http://hotel-info-service/hotels/list", HotelInfoRS.class);
        return hotelInfoRS;
    }

    public HotelInfoRS getFallbackHotelInfo() {
        logger.info("Inside getFallbackHotelInfo()");
        return new HotelInfoRS(0, Arrays.asList(new Hotel("0", "No Hotel found", "")));
    }
}
