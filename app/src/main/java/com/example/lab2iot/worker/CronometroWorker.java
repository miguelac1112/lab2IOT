package com.example.lab2iot.worker;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CronometroWorker extends Worker {

    private static final String PREFS_NAME = "CronometroPrefs";
    private static final String PREF_RUNNING = "isRunning";
    private static final String PREF_BASE = "baseTime";

    public CronometroWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Obtiene el estado del cronómetro (corriendo o pausado) desde SharedPreferences
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isRunning = prefs.getBoolean(PREF_RUNNING, false);
        long baseTime = prefs.getLong(PREF_BASE, System.currentTimeMillis());

        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedMillis = currentTime - baseTime;

            // Calcula el tiempo en formato "horas:minutos:segundos"
            int hours = (int) (elapsedMillis / 3600000);
            int minutes = (int) ((elapsedMillis / 60000) % 60);
            int seconds = (int) ((elapsedMillis / 1000) % 60);
            String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            // Envía el tiempo al MainActivity a través de una notificación
            // Puedes implementar esto según tus necesidades
            sendTimeToMainActivity(formattedTime);

            // Indica que el trabajo en segundo plano aún está en curso
            return Result.retry();
        } else {
            // Indica que el trabajo en segundo plano ha terminado
            return Result.success();
        }
    }

    private void sendTimeToMainActivity(String formattedTime) {
        // Puedes implementar esto según tus necesidades
        // Por ejemplo, puedes enviar una notificación al MainActivity
    }
}
