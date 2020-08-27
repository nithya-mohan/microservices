package com.traveldoo.ratingsdataservice.model;

public class Rating {

    private String hotelId;
    private int rating;

    public Rating(String hotelId, int rating) {
        this.hotelId = hotelId;
        this.rating = rating;
    }


    public Rating() {

    }

    public String getHotelId() {
        return hotelId;
    }


    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
