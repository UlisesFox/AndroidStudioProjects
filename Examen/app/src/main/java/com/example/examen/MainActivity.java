package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText con;
    private Spinner cas;
    private String[] caso = {"Edgar", "Doky", "Profesor", "Eluky", "Pucca"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cas = (Spinner) findViewById(R.id.spi1);
        con = (EditText) findViewById(R.id.pass);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, caso);
        cas.setAdapter(adapter);

    }

    public void aceptar(View view){
        String password = con.getText().toString();
                if(password.equals("12345")){
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Error en la contraseña", Toast.LENGTH_SHORT).show();
                }
    }

    public  void salir(View view){
        finish();
    }
}