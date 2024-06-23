package com.example.ingresosandgastos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ingresosandgastos.databinding.ActivityMenuLateraBinding;

public class MenuLatera extends AppCompatActivity {
    private ActivityMenuLateraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuLateraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMenuLatera.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_latera, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.ingre){
            Intent ingresos = new Intent(this,Ingresos.class);
            startActivity(ingresos);
        } else if (id == R.id.veringre) {
            Intent ver1 = new Intent(this,DatosI.class);
            startActivity(ver1);
        } else if (id == R.id.gasto) {
            Intent gasto = new Intent(this,Gastos.class);
            startActivity(gasto);
        } else if (id == R.id.vertos) {
            Intent ver2 = new Intent(this,DatosG.class);
            startActivity(ver2);
        } else if (id == R.id.exit) {
            cerrarSesion();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrarSesion(){
        SharedPreferences preferencias = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        editor.apply();
        Intent logout = new Intent(this,Login.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
        finish();
    }
}