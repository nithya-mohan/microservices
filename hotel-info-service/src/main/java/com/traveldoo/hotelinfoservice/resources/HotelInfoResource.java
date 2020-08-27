package com.traveldoo.hotelinfoservice.resources;

import com.traveldoo.hotelinfoservice.models.Hotel;
import com.traveldoo.hotelinfoservice.models.HotelInfoRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/hotels")
public class HotelInfoResource {

	private static final Logger logger = LoggerFactory.getLogger(HotelInfoResource.class);

	@RequestMapping("/list")
    public HotelInfoRS getHotelList() {

		logger.info("Fetching all hotel list");

    	Hotel hotel1=new Hotel("100", "Novotel", "Kochi");
    	Hotel hotel2=new Hotel("200", "Marriot", "Kochi");
    	Hotel hotel3=new Hotel("300", "Holiday-INN", "Kochi");

    	List<Hotel>hotelList= new ArrayList<Hotel>();
    	hotelList.add(hotel3);
    	hotelList.add(hotel2);
    	hotelList.add(hotel1);
    	
    	HotelInfoRS hotelInfoRS= new HotelInfoRS(3, hotelList);
    
    	
    	return hotelInfoRS;
    	
    }

}
