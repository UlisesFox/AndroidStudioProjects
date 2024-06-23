package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //componentes asosiados
    private EditText mts;
    private RadioButton pie, pul, yar;
    private TextView res;

    //instancia de clase convertior
    private Convertidor convertidor;

    //formato de decimales
    private static DecimalFormat formatoDecimales = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mts = (EditText) findViewById(R.id.metros);
        pie = (RadioButton) findViewById(R.id.pies);
        pul = (RadioButton) findViewById(R.id.pulgadas);
        yar = (RadioButton) findViewById(R.id.yardas);
        res = (TextView) findViewById(R.id.resultado);

        convertidor = new Convertidor();
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
            convertidor.setResultado(r);
            convertidor.setTipo("pies");
            b = true;
        } else if (pul.isChecked()){
            r = m * 39.3701;
            convertidor.setResultado(r);
            convertidor.setTipo("pulgadas");
            b = true;
        } else if (yar.isChecked()){
            r = m * 1.09361;
            convertidor.setResultado(r);
            convertidor.setTipo("yardas");
            b = true;
        }

        //indicar que se realizo la conversion
        if(b){
            Toast.makeText(this, "Conversion realizada.", Toast.LENGTH_LONG).show();else {
                Toast.makeText(this, "Debe elegir una opción.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void mostrarResultado(View view){

        //convertir el valor decinal a cadena, aplicando formato
        String valor = String.valueOf(formatoDecimales.format(convertidor.getResultado()));

        if (valor.isEmpty() || valor.equals("0.00") || mts.getText().toString().isEmpty()){
            Toast.makeText(this, "Indica la cantidad a convertir.", Toast.LENGTH_LONG).show();
        } else {
            //mostrar en el textView
            res.setText(convertidor.getMetros() +" eqivale a "+ valor + convertidor.getTipo());
        }

        //limpiar caja de texto
        mts.setText("");
        yar.setChecked(false);
        pul.setChecked(false);
        pie.setChecked(false);
    }
}