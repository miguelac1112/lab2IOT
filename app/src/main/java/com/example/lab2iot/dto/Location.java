package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Location {

   @SerializedName("street")
   Street street;

   @SerializedName("city")
   String city;

   @SerializedName("state")
   String state;

   @SerializedName("country")
   String country;

   @SerializedName("postcode")
   int postcode;

   @SerializedName("coordinates")
   Coordinates coordinates;

   @SerializedName("timezone")
   Timezone timezone;


    public void setStreet(Street street) {
        this.street = street;
    }
    public Street getStreet() {
        return street;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
    public int getPostcode() {
        return postcode;
    }
    
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }
    public Timezone getTimezone() {
        return timezone;
    }
    
}