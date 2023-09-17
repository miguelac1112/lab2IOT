package com.example.lab2iot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.lab2iot.databinding.ActivityMainBinding;

import java.util.UUID;

public class contadorUsuario extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_contador_usuario);

        UUID uuid = UUID.randomUUID();

        findViewById(R.id.startButton).setOnClickListener(view -> {

            Data dataBuilder = new Data.Builder()
                    .putInt("numero", 104)
                    .build();

            WorkRequest workRequest = new OneTimeWorkRequest.Builder(ContadorWorker.class)
                    .setId(uuid)
                    .setInputData(dataBuilder)
                    .build();

            WorkManager.getInstance(this) // Usa 'this' para obtener el contexto
                    .enqueue(workRequest);
        });

        WorkManager.getInstance(this) // Usa 'this' para obtener el contexto
                .getWorkInfoByIdLiveData(uuid)
                .observe(this, workInfo -> {
                    if (workInfo != null) {
                        Data progress = workInfo.getProgress();
                        int contador = progress.getInt("contador", 0);
                        TextView textView = findViewById(R.id.counterText);
                        textView.setText(String.valueOf(contador));
                    } else {
                        Log.d("msg-test", "work info == null ");
                    }
                });
    }
}