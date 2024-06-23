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

public class VisualTarjeta extends AppCompatActivity {

    TextView dat;
    MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_tarjeta);

        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
        final TextView dat = findViewById(R.id.visualP);

        String URL = "http://192.168.100.120/electronics_fox/VTT.php";
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
                                String nombreT = registro.getString("nombreT");
                                String contraT = registro.getString("contraT");
                                String bin = registro.getString("bin");
                                String entidad = registro.getString("entidad");
                                String tipoT = registro.getString("tipoT");
                                String cvv = registro.getString("cvv");
                                String caducidad = registro.getString("caducidad");

                                text.append("Nombre de propietario: ").append(nombreT).append("\n");
                                text.append("Contraseña: ").append(contraT).append("\n");
                                text.append("BIN: ").append(bin).append("\n");
                                text.append("Entidad: ").append(entidad).append("\n");
                                text.append("Tipo de tarjeta: ").append(tipoT).append("\n");
                                text.append("CVV: ").append(cvv).append("\n");
                                text.append("Caducidad: ").append(caducidad).append("\n");
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