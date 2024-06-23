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

public class Ingresos extends AppCompatActivity {

    private EditText num, fe, mo, des;
    private Spinner mes;
    private String[] me = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    String contenido = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        num = (EditText) findViewById(R.id.ETIngreso);
        fe = (EditText) findViewById(R.id.ETFecha);
        mo = (EditText) findViewById(R.id.ETMonto);
        des = (EditText) findViewById(R.id.ETDescrip);
        mes = (Spinner) findViewById(R.id.SPMes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, me);
        mes.setAdapter(adapter);

    }

    public void enviar(View view){
        int numero = Integer.parseInt(num.getText().toString());
        String fecha = fe.getText().toString();
        int monto = Integer.parseInt(mo.getText().toString());
        String mess = mes.getSelectedItem().toString();
        String descrip = des.getText().toString();
        if(fecha != ""){
                guardarArchivoSD(numero, fecha, monto, mess, descrip);
        } else {
            Toast.makeText(this,"Debes escribir un nombre.",Toast.LENGTH_SHORT).show();
        }
    }

    private void guardarArchivoSD(int numero, String n, int monto, String mess, String descrip){
        try{
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjetaSD.getPath(),Toast.LENGTH_SHORT).show();
            File archivo = new File(tarjetaSD.getPath(), n);

            contenido = numero + "\n" + n + "\n" + monto + "\n" + mess + "\n" + descrip;

            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(archivo.getName(), Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();

            Toast.makeText(this,"Información almacenada !!!.",Toast.LENGTH_SHORT).show();
            num.setText("");
            fe.setText("");
            mo.setText("");
            des.setText("");
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