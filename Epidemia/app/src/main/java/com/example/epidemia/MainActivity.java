package com.example.epidemia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText cod, nombre;
    private Spinner cas;
    private String[] caso = {"Caso - A", "Caso - B", "Caso - C", "Caso - D", "Caso - E", "Caso - F"};
    private RadioButton nul, baj, med, alt;
    private CheckBox pri, seg, ter, cua;
    private TextView gua;
    private Epidemia[] epidemias;
    private int contador = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epidemias = new Epidemia[10];

        cod = (EditText) findViewById(R.id.Codigo);
        nombre = (EditText) findViewById(R.id.Nombre);
        gua = (TextView) findViewById(R.id.guardador);
        cas = (Spinner) findViewById(R.id.Caso);
        nul = (RadioButton) findViewById(R.id.Ninguno);
        baj = (RadioButton) findViewById(R.id.Bajo);
        med = (RadioButton) findViewById(R.id.Medio);
        alt = (RadioButton) findViewById(R.id.Alto);
        pri = (CheckBox) findViewById(R.id.Primera);
        seg = (CheckBox) findViewById(R.id.Segunda);
        ter = (CheckBox) findViewById(R.id.Tercera);
        cua = (CheckBox) findViewById(R.id.Cuarta);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, caso);
        cas.setAdapter(adapter);
    }

    public void Registar(View view) {

        int c = 0;
        String n = "";
        String za = "";
        boolean d = false;
        boolean b = false;
        boolean afi1 = false;
        boolean afi2 = false;
        String Cas = "";
        String Pri = "";
        String Seg = "";
        String Ter = "";
        String Cua = "";

        if (cod.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo", Toast.LENGTH_LONG).show();
        } else if (nombre.getText().length() == 0) {
            Toast.makeText(this, "Falta descripcíon", Toast.LENGTH_LONG).show();
        } else {
            c = Integer.parseInt(cod.getText().toString());
            n = nombre.getText().toString();
            za = cas.getSelectedItem().toString();

            if(nul.isChecked()){
                Cas = nul.getText().toString();
                b = true;
                afi1 = true;
            } else if (baj.isChecked()){
                Cas = baj.getText().toString();
                b = true;
                afi1 = true;
            } else if (med.isChecked()){
                Cas = med.getText().toString();
                b = true;
                afi1 = true;
            } else if (alt.isChecked()){
                Cas = alt.getText().toString();
                b = true;
                afi1 = true;
            }

            if(pri.isChecked()){
                Pri = pri.getText().toString();
                d = true;
                afi2 = true;
            }
            if (seg.isChecked()){
                Seg = seg.getText().toString();
                d = true;
                afi2 = true;
            }
            if (ter.isChecked()){
                Ter = ter.getText().toString();
                d = true;
                afi2 = true;
            }
            if (cua.isChecked()){
                Cua = cua.getText().toString();
                d = true;
                afi2 = true;
            }

        }
        if(!afi1){
            Toast.makeText(this, "Falta tipo dolor", Toast.LENGTH_LONG).show();
        }else if(!afi2){
            Toast.makeText(this, "Falta vacunnas", Toast.LENGTH_LONG).show();
        }else{
            epidemias[contador] = new Epidemia(c, n, za, Cas, Pri, Seg, Ter, Cua);
            contador++;
            Limpiar(view);
            Toast.makeText(this, "Objeto Registrado", Toast.LENGTH_LONG).show();

        }
    }

    public void Eliminar(View view){
        if (cod.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo", Toast.LENGTH_LONG).show();
        } else if (nombre.getText().length() == 0) {
            Toast.makeText(this, "Falta sitio", Toast.LENGTH_LONG).show();
        } else {
            int idk = Integer.parseInt(cod.getText().toString());
            int va = Integer.parseInt(nombre.getText().toString());
            boolean enco = false;

            if (va == epidemias[idk].getCodigo()) {
                enco = true;
            } else {
            }

            if (!enco) {
                Toast.makeText(this, "Objeto no encontrado", Toast.LENGTH_LONG).show();
            } else if (enco) {
                epidemias[idk].setCodigo(epidemias[idk].getCodigo());
                epidemias[idk].setNombre(epidemias[idk].getNombre());
                epidemias[idk].setCaso("");
                epidemias[idk].setDolor("");
                epidemias[idk].setPrimera("");
                epidemias[idk].setSegunda("");
                epidemias[idk].setTercera("");
                epidemias[idk].setCuarta("");
                Toast.makeText(this, "El objeto fue eliminado", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void Buscar(View view) {

        if (cod.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo", Toast.LENGTH_LONG).show();
        } else if (nombre.getText().length() == 0) {
            Toast.makeText(this, "Falta sitio", Toast.LENGTH_LONG).show();
        } else {
            int idk = Integer.parseInt(cod.getText().toString());
            int va = Integer.parseInt(nombre.getText().toString());
            boolean enco = false;

            if (va == epidemias[idk].getCodigo()) {
                enco = true;
            } else {
            }

            if (!enco) {
                Toast.makeText(this, "Objeto no encontrado", Toast.LENGTH_LONG).show();
            } else if (enco) {
                Epidemia2 p = new Epidemia2("");

                String mostrar = "Datos del producto:\n";
                mostrar += "Codigo:" + epidemias[idk].getCodigo() + "\n";
                mostrar += "Nombre: " + epidemias[idk].getNombre() + "\n";
                mostrar += "Caso: " + epidemias[idk].getCaso() + "\n";
                mostrar += "Dolor: " + epidemias[idk].getDolor() + "\n";
                mostrar += "Vaccuna: " + epidemias[idk].getPrimera() + ", " + epidemias[idk].getSegunda() +
                        ", " + epidemias[idk].getTercera() + ", " + epidemias[idk].getCuarta();

                gua.setText(mostrar);

                p.setDato(gua.getText().toString());
                gua.setText("");

                Intent intent = new Intent(this, Informacion.class);
                intent.putExtra("Info Producto", p);
                startActivity(intent);
                Toast.makeText(this, "Objeto encontrado", Toast.LENGTH_LONG).show();

            }
        }
    }

    public void Limpiar(View view){
        cod.setText("");
        nombre.setText("");
        nul.setChecked(false);
        baj.setChecked(false);
        med.setChecked(false);
        alt.setChecked(false);
        pri.setChecked(false);
        seg.setChecked(false);
        ter.setChecked(false);
        cua.setChecked(false);
        Toast.makeText(this, "Campos limpiados", Toast.LENGTH_LONG).show();

    }
}