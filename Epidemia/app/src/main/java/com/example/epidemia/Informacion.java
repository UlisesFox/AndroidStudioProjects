package com.example.epidemia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    public TextView tex;
    Epidemia2 epidemia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        tex = (TextView) findViewById(R.id.EditText);
        epidemia2 = (Epidemia2) getIntent().getSerializableExtra("Info Producto");

        tex.setText(epidemia2.getDato());
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}