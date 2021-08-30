package com.jherrera.myapptraasladodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MAReceptor extends AppCompatActivity {
    private TextView textoN,textoA,textoE,textoD,textoT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mareceptor);
        textoN = findViewById(R.id.txtN);
        textoA = findViewById(R.id.txtA);
        textoE = findViewById(R.id.txtE);
        textoD = findViewById(R.id.txtD);
        textoT = findViewById(R.id.txtT);
        this.obtener();
    }

    private void obtener(){
        //Se agrega el objeto bundle,
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String edad = bundle.getString("edad");
            String dire = bundle.getString("dire");
            String tel = bundle.getString("tel");

            textoN.setText("Nombre: "+nombre);
            textoA.setText("Apellido: "+apellido);
            textoE.setText("Edad: "+edad);
            textoD.setText("Direccion: "+dire);
            textoT.setText("Telefono: "+tel);

        }else{
            Toast.makeText(this,"Datos no Encontrar",Toast.LENGTH_SHORT).show();
        }
    }
}