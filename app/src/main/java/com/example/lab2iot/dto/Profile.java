package com.example.lab2iot.dto;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Profile {

   @SerializedName("results")
   List<Results> results;

   @SerializedName("info")
   Info info;


    public void setResults(List<Results> results) {
        this.results = results;
    }
    public List<Results> getResults() {
        return results;
    }
    
    public void setInfo(Info info) {
        this.info = info;
    }
    public Info getInfo() {
        return info;
    }
    
}