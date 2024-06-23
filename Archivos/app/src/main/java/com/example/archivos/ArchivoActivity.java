package com.example.archivos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArchivoActivity extends AppCompatActivity {

    EditText nombreArchivo;
    Button accion;

    String contenido = "";
    int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivo);

        nombreArchivo = (EditText) findViewById(R.id.editTextText);
        accion = (Button) findViewById(R.id.button);

        tipo = (int) getIntent().getIntExtra("tipo", 1);

        switch (tipo){
            case 1: accion.setText("abrir"); break;
            case 2: accion.setText("Guardar");
            contenido = (String) getIntent().getStringExtra("contenido");
            break;
        }
    }

    public void  realizaAccion(View view){
        String nomArch = nombreArchivo.getText().toString();
        if(nomArch != ""){
            switch (tipo){
                case 1: abrirArchivoSD(nomArch); break;
                case 2: guardarArchivoSD(nomArch); break;
            }
            finish();
        }else{
            Toast.makeText(this, "Debes escribir un nombre.", Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirArchivoSD(String n){
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File archivo = new File(tarjetaSD.getPath(), n);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(archivo.getName()));
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String textLeido = "";
            while (linea != null){
                textLeido += linea+ '\n';
                linea = leerArchivo.readLine();
            }
            leerArchivo.close();
            abrirArchivo.close();

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("contenido", textLeido);
            startActivity(intent);
        } catch (IOException e){
            Toast.makeText(this, "El archivo no se pudo leer.", Toast.LENGTH_SHORT).show();
        }
    }

    private  void guardarArchivoSD(String n){
        try {
            File TarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, TarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File archivo = new File(TarjetaSD.getPath(), n);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(archivo.getName(), Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this, "Informacion almacenda!!!.", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this, "El archivo no se pudo guardar.", Toast.LENGTH_SHORT).show();
        }
    }
}