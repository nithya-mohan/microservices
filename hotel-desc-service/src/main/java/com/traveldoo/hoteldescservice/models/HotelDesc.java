package com.traveldoo.hoteldescservice.models;

public class HotelDesc {
    private String hotelId;
    private String name;
    private String location;
    private int rating;

    public HotelDesc(String hotelId, String name, String location, int rating) {

		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.rating = rating;
	}

	public HotelDesc() {

	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
    
    
    
}
