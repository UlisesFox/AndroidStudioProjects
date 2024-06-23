package com.example.disfraces;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Compras extends AppCompatActivity {
    private Disfraz disfraz;
    private TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        disfraz = (Disfraz) getIntent().getSerializableExtra("Disfraz");
        datos = (TextView) findViewById(R.id.EditText);
        datos.setText("Información registrada:\n" +
                "Nombre: " + disfraz.getNombre() + "\n" +
                "Direccion: " + disfraz.getDomicilio() + "\n" +
                "Producto: " + disfraz.getProducto() + "\n" +
                "Talla: " + disfraz.getTalla() + "\n" +
                "Tele Contacto: " + disfraz.getTelefono());

    }
    public void regresarC(View view){
        Intent intent = new Intent(this,ActMenu.class);
        startActivity(intent);
        finish();
    }
}