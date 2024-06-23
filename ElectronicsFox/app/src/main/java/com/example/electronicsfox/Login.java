package com.example.electronicsfox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private static final String CHANNEL_ID = "my_channel";
    private EditText usu, con;
    private CheckBox guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        usu = (EditText) findViewById(R.id.ETNombre);
        con = (EditText) findViewById(R.id.ETContra);
        guardar = (CheckBox) findViewById(R.id.CBGuardar);

        createNotificationChannel();
    }

    public void ingresarMenu(View view){
        showNotification();
        Usuario usr = new Usuario(usu.getText().toString().trim(), con.getText().toString().trim(), true);
        if(guardar.isChecked()){
            guardarPreferencias(usr);
        }
        Intent intent = new Intent(Login.this, MenuLateral.class);
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

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_alerta)
                .setContentTitle("¡Alerta inicio de sesion detectado!")
                .setContentText("Si eres tu pude ignorar el mensaje")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Log";
            String description = "Logeo detectado";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void salirMenu(View view){
        finish();
    }
}