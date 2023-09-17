package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Street {


   int number;


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