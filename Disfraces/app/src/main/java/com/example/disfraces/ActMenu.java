package com.example.disfraces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActMenu extends AppCompatActivity {
    private Disfraz disfraz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        disfraz = (Disfraz) getIntent().getSerializableExtra("Disfraz");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.Pedido:
                Intent registro = new Intent(this,Pedido.class);
                startActivity(registro);
                break;
            case R.id.Productos:
                Intent consultar = new Intent(this,Producto.class);
                startActivity(consultar);
                break;
            case R.id.Compras:
                Intent web = new Intent(this,Compras.class);
                web.putExtra("Disfraz", disfraz);
                startActivity(web);
                break;
            case R.id.Cerrar:
                cerrarSesion();
                break;
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