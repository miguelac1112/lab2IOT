package com.example.lab2iot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lab2iot.dto.Results;
import com.example.lab2iot.services.RandomUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signUp extends AppCompatActivity {

    RandomUser randomUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        randomUser = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RandomUser.class);

        fetchProfileFromWs();
    }

    public void fetchProfileFromWs(){
        randomUser.getResults().enqueue(new Callback<List<Results>>(){
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                if(response.isSuccessful()){
                    List<Results> results = response.body();
                    for(Results r : results){
                        Log.d("msg-test","first: "+r.getName().getFirst()+" last: "+r.getName().getLast());
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
            }
        });

    }
}