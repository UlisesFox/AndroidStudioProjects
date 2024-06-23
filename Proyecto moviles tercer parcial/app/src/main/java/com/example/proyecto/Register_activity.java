package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register_activity extends AppCompatActivity {
    private EditText nombre, apellido, correo, contrasena, confirmarContra;
    Usuario user[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.editxtName);
        apellido = findViewById(R.id.editxtLastName);
        correo = findViewById(R.id.editxtEmail);
        contrasena = findViewById(R.id.editxtPassword);
        confirmarContra = findViewById(R.id.etConfirmPassword);
        user = (Usuario[]) getIntent().getSerializableExtra("usuarios");
    }

    public void registrarse(View view) {
        String name = nombre.getText().toString();
        String lastName = apellido.getText().toString();
        String email = correo.getText().toString();
        String password = contrasena.getText().toString();
        String confirm = confirmarContra.getText().toString();

        if (password.equals(confirm)) {
            for (int i = 0; i < 15; i++) {
                if (user[i].getNombre().equals("")) {
                    user[i].setNombre(name);
                    user[i].setApellido(lastName);
                    user[i].setEmail(email);
                    user[i].setContrasena(password);

                    Intent intent = new Intent(Register_activity.this, MainActivity.class);
                    intent.putExtra("usuarios", user);
                    startActivity(intent);
                    break;
                }
            }
        } else {
            Toast mensaje = Toast.makeText(this, "Las contraseña no coinciden", Toast.LENGTH_LONG);
            mensaje.show();
        }
    }
    public void close( View view){
        Intent intent = new Intent(Register_activity.this, MainActivity.class);
        intent.putExtra("usuarios", user);
        startActivity(intent);
    }
}