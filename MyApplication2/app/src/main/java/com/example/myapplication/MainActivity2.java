package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    //componentes asosiados
    private EditText mts;
    private CheckBox pie, pul, yar;
    private TextView res;

    //instancia de clase convertior
    private Convertidor convertidor;

    //formato de decimales
    private static DecimalFormat formatoDecimales = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mts = (EditText) findViewById(R.id.metros2);
        pie = (CheckBox) findViewById(R.id.pie);
        pul = (CheckBox) findViewById(R.id.pulgada);
        yar = (CheckBox) findViewById(R.id.yarda);
        res = (TextView) findViewById(R.id.resultado2);

        convertidor = new Convertidor(0.0, 0.0, "");
    }

    public void convertirMetodos(View view){

        double m=0, r=0;
        boolean b = false;

        //Extraccion de valor "metros" a convertir
        m = Double.parseDouble(mts.getText().toString());
        convertidor.setMetros(m);

        //identificar la opcion elegida por usuario
        if(pie.isChecked()){
            r = m * 3.2808;
            convertidor.setPies(r);
            b = true;
        }
        if (pul.isChecked()){
            r = m * 39.3701;
            convertidor.setPulgadas(r);
            b = true;
        }
        if (yar.isChecked()){
            r = m * 1.09361;
            convertidor.setYardas(r);
            b = true;
        }

        //indicar que se realizo la conversion
        if(b){
            Toast.makeText(this, "Conversion realizada.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Debe elegir una opción.", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarResultado(View view){

        //convertir el valor decinal a cadena, aplicando formato
        String valor1 = String.valueOf(formatoDecimales.format(convertidor.getPies()));
        String valor2 = String.valueOf(formatoDecimales.format(convertidor.getPulgadas()));
        String valor3 = String.valueOf(formatoDecimales.format(convertidor.getYardas()));

        if(valor1.equals("0.0") || valor2.equals("0.0") || valor3.equals("0.0")){
            Toast.makeText(this, "Indica la cantidad a convertir", Toast.LENGTH_SHORT).show();
        } else {
            res.setText(convertidor.getMetros() + " equivale a " + convertidor.getPies() + " pies\n"
            + convertidor.getMetros() + " equivale a " + convertidor.getPulgadas() + " pulgadas\n"
            + convertidor.getMetros() + " equivale a " + convertidor.getYardas() + " yardas\n");
        }

        //limpiar caja de texto
        mts.setText("");
        yar.setChecked(false);
        pul.setChecked(false);
        pie.setChecked(false);
    }
}