package com.jherrera.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MADatos extends AppCompatActivity {
    private TextView textoN,textoA,textoE;
    private TextView tex,tex2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos);
        textoN = findViewById(R.id.txtN);
        textoA = findViewById(R.id.txtA);
        textoE = findViewById(R.id.txtE);
        tex = findViewById(R.id.txtNomPin);
        tex2 = findViewById(R.id.txtPagar);
        this.obtener();


    }
    private void obtener(){
        //Se agrega el objeto bundle,
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String nit = bundle.getString("nit");
            String text = bundle.getString("tex");
            String text2 = bundle.getString("tex2");
            double iva = Integer.parseInt(text2) * 0.12;
            double fina = iva + Integer.parseInt(text2);

            tex.setText(text);
            tex2.setText("Total a Pagar con Impuesto:Q. "+fina);
            textoN.setText("Nombre: "+nombre);
            textoA.setText("Apellido: "+apellido);
            textoE.setText("Nit: "+nit);

        }else{
            Toast.makeText(this,"Datos no Encontrar",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}