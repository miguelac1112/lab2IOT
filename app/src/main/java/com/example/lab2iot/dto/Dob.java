package com.example.lab2iot.dto;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

   
public class Dob {


   Date date;


   int age;


    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    
}