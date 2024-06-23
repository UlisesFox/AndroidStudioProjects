package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

public class Menu extends AppCompatActivity {

    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        servicio = (Servicio) getIntent().getSerializableExtra("servicio");
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menuprin, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.resg:
                Intent registro = new Intent(this, Registro.class);
                startActivity(registro);
                break;
            case R.id.cons:
                Intent consultar = new Intent(this, Consultar.class);
                startActivity(consultar);
                break;
            case R.id.sali:
                cerrarSesion();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void cerrarSesion(){
        SharedPreferences preferencias = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        editor.apply();
        Intent logout = new Intent(this,MainActivity.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
        finish();
    }
}