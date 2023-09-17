package com.example.lab2iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class inicioUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);

        Intent intent1 = getIntent();
        String nombre_apellido = intent1.getStringExtra("nombre_apellido");
        String user_name = intent1.getStringExtra("userName");
        String urlPicture = intent1.getStringExtra("urlPicture");

        TextView nombreApellido = findViewById(R.id.textView5);
        nombreApellido.setText(nombre_apellido);

        TextView userName = findViewById(R.id.textView4);
        userName.setText(user_name);

        ImageView imageView = findViewById(R.id.imageView4);
        Glide.with(this)
                .load(urlPicture)
                .placeholder(R.drawable.google_icon)
                .into(imageView);
    }
}