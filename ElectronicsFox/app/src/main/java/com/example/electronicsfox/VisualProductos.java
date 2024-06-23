package com.example.electronicsfox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualProductos extends AppCompatActivity {

    TextView dat;
    MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_productos);

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        final TextView dat = findViewById(R.id.visualP);

        String URL = "http://192.168.100.120/electronics_fox/VTP.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response){
                        Completada();
                        mediaPlayer.start();
                        try{
                            StringBuilder text = new StringBuilder();

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject registro = response.getJSONObject(i);
                                String code = registro.getString("codeP");
                                String nombre = registro.getString("nombreP");
                                String precio = registro.getString("precioP");
                                String categoria = registro.getString("categoriaP");
                                String descuento = registro.getString("descuentoP");

                                text.append("Codigo: ").append(code).append("\n");
                                text.append("Nombre: ").append(nombre).append("\n");
                                text.append("Precio: ").append(precio).append("\n");
                                text.append("Categoria: ").append(categoria).append("\n");
                                text.append("Descuento: ").append(descuento).append("\n");
                                text.append("\n");
                            }

                            dat.setText(text.toString());

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MenuLateral.class);
        startActivity(intent);
        finish();
    }

    private void Completada() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Exito!")
                .setMessage("¡Datos cargados correctamente!")
                .setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}