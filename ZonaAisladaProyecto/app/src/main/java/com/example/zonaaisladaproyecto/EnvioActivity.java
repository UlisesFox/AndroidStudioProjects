package com.example.zonaaisladaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EnvioActivity extends AppCompatActivity {

    private EditText ca, co, ci, pos;
    private Spinner or;
    private String[] orden = {"Orden 1","Orden 2","Orden 3","Orden 4","Orden 5","Orden 6","Orden 7"};
    private CostruEnvio[] costruenvios;
    private int conta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

            costruenvios = new CostruEnvio[20];

            ca = (EditText) findViewById(R.id.txtcalle);
            co = (EditText) findViewById(R.id.txtcolonia);
            ci = (EditText) findViewById(R.id.txtciudad);
            pos = (EditText) findViewById(R.id.txtpostal);
            or = (Spinner) findViewById(R.id.sporden);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, orden);
            or.setAdapter(adapter);
    }

    public void enviar(View view){

        String ord = "";
        String cal = "";
        String col = "";
        String ciu = "";
        int post = 0;

        if (ca.getText().length() == 0) {
            Toast.makeText(this, "Falta calle", Toast.LENGTH_LONG).show();
        } else if (co.getText().length() == 0) {
            Toast.makeText(this, "Falta colonia", Toast.LENGTH_LONG).show();
        } else if (ci.getText().length() == 0) {
            Toast.makeText(this, "Falta ciudad", Toast.LENGTH_LONG).show();
        } else if (pos.getText().length() == 0) {
            Toast.makeText(this, "Falta codigo postal", Toast.LENGTH_LONG).show();
        } else {
            ord = or.getSelectedItem().toString();
            cal = ca.getText().toString();
            col = co.getText().toString();
            ciu = ci.getText().toString();
            post = Integer.parseInt(pos.getText().toString());
        }
        costruenvios[conta] = new CostruEnvio(ord, cal, col, ciu, post);
        conta++;
        Mostrar(view);
        Limpiar(view);
    }

    public void Mostrar(View view){
        String orden = or.getSelectedItem().toString();
        String calle = ca.getText().toString();
        String colonia = co.getText().toString();
        String ciudad = ci.getText().toString();
        int codeposta = Integer.parseInt(pos.getText().toString());

        // Construir el mensaje para el Toast
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Envio Registrado").append("\n");
        mensaje.append("Orden: ").append(orden).append("\n");
        mensaje.append("Calle: ").append(calle).append("\n");
        mensaje.append("Colonia: ").append(colonia).append("\n");
        mensaje.append("Ciudad: ").append(ciudad).append("\n");
        mensaje.append("Codigo postal: ").append(codeposta);

        Toast.makeText(this, mensaje.toString(), Toast.LENGTH_SHORT).show();
    }

    public void Limpiar(View view){
        ca.setText("");
        co.setText("");
        ci.setText("");
        pos.setText("");
    }
}