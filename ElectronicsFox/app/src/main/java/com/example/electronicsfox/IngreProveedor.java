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

public class IngreProveedor extends AppCompatActivity {

    EditText cod, nom, cos, corre;
    Spinner cat;
    RadioButton entre, pendi;
    MediaPlayer mediaPlayer;

    private static String txtcuento="";
    RequestQueue requestQueue;
    private static final String urlservidor = "http://192.168.100.120/electronics_fox/insertar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingre_proveedor);

        requestQueue = Volley.newRequestQueue(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.coin);

        cod = (EditText) findViewById(R.id.code);
        nom = (EditText) findViewById(R.id.nombre);
        cos = (EditText) findViewById(R.id.costo);
        corre = (EditText) findViewById(R.id.correo);
        cat = (Spinner) findViewById(R.id.categoria);
        entre = (RadioButton) findViewById(R.id.completada);
        pendi = (RadioButton) findViewById(R.id.pendiente);

    }

    public void guardarP(View view){
        if(entre.isChecked()){
            txtcuento="Completada";
        } else {
            txtcuento="Pendiente";
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
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> proveedor = new HashMap<>();

                proveedor.put("code", cod.getText().toString());
                proveedor.put("nombre", nom.getText().toString());
                proveedor.put("costo", cos.getText().toString());
                proveedor.put("correo", corre.getText().toString());
                proveedor.put("categoria", cat.getSelectedItem().toString());
                proveedor.put("entrega", txtcuento);

                return proveedor;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void buscarP(View view) {
        String docbus = cod.getText().toString().trim();
        String URL = "http://192.168.100.120/electronics_fox/buscar.php?code=" + docbus;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mediaPlayer.start();
                        Completada();

                        String txtcode, txtnombre, txtprecio, txtcate, txtdescuento, txtcorreo;
                        int entero = 0;
                        try {
                            txtcode = response.getString("code");
                            txtnombre = response.getString("nombre");
                            txtprecio = response.getString("costo");
                            txtcorreo = response.getString("correo");
                            txtcate = response.getString("categoria");
                            txtdescuento = response.getString("entrega");

                            nom.setText(txtnombre);
                            cos.setText(txtprecio);
                            corre.setText(txtcorreo);
                            if (txtcate.equals("Hardwares")) {
                                entero = 1;
                            } else if (txtcate.equals("Dispositivos")) {
                                entero = 2;
                            } else if (txtcate.equals("Componentes")) {
                                entero = 3;
                            }
                            cat.setSelection(entero);

                            if (txtdescuento.equals("Completada")) {
                                entre.setChecked(true);
                            } else {
                                pendi.setChecked(true);
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
                        cos.setText("");
                        corre.setText("");
                        cat.setSelection(0);
                        pendi.setChecked(true);
                        Toast.makeText(IngreProveedor.this, "Proveedor no Existente ", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private void actualizarPro() {
        if(entre.isChecked()){
            txtcuento="Completada";
        } else {
            txtcuento="Pendiente";
        }
        String URL = "http://192.168.100.120/electronics_fox/actualizar.php";
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
                Map<String, String> proveedor = new HashMap<>();
                proveedor.put("code", cod.getText().toString());
                proveedor.put("nombre", nom.getText().toString());
                proveedor.put("costo", cos.getText().toString());
                proveedor.put("correo", corre.getText().toString());
                proveedor.put("categoria", cat.getSelectedItem().toString());
                proveedor.put("entrega", txtcuento);

                return proveedor;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void borrarPro() {
        String URL = "http://192.168.100.120/electronics_fox/borrar.php";
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
                Map<String, String> proveedor = new HashMap<>();
                proveedor.put("code", cod.getText().toString());

                return proveedor;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void limpiar(View view){
        cod.setText("");
        nom.setText("");
        cos.setText("");
        corre.setText("");
        cat.setSelection(0);
        pendi.setChecked(true);
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
                        borrarPro();
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
                        actualizarPro();
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