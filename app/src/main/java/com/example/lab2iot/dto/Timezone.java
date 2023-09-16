package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Timezone {

   @SerializedName("offset")
   String offset;

   @SerializedName("description")
   String description;


    public void setOffset(String offset) {
        this.offset = offset;
    }
    public String getOffset() {
        return offset;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
}