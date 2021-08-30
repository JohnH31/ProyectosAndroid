package com.jherrera.myapp_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //establece y encuentra la vista por id para ser utilizada dentro de la clase
        campo = findViewById(R.id.txtNombre);
        resultado = findViewById(R.id.txtResultado);
    }
    public void mostrarNombre(){
        String campoNombre;
        campoNombre = campo.getText().toString();
        if (!campoNombre.isEmpty())

            resultado.setText("Su nombre es: "+campoNombre);
        else
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();


    }


    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
            this.mostrarNombre();
            break;
        }
    }
}