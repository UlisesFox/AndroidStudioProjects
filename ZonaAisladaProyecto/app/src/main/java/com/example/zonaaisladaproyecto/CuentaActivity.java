package com.example.zonaaisladaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CuentaActivity extends AppCompatActivity {
    private EditText pre;
    private TextView po;
    private CostruCuenta[] costrucuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        costrucuenta = new CostruCuenta[1];
        costrucuenta[0] = new CostruCuenta();

        pre = (EditText) findViewById(R.id.txtprecio);
        po = (TextView) findViewById(R.id.txtdinero);

    }

    public void obtenervalor(View view){
        if (pre.getText().length() == 0) {
            Toast.makeText(this, "Falta cantidad a agregar", Toast.LENGTH_SHORT).show();
        } else {
            int pr = Integer.parseInt(pre.getText().toString());
            costrucuenta[0].setAumento(pr);
            actualizar(view);
            pre.setText("");
        }
    }

    public void actualizar(View view){
        int v1 = costrucuenta[0].getAumento();
        int v2 = costrucuenta[0].getAumneto2();
        int valor = v1 + v2;
        costrucuenta[0].setAumneto2(valor);
        po.setText(String.valueOf(valor));
    }
}