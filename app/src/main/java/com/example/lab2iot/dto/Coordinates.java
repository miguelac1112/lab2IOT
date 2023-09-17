package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Coordinates {


   String latitude;


   String longitude;


    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return latitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLongitude() {
        return longitude;
    }
    
}