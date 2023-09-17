package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Id {


   String name;


   String value;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    
}