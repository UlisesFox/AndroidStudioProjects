package com.example.appactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id, cod, cos, est;
    private TextView res;
    private Motocicleta[] motocicletas;
    private int contador = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        motocicletas = new Motocicleta[10];

        id = (EditText) findViewById(R.id.txtId);
        cod = (EditText) findViewById(R.id.txtCodigo);
        cos = (EditText) findViewById(R.id.txtCosto);
        est = (EditText) findViewById(R.id.txtEstado);
        res = (TextView) findViewById(R.id.txtMostrarHM);
    }

    public void agregar(View view){
        int i = Integer.parseInt(id.getText().toString());
        String a = cod.getText().toString();
        double co = Double.parseDouble(cos.getText().toString());
        boolean e = Boolean.parseBoolean(est.getText().toString());
        motocicletas[contador] = new Motocicleta(i, a, co, e);
        contador++;
        limpiar(view);
    }

    public void buscar(View view){
        int idk = Integer.parseInt(id.getText().toString());
        String mostrar = motocicletas[idk].getCodigo();
        mostrar += "\n";
        mostrar += motocicletas[idk].getCosto() + "\n";
        mostrar += motocicletas[idk].isEstado() + "\n";

        res.setText(mostrar);
    }

    public void limpiar(View view){
        id.setText("");
        cos.setText("");
        cod.setText("");
        est.setText("");
        res.setText("");
    }
}