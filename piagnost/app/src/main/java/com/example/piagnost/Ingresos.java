package com.example.piagnost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Ingresos extends AppCompatActivity {

    private EditText co, no;
    private Spinner obj;
    private String[] objet = {"Casco", "Guantes", "Botas", "Peto", "Grebas", "Espada", "Escudo", "Daga", "Hacha", "Arco", "Ballesta", "Vara Magica"};
    private RadioButton comun, raro, epico, mitico, legen;
    private CheckBox encan, bende, maldi, roto, raliq;
    private ArmasDuras[] armasduras;
    private int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        armasduras = new ArmasDuras[10];

        co = (EditText) findViewById(R.id.cod);
        no = (EditText) findViewById(R.id.name);
        obj = (Spinner) findViewById(R.id.spinner);
        comun = (RadioButton) findViewById(R.id.com);
        raro = (RadioButton) findViewById(R.id.rad);
        epico = (RadioButton) findViewById(R.id.epi);
        mitico = (RadioButton) findViewById(R.id.mit);
        legen = (RadioButton) findViewById(R.id.leg);
        encan = (CheckBox) findViewById(R.id.enca);
        bende = (CheckBox) findViewById(R.id.ben);
        maldi = (CheckBox) findViewById(R.id.mal);
        roto = (CheckBox) findViewById(R.id.dan);
        raliq = (CheckBox) findViewById(R.id.rel);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, objet);
        obj.setAdapter(adapter);

    }

    public void Registrar(View view){

        int c = 0;
        String n = "";
        String za = "";
        boolean d = false;
        boolean b = false;
        boolean afi = false;
        String cali = "";
        String can = "";
        String deci = "";
        String dito = "";
        String otor = "";
        String quia = "";

        if (co.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo", Toast.LENGTH_LONG).show();
        } else if (no.getText().length() == 0) {
            Toast.makeText(this, "Falta nombre", Toast.LENGTH_LONG).show();
        } else {
            c = Integer.parseInt(co.getText().toString());
            n = co.getText().toString();
            za = obj.getSelectedItem().toString();

            if(comun.isChecked()){
                cali = comun.getText().toString();
                b = true;
                afi = true;
            } else if (raro.isChecked()){
                cali = raro.getText().toString();
                b = true;
                afi = true;
            } else if (epico.isChecked()){
                cali = epico.getText().toString();
                b = true;
                afi = true;
            } else if (mitico.isChecked()){
                cali = mitico.getText().toString();
                b = true;
                afi = true;
            } else if (legen.isChecked()) {
                cali = legen.getText().toString();
                b = true;
                afi = true;
            }

            if(encan.isChecked()){
                can = encan.getText().toString();
                d = true;
            }
            if (bende.isChecked()){
                deci = bende.getText().toString();
                d = true;
            }
            if (maldi.isChecked()){
                dito = maldi.getText().toString();
                d = true;
            }
            if (roto.isChecked()){
                otor = roto.getText().toString();
                d = true;
            }
            if (raliq.isChecked()){
                quia = raliq.getText().toString();
                d = true;
            }
        }
        if(!afi){
            Toast.makeText(this, "Falta rareza", Toast.LENGTH_LONG).show();
        }else{
            armasduras[contador] = new ArmasDuras(c, n, za, cali, can, deci, dito, otor, quia);
            contador++;
            Limpiar(view);
            Toast.makeText(this, "Objeto Registrado", Toast.LENGTH_LONG).show();

        }
    }

    public void  Limpiar(View view){
        co.setText("");
        no.setText("");
        comun.setChecked(false);
        raro.setChecked(false);
        epico.setChecked(false);
        mitico.setChecked(false);
        legen.setChecked(false);
        encan.setChecked(false);
        bende.setChecked(false);
        maldi.setChecked(false);
        roto.setChecked(false);
        raliq.setChecked(false);
        Toast.makeText(this, "Campos limpiados", Toast.LENGTH_LONG).show();

    }

    public void Regresar (View view){
        Intent intent = new Intent(this,Menulateral.class);
        startActivity(intent);
        finish();
    }
}