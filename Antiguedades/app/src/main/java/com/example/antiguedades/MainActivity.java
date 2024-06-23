package com.example.antiguedades;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mail, password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText) findViewById(R.id.txtcorre);
        password = (EditText) findViewById(R.id.txtcontr);
    }

    public void ingresarMenu(View view) {
        String usr = mail.getText().toString().trim();
        String con = password.getText().toString().trim();
        if (usr.equals("ulises") && con.equals("12345")) {
            Intent intent = new
                    Intent(getApplicationContext(), MenuLateral.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Datos incorrectos, intente de nuevo.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void salirMenu(View view){
        finish();
    }
}