package com.example.myapp_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MAImagen extends AppCompatActivity {
    ImageView imga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maimagen);
        imga = findViewById(R.id.imgRes);
        this.dato();
    }
    private void dato(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        this.imga.setImageResource(imagen);
    }

}