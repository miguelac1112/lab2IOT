package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Name {


   String title;


   String first;


   String last;


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    public String getFirst() {
        return first;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    public String getLast() {
        return last;
    }
    
}