package com.example.ingresosandgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DatosG extends AppCompatActivity {

    private TextView da2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_g);

        da2 = (TextView) findViewById(R.id.TVDatosG);

        String fecha = da2.getText().toString();
        if(fecha == ""){
            abrirArchivoSD2(fecha);
        } else {
            Toast.makeText(this,"Debes escribir un nombre.",Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirArchivoSD2(String n){
        try{
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File archivo = new File(tarjetaSD.getPath(), n);
            InputStreamReader abrirArchivo = new
                    InputStreamReader(openFileInput(archivo.getName()));
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String textoLeido = "";
            while(linea != null){
                textoLeido += linea + '\n';
                linea = leerArchivo.readLine();
            }
            leerArchivo.close();
            abrirArchivo.close();
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("contenido", textoLeido);
            startActivity(intent);
        } catch (IOException e){
            Toast.makeText(this,"El archivo no se pudo leer.",Toast.LENGTH_SHORT).show();
        }
    }

    public void salir(View view){
        Intent intent = new Intent(this,MenuLatera.class);
        startActivity(intent);
        finish();
    }
}