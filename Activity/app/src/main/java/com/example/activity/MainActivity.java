package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText codigo, descripccion, costo;
    private Spinner color;
    private String[] colores = {"Negro", "Azul", "Rojo", "Verde", "Plata", "Negro", "Amarillo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = (EditText) findViewById(R.id.txtCodigo);
        descripccion = (EditText) findViewById(R.id.txtDetalle);
        costo = (EditText) findViewById(R.id.txtCosto);
        color = (Spinner) findViewById(R.id.spColores);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colores);
        color.setAdapter(adapter);
    }

    public void registrarProducto(View view){
        Producto p = new Producto(0,"", "", 0);

        if(codigo.getText().length() == 0){
            Toast.makeText(this,"Falta codigo", Toast.LENGTH_LONG).show();
        }else if(descripccion.getText().length() == 0){
            Toast.makeText(this, "Falta descripcíon", Toast.LENGTH_LONG).show();
        }else if(costo.getText().length() == 0){
            Toast.makeText(this, "Falta costo", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Producto resgistado", Toast.LENGTH_LONG).show();

            p.setCodigo(Integer.parseInt(codigo.getText().toString()));
            p.setDescripcion(descripccion.getText().toString());
            p.setColor(color.getSelectedItem().toString());
            p.setCosto(Float.parseFloat(costo.getText().toString()));

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("Info Producto", p);
            startActivity(intent);
        }
    }
}