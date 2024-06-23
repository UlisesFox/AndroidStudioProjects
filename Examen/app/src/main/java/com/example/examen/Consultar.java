package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Consultar extends AppCompatActivity {

    private  Servicio servicio;
    private TextView ress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        ress = (TextView) findViewById(R.id.con);
        servicio = (Servicio) getIntent().getSerializableExtra("Servicio");
        ress.setText("Información registrada:\n" +
                "Codigo: " + servicio.getCodigo() + "\n" +
                "Nombre: " + servicio.getNombre() + "\n" +
                "Marca: " + servicio.getMarca() + "\n" +
                "Precio: " + servicio.getPrecio() + "\n" +
                "Clasificacion: " + servicio.getClasificacion());

        ress.setText("Información registrada:\n" + "Codigo: 0" + "\n" + "Nombre: Jugete" + "\n" + "Marca: Matel" + "\n" + "Precio: 800" + "\n" + "Clasificacion: A" + "\n\n" +
                "Información registrada:\n" + "Codigo: 1" + "\n" + "Nombre: Comida" + "\n" + "Marca: Dominos" + "\n" + "Precio: 300" + "\n" + "Clasificacion: B" + "\n\n" +
                "Información registrada:\n" + "Codigo: 2" + "\n" + "Nombre: Medicamneto" + "\n" + "Marca: Sinsimi" + "\n" + "Precio: 1000" + "\n" + "Clasificacion:C" + "\n\n" +
                "Información registrada:\n" + "Codigo: 3" + "\n" + "Nombre: Dinamita" + "\n" + "Marca: ACME" + "\n" + "Precio: 0" + "\n" + "Clasificacion: AAA" + "\n\n" +
                "Información registrada:\n" + "Codigo: 4" + "\n" + "Nombre: Agua" + "\n" + "Marca: Ciel" + "\n" + "Precio: 200" + "\n" + "Clasificacion: A");

    }

    public void salir (View view){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }
}