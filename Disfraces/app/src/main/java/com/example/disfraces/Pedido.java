package com.example.disfraces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Pedido extends AppCompatActivity {

    private EditText nom, dom, tel;
    private Spinner pro, tal;
    private String[] producto = {"Traje Zombie", "Traje Vampiro", "Traje Ori", "Traje Esqueleto", "Traje Pirata"};
    private String[] talla = {"Chica", "Mediana", "Grande"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        nom = (EditText) findViewById(R.id.txtNombre);
        dom = (EditText) findViewById(R.id.txtDomic);
        pro = (Spinner) findViewById(R.id.SProducto);
        tal = (Spinner) findViewById(R.id.STalla);
        tel = (EditText) findViewById(R.id.txtTelef);

        ArrayAdapter<String> adapter0 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, producto);
        pro.setAdapter(adapter0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, talla);
        tal.setAdapter(adapter1);
    }
    public void registrarBoton(View view){
        Disfraz disfraz = new Disfraz();
        disfraz.setNombre(nom.getText().toString());
        disfraz.setDomicilio(dom.getText().toString());
        disfraz.setProducto(pro.getSelectedItem().toString());
        disfraz.setTalla(tal.getSelectedItem().toString());
        disfraz.setTelefono(Integer.parseInt(tel.getText().toString()));
        limpiarBoton(view);
        Intent intent = new Intent(this,ActMenu.class);
        intent.putExtra("Disfraz", disfraz);
        startActivity(intent);
        finish();
    }

    public void regresar(View view){
        Intent intent = new Intent(this,ActMenu.class);
        startActivity(intent);
        finish();
    }
    public void limpiarBoton(View view){
        nom.setText("");
        dom.setText("");
        tel.setText("");
    }
}