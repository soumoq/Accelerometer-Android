package com.example.accelerometerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.hardware.*;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        init();


        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                xText.setText("X: " + event.values[0]);
                yText.setText("Y: " + event.values[1]);
                zText.setText("Z: " + event.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    private void init() {
        xText = findViewById(R.id.x_main);
        yText = findViewById(R.id.y_main);
        zText = findViewById(R.id.z_main);
    }
}