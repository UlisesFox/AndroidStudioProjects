package com.example.electronicsfox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Sensores extends AppCompatActivity {

    private TextView speedTextView;
    private Button startButton;
    private Button stopButton;

    private float currentSpeed = 0.0f;
    private boolean isAlarmActive = false;
    private Handler handler;
    private final int UPDATE_INTERVAL = 1000;
    private final float SPEED_LIMIT = 60.0f;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private Button captureButton;
    private Bitmap fakeCapturedImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        speedTextView = findViewById(R.id.vel);
        startButton = findViewById(R.id.ini);
        stopButton = findViewById(R.id.dete);
        imageView = findViewById(R.id.imageView);
        captureButton = findViewById(R.id.cama);
        fakeCapturedImage = BitmapFactory.decodeResource(getResources(), R.mipmap.zorroazul);

        handler = new Handler();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSpeedSimulation();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSpeedSimulation();
            }
        });

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imageView.setImageBitmap(fakeCapturedImage);
                dispatchTakePictureIntent();
            }
        });
    }
    private void startSpeedSimulation() {
        isAlarmActive = true;
        handler.postDelayed(updateSpeedRunnable, UPDATE_INTERVAL);
    }

    private void stopSpeedSimulation() {
        isAlarmActive = false;
        handler.removeCallbacks(updateSpeedRunnable);
    }

    private Runnable updateSpeedRunnable = new Runnable() {
        @Override
        public void run() {
            currentSpeed += 10.0f;

            speedTextView.setText(String.format("%.2f km/h", currentSpeed));

            if (currentSpeed > SPEED_LIMIT && isAlarmActive) {
                showSpeedAlarm();
            }

            handler.postDelayed(this, UPDATE_INTERVAL);
        }
    };

    private void showSpeedAlarm() {
        Toast.makeText(this, "¡Atención! Se ha superado el límite de velocidad", Toast.LENGTH_LONG).show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void regresar(View view){
        Intent intent = new Intent(this, MenuLateral.class);
        startActivity(intent);
        finish();
    }
}