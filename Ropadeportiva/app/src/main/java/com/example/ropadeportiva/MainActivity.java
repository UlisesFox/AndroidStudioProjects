package com.example.ropadeportiva;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText cod, mar, mod, cos;
    private CheckBox Ne, Bla, Az, Ro, Na;
    private RadioButton chi, med, gra;
    private TextView res;
    private RopaDeportiva[] ropadeportivas;
    private int contador = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ropadeportivas = new RopaDeportiva[15];

        cod = (EditText) findViewById(R.id.codigo);
        mar = (EditText) findViewById(R.id.marca);
        mod = (EditText) findViewById(R.id.modelo);
        cos = (EditText) findViewById(R.id.costo);
        Ne = (CheckBox) findViewById(R.id.negro);
        Bla = (CheckBox) findViewById(R.id.blanco);
        Az = (CheckBox) findViewById(R.id.azul);
        Ro = (CheckBox) findViewById(R.id.rojo);
        Na = (CheckBox) findViewById(R.id.naranja);
        chi = (RadioButton) findViewById(R.id.chica);
        med = (RadioButton) findViewById(R.id.mediana);
        gra = (RadioButton) findViewById(R.id.grande);
        res = (TextView) findViewById(R.id.EditText);
    }

    public void agregarET(View view){
        boolean d = false;
        boolean b = false;
        int c = Integer.parseInt(cod.getText().toString());
        String m = mar.getText().toString();
        String mo = mod.getText().toString();
        int co = Integer.parseInt(cos.getText().toString());
        String ta = "";
        String ne = "";
        String bla = "";
        String ro = "";
        String az = "";
        String na = "";

        if(chi.isChecked()){
            ta = chi.getText().toString();
            b = true;
        } else if (med.isChecked()){
            ta = med.getText().toString();
            b = true;
        } else if (gra.isChecked()){
            ta = gra.getText().toString();
            b = true;
        }

        if(Ne.isChecked()){
            ne = Ne.getText().toString();
            d = true;
        }
        if (Bla.isChecked()){
            bla = Bla.getText().toString();
            d = true;
        }
        if (Az.isChecked()){
            ro = Az.getText().toString();
            d = true;
        }
        if (Ro.isChecked()){
            az = Ro.getText().toString();
            d = true;
        }
        if (Na.isChecked()){
            na = Na.getText().toString();
            d = true;
        }
        if(b){
            Toast.makeText(this, "Conversion realizada.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Debe elegir una opción.", Toast.LENGTH_SHORT).show();
        }
        ropadeportivas[contador] = new RopaDeportiva(c, m, mo, co, ta, ne, bla, az, ro, na);
        contador++;
        limpiar(view);
    }

    public void buscar(View view){
        int idk = Integer.parseInt(cod.getText().toString());
        String mostrar = "Codgo: " + ropadeportivas[idk].getCódigo();
        mostrar += "\n";
        mostrar += "Marca: " + ropadeportivas[idk].getMarca() + "\n";
        mostrar += "Modelo: " + ropadeportivas[idk].getModelo() + "\n";
        mostrar += "Talla: " + ropadeportivas[idk].getTalla() + "\n";
        mostrar += "Color: E" + ropadeportivas[idk].getNegro() + ", " + ropadeportivas[idk].getBlanco() + ", "
                + ropadeportivas[idk].getAzul() + ", " + ropadeportivas[idk].getRojo() + ", "
                + ropadeportivas[idk].getNaranja() + "\n";
        mostrar += "$" + ropadeportivas[idk].getCosto() + "\n";

        res.setText(mostrar);
    }

    public void eliminar(View view){
        int idk = Integer.parseInt(cod.getText().toString());
        ropadeportivas[idk].setMarca("");
        ropadeportivas[idk].setModelo("");
        ropadeportivas[idk].setTalla("");
        ropadeportivas[idk].setNegro("");
        ropadeportivas[idk].setBlanco("");
        ropadeportivas[idk].setAzul("");
        ropadeportivas[idk].setRojo("");
        ropadeportivas[idk].setNaranja("");
        ropadeportivas[idk].setCosto(0);

    }

    public void limpiar(View view){
        cod.setText("");
        mar.setText("");
        mod.setText("");
        cos.setText("");
        chi.setChecked(false);
        med.setChecked(false);
        gra.setChecked(false);
        Ne.setChecked(false);
        Bla.setChecked(false);
        Az.setChecked(false);
        Ro.setChecked(false);
        Na.setChecked(false);
        res.setText("");
    }
}