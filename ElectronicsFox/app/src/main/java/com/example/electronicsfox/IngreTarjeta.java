package com.example.electronicsfox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class IngreTarjeta extends AppCompatActivity {

    EditText nom, con, bin, cvv, cad;
    Spinner ent, tip;
    MediaPlayer mediaPlayer;
    RequestQueue requestQueue;
    private static final String urlservidor = "http://192.168.100.120/electronics_fox/insertarT.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingre_tarjeta);

        requestQueue = Volley.newRequestQueue(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.coin);

        nom = (EditText) findViewById(R.id.nombreT);
        con = (EditText) findViewById(R.id.contraT);
        bin = (EditText) findViewById(R.id.bin);
        ent = (Spinner) findViewById(R.id.entidad);
        tip = (Spinner) findViewById(R.id.tipoT);
        cvv = (EditText) findViewById(R.id.cvv);
        cad = (EditText) findViewById(R.id.caducidad);
    }

    public void guardarP(View view){

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                urlservidor,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mediaPlayer.start();
                        Completada();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(IngreProductos.this, "Error al enviar los datos: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> tarjeta = new HashMap<>();

                tarjeta.put("nombreT", nom.getText().toString());
                tarjeta.put("contraT", con.getText().toString());
                tarjeta.put("bin", bin.getText().toString());
                tarjeta.put("entidad", ent.getSelectedItem().toString());
                tarjeta.put("tipoT", tip.getSelectedItem().toString());
                tarjeta.put("cvv", cvv.getText().toString());
                tarjeta.put("caducidad", cad.getText().toString());

                return tarjeta;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void buscarP(View view) {
        String docbus = nom.getText().toString().trim();
        String URL = "http://192.168.100.120/electronics_fox/buscarT.php?nombreT=" + docbus;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mediaPlayer.start();
                        Completada();

                        String txtnombre, txtcontra, txtbin, txtentidad, txttipo, txtcvv, txtcaducidad;
                        int entero = 0;
                        int entero2 = 0;
                        try {
                            txtnombre = response.getString("nombreT");
                            txtcontra = response.getString("contraT");
                            txtbin = response.getString("bin");
                            txtentidad = response.getString("entidad");
                            txttipo = response.getString("tipoT");
                            txtcvv = response.getString("cvv");
                            txtcaducidad = response.getString("caducidad");

                            con.setText(txtcontra);
                            bin.setText(txtbin);
                            if (txtentidad.equals("Visa")) {
                                entero = 1;
                            } else if (txtentidad.equals("American")) {
                                entero = 2;
                            }
                            ent.setSelection(entero);
                            if (txttipo.equals("Debito")){
                                entero2 = 1;
                            } else {

                            }
                            tip.setSelection(entero2);

                            cvv.setText(txtcvv);
                            cad.setText(txtcaducidad);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        nom.setText("");
                        con.setText("");
                        bin.setText("");
                        ent.setSelection(0);
                        tip.setSelection(0);
                        cvv.setText("");
                        cad.setText("");
                        Toast.makeText(IngreTarjeta.this, "Tarjeta no Existente ", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private void actualizarT() {
        String URL = "http://192.168.100.120/electronics_fox/actualizarT.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mediaPlayer.start();
                        Completada();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> tarjeta = new HashMap<>();
                tarjeta.put("nombreT", nom.getText().toString());
                tarjeta.put("contraT", con.getText().toString());
                tarjeta.put("bin", bin.getText().toString());
                tarjeta.put("entidad", ent.getSelectedItem().toString());
                tarjeta.put("tipoT", tip.getSelectedItem().toString());
                tarjeta.put("cvv", cvv.getText().toString());
                tarjeta.put("caducidad", cad.getText().toString());

                return tarjeta;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void borrarT() {
        String URL = "http://192.168.100.120/electronics_fox/borrarT.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mediaPlayer.start();
                        Completada();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> producto = new HashMap<>();
                producto.put("nombreT", nom.getText().toString());

                return producto;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void limpiar(View view){
        nom.setText("");
        con.setText("");
        bin.setText("");
        ent.setSelection(0);
        tip.setSelection(0);
        cvv.setText("");
        cad.setText("");
        mediaPlayer.start();
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MenuLateral.class);
        startActivity(intent);
        finish();
    }

    public void AlertB(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Advertencia")
                .setMessage("¿Desea borrar el producto seleccionado?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        borrarT();
                    }
                })
                .setNegativeButton("Cancelar", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void AlertA(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Advertencia")
                .setMessage("¿Desea actualizar el producto seleccionado?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actualizarT();
                    }
                })
                .setNegativeButton("Cancelar", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void Completada() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Exito!")
                .setMessage("¡Operacion realizada con exito!")
                .setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}