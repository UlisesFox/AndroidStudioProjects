package com.example.ingresosandgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText usu, con;
    private CheckBox guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu = (EditText) findViewById(R.id.ETNombre);
        con = (EditText) findViewById(R.id.ETContra);
        guardar = (CheckBox) findViewById(R.id.CBGuardar);
    }

    public void ingresarMenu(View view){
        Usuario usr = new Usuario(usu.getText().toString().trim(), con.getText().toString().trim(), true);
        if(guardar.isChecked()){
            guardarPreferencias(usr);
        }
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void guardarPreferencias(Usuario u){
        SharedPreferences preferencias = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario", u.getUsuario());
        editor.putString("contrasena", u.getContra());
        editor.putBoolean("registrado", u.isRegistrado());
        editor.apply();
    }
    public void salirMenu(View view){
        finish();
    }
}