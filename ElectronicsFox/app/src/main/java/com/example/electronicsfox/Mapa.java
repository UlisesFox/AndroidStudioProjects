package com.example.electronicsfox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText lon, lat;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        lon = (EditText) findViewById(R.id.txtLongitud);
        lat = (EditText) findViewById(R.id.txtLatitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng Guadalajara = new LatLng(20.7081175,-103.3967875);
        mMap.addMarker(new MarkerOptions().position(Guadalajara).title("Electronics_Fox"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Guadalajara));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        lat.setText(""+latLng.latitude);
        lon.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        lat.setText(""+latLng.latitude);
        lon.setText(""+latLng.longitude);
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MenuLateral.class);
        startActivity(intent);
        finish();
    }
}