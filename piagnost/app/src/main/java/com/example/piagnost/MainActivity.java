package com.example.piagnost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                if(nuevoUsuario()){
                    intent = new Intent(MainActivity.this, Menulateral.class);
                } else {
                    intent = new Intent(MainActivity.this, Login.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea,3000);
    }
    private boolean nuevoUsuario(){
        SharedPreferences preferencias = getSharedPreferences("user.dat",MODE_PRIVATE);
        return preferencias.getBoolean("registrado", false);
    }
}