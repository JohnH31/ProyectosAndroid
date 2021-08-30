package com.example.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MAMeses extends AppCompatActivity {
    private TextView tex,tex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mameses);
        tex = findViewById(R.id.txtTexto);
        tex2 = findViewById(R.id.txtTexto2);
        this.recibirTexto();
    }

    private void recibirTexto() {
        Bundle bundle = getIntent().getExtras();
        int text = bundle.getInt("texto");
        int text2 = bundle.getInt("texto2");
        tex.setText(text);
        tex2.setText(text2);
    }
}