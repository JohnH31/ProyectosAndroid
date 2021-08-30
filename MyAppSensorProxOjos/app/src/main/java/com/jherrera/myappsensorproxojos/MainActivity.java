package com.jherrera.myappsensorproxojos;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Sensor sensorProx;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgCargar);
        //Definir la activacion, uso y tipo de sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorProx = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorProximidad();
        iniciarSensor();
    }

    private void sensorProximidad() {
        if (sensorProx == null) {
            Toast.makeText(this, "No cuenta con el sensor", Toast.LENGTH_SHORT).show();
            finish();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                if (sensorEvent.values[0] < sensorProx.getMaximumRange()) {
                    imageView.setImageResource(R.drawable.ojosabiertos);
                    //getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else {
                    imageView.setImageResource(R.drawable.ojoscerrados);
                    //getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
    //metodos para iniciar y detener el sensor
    private void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener, sensorProx, 2000*1000);
    }
    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    //Metodo de activacion

    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}