package com.example.lab2iot;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.lab2iot.worker.CronometroWorker;

public class cronometroUsuario extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro_usuario);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                int hours = (int) (elapsedMillis / 3600000);
                int minutes = (int) ((elapsedMillis / 60000) % 60);
                int seconds = (int) ((elapsedMillis / 1000) % 60);
                String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                chronometer.setText(time);
            }
        });

        prefs = getSharedPreferences("CronometroPrefs", Context.MODE_PRIVATE);

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarCronometro(v);
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerCronometro(v);
            }
        });

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerCronometro(v);
            }
        });

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reanudarCronometro(v);
            }
        });

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCronometro(v);
            }
        });
    }

    public void iniciarCronometro(View view) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;

            // Inicia el trabajo del CronometroWorker
            OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(CronometroWorker.class).build();
            WorkManager.getInstance(this).enqueue(workRequest);
            prefs.edit().putBoolean("isRunning", true).apply();
            prefs.edit().putLong("baseTime", chronometer.getBase()).apply();
        }
    }

    public void detenerCronometro(View view) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;

            // Detiene el trabajo del CronometroWorker
            WorkManager.getInstance(this).cancelAllWork();
            prefs.edit().putBoolean("isRunning", false).apply();
        }
    }

    public void reanudarCronometro(View view) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;

            // Inicia el trabajo del CronometroWorker
            OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(CronometroWorker.class).build();
            WorkManager.getInstance(this).enqueue(workRequest);
            prefs.edit().putBoolean("isRunning", true).apply();
        }
    }

    public void limpiarCronometro(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        running = false;

        // Detiene el trabajo del CronometroWorker
        WorkManager.getInstance(this).cancelAllWork();
        prefs.edit().putBoolean("isRunning", false).apply();
    }
}

