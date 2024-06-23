package com.example.parcial1reyesedgar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fo, ma, mo;
    private RadioButton auto, manu, doce, vei, cua;
    private TextView res;
    private Cotización[] cotizacións;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cotizacións = new Cotización[20];

        fo = (EditText) findViewById(R.id.folio);
        ma = (EditText) findViewById(R.id.marca);
        mo = (EditText) findViewById(R.id.modelo);
        auto = (RadioButton) findViewById(R.id.automatica);
        manu = (RadioButton) findViewById(R.id.manual);
        doce = (RadioButton) findViewById(R.id.mes12);
        vei = (RadioButton) findViewById(R.id.mes24);
        cua = (RadioButton) findViewById(R.id.mes48);
        res = (TextView) findViewById(R.id.TextEdit);

    }

    public void registrar(View view) {
        boolean b = false;
        int c = Integer.parseInt(fo.getText().toString());
        String m = ma.getText().toString();
        String mod = mo.getText().toString();
        int ti = 0;
        int ce = 0;

        if (auto.isChecked()) {
            ti = 250000;
            b = true;
        } else if (manu.isChecked()) {
            ti = 300000;
            b = true;
        }

        int en = 0;
        en = (30 * ti)/100;

        if (doce.isChecked()) {
            ce = 12;
            b = true;
        } else if (vei.isChecked()) {
            ce = 24;
            b = true;
        } else if (cua.isChecked()) {
            ce = 48;
            b = true;
        }

        int ces = 0;
        ces = (70 * ti)/100;
        int cess = 0;
        cess = ces/ce;
        int fa = 0;
        fa = (2 * ti)/100;

        cotizacións[contador] = new Cotización(c, m, mod, ti, en, cess, fa);
        contador++;
    }

    public void cotizar(View view){
            int idk = Integer.parseInt(fo.getText().toString());
            if(cotizacións[idk] != fo.getText()) {
            String mostrar = "Marca: " + cotizacións[idk].getMarca();
            mostrar += "\n";
            mostrar += "Modelo: " + cotizacións[idk].getModelo() + "\n";
            mostrar += "Trasmicion: " + cotizacións[idk].getTrasmision() + "\n";
            mostrar += "Enganche: " + cotizacións[idk].getEnganche() + "\n";
            mostrar += "Mensualidad: " + cotizacións[idk].getMensualidad() + "\n";
            mostrar += "Comision: " + cotizacións[idk].getComisión() + "\n";

            res.setText(mostrar);
        } else {
                Toast.makeText(this, "No existe ese arreglo", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(View view){
        fo.setText("");
        ma.setText("");
        mo.setText("");
        auto.setChecked(false);
        manu.setChecked(false);
        doce.setChecked(false);
        vei.setChecked(false);
        cua.setChecked(false);
    }
}