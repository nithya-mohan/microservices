package com.traveldoo.hoteldescservice.models;

import java.util.ArrayList;
import java.util.List;

public class HotelInfoRS {
	
	
private int resultCount;
private List<Hotel> hotels=new ArrayList<Hotel>();
public HotelInfoRS(int resultCount, List<Hotel> hotels) {

	this.resultCount = resultCount;
	this.hotels = hotels;
}
public HotelInfoRS() {

}

public int getResultCount() {
	return resultCount;
}

public void setResultCount(int resultCount) {
	this.resultCount = resultCount;
}

public List<Hotel> getHotels() {
	return hotels;
}

public void setHotels(List<Hotel> hotels) {
	this.hotels = hotels;
}



}
