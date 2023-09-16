package com.example.lab2iot.dto;

import com.google.gson.annotations.SerializedName;

   
public class Info {

   @SerializedName("seed")
   String seed;

   @SerializedName("results")
   int results;

   @SerializedName("page")
   int page;

   @SerializedName("version")
   String version;


    public void setSeed(String seed) {
        this.seed = seed;
    }
    public String getSeed() {
        return seed;
    }
    
    public void setResults(int results) {
        this.results = results;
    }
    public int getResults() {
        return results;
    }
    
    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }
    
}