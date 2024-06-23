package com.example.ingresosandgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Gastos extends AppCompatActivity {

    private EditText num, fe, mo, lug;
    private Spinner mes;
    private String[] me = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    String contenido = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);

        num = (EditText) findViewById(R.id.ETGasto);
        fe = (EditText) findViewById(R.id.ETFecha2);
        mo = (EditText) findViewById(R.id.ETMonto2);
        lug = (EditText) findViewById(R.id.ETLugar);
        mes = (Spinner) findViewById(R.id.SPMes2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, me);
        mes.setAdapter(adapter);
    }

    public void enviar2(View view){
        int numero = Integer.parseInt(num.getText().toString());
        String fecha = fe.getText().toString();
        int monto = Integer.parseInt(mo.getText().toString());
        String mess = mes.getSelectedItem().toString();
        String luga = lug.getText().toString();
        if(fecha != ""){
            guardarArchivoSD(numero, fecha, monto, mess, luga);
        } else {
            Toast.makeText(this,"Debes escribir un nombre.",Toast.LENGTH_SHORT).show();
        }
    }

    private void guardarArchivoSD(int numero, String n, int monto, String mess, String luga){
        try{
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjetaSD.getPath(),Toast.LENGTH_SHORT).show();
            File archivo = new File(tarjetaSD.getPath(), n);

            contenido = numero + "\n" + n + "\n" + monto + "\n" + mess + "\n" + luga;

            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(archivo.getName(), Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();

            Toast.makeText(this,"Información almacenada !!!.",Toast.LENGTH_SHORT).show();
            num.setText("");
            fe.setText("");
            mo.setText("");
            lug.setText("");
        } catch (IOException e){
            Toast.makeText(this,"El archivo no se pudo guardar.",Toast.LENGTH_SHORT).show();
        }
    }

    public void salir(View view){
        Intent intent = new Intent(this,MenuLatera.class);
        startActivity(intent);
        finish();
    }
}