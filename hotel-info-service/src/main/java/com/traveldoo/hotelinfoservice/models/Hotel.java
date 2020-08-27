package com.traveldoo.hotelinfoservice.models;

public class Hotel {
    private String hotelId;
    private String name;
    private String location;

    public Hotel(String hotelId, String name, String location) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
    }

    public Hotel() {

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
}
