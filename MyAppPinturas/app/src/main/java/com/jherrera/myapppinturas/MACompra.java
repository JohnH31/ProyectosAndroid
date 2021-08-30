package com.jherrera.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MACompra extends AppCompatActivity {
    private ImageView img;
    private TextView tex,tex2;
    private EditText campoN,campoA,campoNi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macompra);
        img = findViewById(R.id.imgPin);
        tex = findViewById(R.id.txtDat);
        tex2 = findViewById(R.id.txtPrecio);
        campoN = findViewById(R.id.txtNombre);
        campoA = findViewById(R.id.txtApellido);
        campoNi = findViewById(R.id.txtNit);
        this.recibirDa();

    }
    private void recibirDa(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        int text2 = bundle.getInt("textoP");
        String text = bundle.getString("textoD");
        img.setImageResource(imagen);
        tex2.setText(String.valueOf(text2));
        tex.setText("Nombre Pintura: "+text);

    }

    private void datos(){
        String nombre = campoN.getText().toString();
        String apellido = campoA.getText().toString();
        String nit = campoNi.getText().toString();
        String texx = tex.getText().toString();
        String texx2 = tex2.getText().toString();
        if (!nombre.isEmpty()&&!apellido.isEmpty()&&!nit.isEmpty()){
            Intent intent = new Intent(this,MADatos.class);
            intent.putExtra("nom",nombre);
            intent.putExtra("ape",apellido);
            intent.putExtra("nit",nit);
            intent.putExtra("tex",texx);
            intent.putExtra("tex2",texx2);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this,"Datos no ingresados",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnComprar:
                this.datos();
                break;
            case R.id.btnCancelar:
                finish();
                break;
        }

    }
}