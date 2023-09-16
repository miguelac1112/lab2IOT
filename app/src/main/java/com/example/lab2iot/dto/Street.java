package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Street {

   @SerializedName("number")
   int number;

   @SerializedName("name")
   String name;


    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
}