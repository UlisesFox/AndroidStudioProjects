package com.example.electronicsfox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class IngreProductos extends AppCompatActivity {

    private static final String CHANNEL_ID = "my_channel";
    EditText cod, nom, pre;
    Spinner cad;
    RadioButton de75, de50, de25, de0;
    MediaPlayer mediaPlayer;

    private static String txtcuento="";
    RequestQueue requestQueue;
    private static final String urlservidor = "http://192.168.100.120/electronics_fox/insertarP.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingre_productos);

        requestQueue = Volley.newRequestQueue(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.coin);

        cod = (EditText) findViewById(R.id.codeP);
        nom = (EditText) findViewById(R.id.nombreP);
        pre = (EditText) findViewById(R.id.precioP);
        cad = (Spinner) findViewById(R.id.categoriaP);
        de75 = (RadioButton) findViewById(R.id.des75);
        de50 = (RadioButton) findViewById(R.id.des50);
        de25 = (RadioButton) findViewById(R.id.des25);
        de0 = (RadioButton) findViewById(R.id.des0);

    }

    public void guardarP(View view){
        if(de75.isChecked()){
            txtcuento="75%";
        } else if (de50.isChecked()) {
            txtcuento="50%";
        } else if (de25.isChecked()) {
            txtcuento="25%";
        } else {
            txtcuento="none";
        }

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
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> producto = new HashMap<>();

                producto.put("codeP", cod.getText().toString());
                producto.put("nombreP", nom.getText().toString());
                producto.put("precioP", pre.getText().toString());
                producto.put("categoriaP", cad.getSelectedItem().toString());
                producto.put("descuentoP", txtcuento);

                return producto;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void buscarP(View view) {
        String docbus = cod.getText().toString().trim();
        String URL = "http://192.168.100.120/electronics_fox/buscarP.php?codeP=" + docbus;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mediaPlayer.start();
                        Completada();

                        String txtcode, txtnombre, txtprecio, txtcate, txtdescuento;
                        int entero = 0;
                        try {
                            txtcode = response.getString("codeP");
                            txtnombre = response.getString("nombreP");
                            txtprecio = response.getString("precioP");
                            txtcate = response.getString("categoriaP");
                            txtdescuento = response.getString("descuentoP");

                            nom.setText(txtnombre);
                            pre.setText(txtprecio);
                            if (txtcate.equals("Componentes")) {
                                entero = 1;
                            } else if (txtcate.equals("Torres")) {
                                entero = 2;
                            } else if (txtcate.equals("Monitores")) {
                                entero = 3;
                            } else if (txtcate.equals("Softwares")) {
                                entero = 4;
                            } else if (txtcate.equals("Hardwares")) {
                                entero = 5;
                            } else if (txtcate.equals("Telefonos")) {
                                entero = 6;
                            }
                            cad.setSelection(entero);

                            if (txtdescuento.equals("75%")) {
                                de75.setChecked(true);
                            } else if (txtdescuento.equals("50%")) {
                                de50.setChecked(true);
                            } else if (txtdescuento.equals("25%")) {
                                de25.setChecked(true);
                            } else {
                                de0.setChecked(true);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        cod.setText("");
                        nom.setText("");
                        pre.setText("");
                        cad.setSelection(0);
                        de0.setChecked(true);
                        Toast.makeText(IngreProductos.this, "Cliente no Existente ", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private void actualizarP() {
        if(de75.isChecked()){
            txtcuento="75%";
        } else if (de50.isChecked()) {
            txtcuento="50%";
        } else if (de25.isChecked()) {
            txtcuento="25%";
        } else {
            txtcuento="none";
        }
        String URL = "http://192.168.100.120/electronics_fox/actualizarP.php";
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
                producto.put("codeP", cod.getText().toString());
                producto.put("nombreP", nom.getText().toString());
                producto.put("precioP", pre.getText().toString());
                producto.put("categoriaP", cad.getSelectedItem().toString());
                producto.put("descuentoP", txtcuento);

                return producto;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void borrarP() {
        String URL = "http://192.168.100.120/electronics_fox/borrarP.php";
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
                producto.put("codeP", cod.getText().toString());

                return producto;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void limpiar(View view){
        cod.setText("");
        nom.setText("");
        pre.setText("");
        cad.setSelection(0);
        de0.setChecked(true);
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
                    borrarP();
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
                        actualizarP();
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