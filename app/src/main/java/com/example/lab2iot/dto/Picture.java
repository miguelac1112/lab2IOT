package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Picture {

   @SerializedName("large")
   String large;

   @SerializedName("medium")
   String medium;

   @SerializedName("thumbnail")
   String thumbnail;


    public void setLarge(String large) {
        this.large = large;
    }
    public String getLarge() {
        return large;
    }
    
    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getMedium() {
        return medium;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    
}