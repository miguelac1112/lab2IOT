package com.example.lab2iot.services;

import com.example.lab2iot.dto.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUser {

    @GET("/api")
    Call<List<Results>> getResults();
}
