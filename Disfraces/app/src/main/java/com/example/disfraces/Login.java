package com.example.disfraces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText mail, password;
    private CheckBox guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = (EditText) findViewById(R.id.txtCorreo);
        password = (EditText) findViewById(R.id.txtContra);
        guardar = (CheckBox) findViewById(R.id.CBguardar);
    }
    public void ingresarMenu(View view){
        Usuario usr = new Usuario(mail.getText().toString().trim(), password.getText().toString().trim(), true);
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
        editor.putString("usuario", u.getCorreo());
        editor.putString("contrasena", u.getContrasena());
        editor.putBoolean("registrado", u.isRegistrado());
        editor.apply();
    }
    public void salirMenu(View view){
        finish();
    }
}