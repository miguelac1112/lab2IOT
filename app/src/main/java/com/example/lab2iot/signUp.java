package com.example.lab2iot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lab2iot.databinding.ActivityMainBinding;
import com.example.lab2iot.dto.Profile;
import com.example.lab2iot.dto.Results;
import com.example.lab2iot.services.RandomUser;
import com.google.android.material.textfield.TextInputEditText;

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

        Log.d("msg-llegue0","llegue0");
        fetchProfileFromWs();
    }

    public void fetchProfileFromWs(){
        randomUser.getResults().enqueue(new Callback<Profile>(){
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Log.d("msg-llegue0","llegue1");
                if (response.isSuccessful()) {
                    Profile profile = response.body();
                    Log.d("msg-llegue0","llegue2");

                    if (profile != null) {
                        List<Results> results = profile.getResults();

                        if(results!=null && !results.isEmpty()){
                            String nombre = results.get(0).getName().getFirst();
                            String apellido = results.get(0).getName().getLast();
                            String correo = results.get(0).getEmail();
                            String contrasenha = results.get(0).getLogin().getPassword();

                            TextInputEditText etNombre = findViewById(R.id.etNombre);
                            etNombre.setText(nombre);

                            TextInputEditText etApellido = findViewById(R.id.etApellido);
                            etApellido.setText(apellido);

                            TextInputEditText etCorreo = findViewById(R.id.etCorreo);
                            etCorreo.setText(correo);

                            TextInputEditText etContraseña = findViewById(R.id.etContraseña);
                            etContraseña.setText(contrasenha);
                        }
                    } else {
                        Log.d("msg-Error", "La lista de resultados está vacía o nula.");
                    }
                } else {
                    Log.d("msg-Error", "La respuesta no fue exitosa: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Log.d("msg-llegue0", "Error al realizar la solicitud: " + t.getMessage());
            }
        });

    }
}