package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView detalle;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        detalle = (TextView) findViewById(R.id.txtDetalle);
        producto = (Producto) getIntent().getSerializableExtra("Info Producto");

        detalle.setText("Datos del producto:\n" +
                "Codigo: " + producto.getCodigo() + "\n" +
                "Descripción: " + producto.getDescripcion() + "\n" +
                "Color: " + producto.getColor() + "\n" +
                "Costo: "+ producto.getCosto());
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}