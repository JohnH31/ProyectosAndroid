package com.jherrera.myapplista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MAVocales extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mavocales);
        img = findViewById(R.id.imgVocal);
        this.recibirImagen();
    }
    private void recibirImagen(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        img.setImageResource(imagen);
    }
}