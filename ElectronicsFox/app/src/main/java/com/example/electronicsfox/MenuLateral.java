package com.example.electronicsfox;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.electronicsfox.databinding.ActivityMenuLateralBinding;

public class MenuLateral extends AppCompatActivity {

    private static final String CHANNEL_ID = "my_channel";
    private ActivityMenuLateralBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuLateralBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMenuLateral.toolbar);

        createNotificationChannel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.IngreProduc){
            Intent ingresos = new Intent(this, IngreProductos.class);
            startActivity(ingresos);
        } else if (id == R.id.IngreProvee) {
            Intent ver1 = new Intent(this, IngreProveedor.class);
            startActivity(ver1);
        } else if (id == R.id.IngreTarje) {
            Intent ver1 = new Intent(this, IngreTarjeta.class);
            startActivity(ver1);
        } else if (id == R.id.ConsulProduc) {
            Intent ver1 = new Intent(this, VisualProductos.class);
            startActivity(ver1);
        } else if (id == R.id.ConsulProvee) {
            Intent ver1 = new Intent(this, VisualProveedor.class);
            startActivity(ver1);
        } else if (id == R.id.ConsulTarje) {
            Intent ver1 = new Intent(this, VisualTarjeta.class);
            startActivity(ver1);
        } else if (id == R.id.APIMAps) {
            Intent ver1 = new Intent(this, Mapa.class);
            startActivity(ver1);
        } else if (id == R.id.sensor) {
            Intent ver1 = new Intent(this, Sensores.class);
            startActivity(ver1);
        } else if (id == R.id.close) {
            showNotification();
            cerrarSesion();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrarSesion(){
        SharedPreferences preferencias = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        editor.apply();
        Intent logout = new Intent(this, Login.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
        finish();
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_alerta)
                .setContentTitle("¡Sesion cerrada con exito!")
                .setContentText("Tu sesion fue cerrada sin problemas")
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
}