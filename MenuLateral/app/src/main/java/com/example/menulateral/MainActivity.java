package com.example.menulateral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
    }
    public void ingresarMenu(View view) {
        String urs = mail.getText().toString().trim();
        String con = password.getText().toString().trim();

        if (urs.equals("admin") && con.equals("12345")) {
            Intent intent = new Intent(getApplicationContext(), menu_lateral.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Datos erroneos, intente de nuevo", Toast.LENGTH_SHORT).show();
        }
    }
    public void salirMenu(View view){
        finish();
    }
}