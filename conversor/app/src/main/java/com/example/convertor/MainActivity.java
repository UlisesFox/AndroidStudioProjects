package com.example.convertor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText mts;
    private Spinner lista;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mts = (EditText) findViewById(R.id.txtMetros);
        res = (TextView) findViewById(R.id.txtResultado);
        lista = (Spinner) findViewById(R.id.SpOpciones);

        String[] menu = {"Pies", "Pulgadas", "Yardas"};

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_custom, menu);
        lista.setAdapter(adapter);
    }

    public void convertidor(View view){
        int n = Integer.parseInt(mts.getText().toString());
        double resultado;
        String unidad = lista.getSelectedItem().toString();

        if(unidad.equals("Pies")){
            resultado = n * 3.2808;
            res.setText("Pies: " + String.valueOf(resultado));
        }else if(unidad.equals("Pulgadas")){
            resultado = n * 39.3701;
            res.setText("Pulgadas: " + String.valueOf(resultado));
        }else if(unidad.equals("Yardas")){
            resultado = n * 1.09361;
            res.setText("Yardas: " + String.valueOf(resultado));
        }
    }
}