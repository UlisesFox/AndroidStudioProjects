package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    private EditText cod, nom, mar, pre, cla;
    private TextView res;
    private Servicio[] servicios;
    private int contador = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        servicios = new Servicio[5];

        cod = (EditText) findViewById(R.id.codigo);
        nom = (EditText) findViewById(R.id.nombre);
        mar = (EditText) findViewById(R.id.marca);
        pre = (EditText) findViewById(R.id.precio);
        cla = (EditText) findViewById(R.id.clasifi);
        res = (TextView) findViewById(R.id.res);
    }

    public void registrar (View view){
        int co = Integer.parseInt(cod.getText().toString());
        String no = nom.getText().toString();
        String ma = mar.getText().toString();
        String pe = pre.getText().toString();
        String cl = cla.getText().toString();
        servicios[contador] = new Servicio(co, no, ma, pe, cl);
        contador++;
        limpiar(view);
    }
    public void buscar (View view){
        int idk = Integer.parseInt(cod.getText().toString());
        String mostrar = servicios[idk].getNombre() + "\n";
        mostrar += servicios[idk].getMarca() + "\n";
        mostrar += servicios[idk].getPrecio() + "\n";
        mostrar += servicios[idk].getClasificacion() + "\n";

        res.setText(mostrar);
    }
    public void actualizar (View view){
        int idk = Integer.parseInt(cod.getText().toString());
        servicios[0].setNombre("jugete");
        servicios[0].setMarca("Matel");
        servicios[0].setPrecio("800");
        servicios[0].setClasificacion("A");
    }
    public void salir (View view){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }
    public void limpiar (View view){
        cod.setText("");
        nom.setText("");
        mar.setText("");
        pre.setText("");
        cla.setText("");
    }
}