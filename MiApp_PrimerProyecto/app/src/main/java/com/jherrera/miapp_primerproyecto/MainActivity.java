package com.jherrera.miapp_primerproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaracion de los objetos que tienen una accion aparte de los botones
    TextView txtContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //establece y encuentra la vista por id para ser utilizada dentro de la clase
        txtContador = findViewById(R.id.txtContador);
    }
    //declaracion de metodos necesarios
    private void mas(){
        contador++;
        txtContador.setText(String.valueOf(contador));
        if (contador == 10){
            Toast.makeText(this, "Felicidades ha realizado 10 pulsos", Toast.LENGTH_SHORT).show();
        }
    }
    private void menos(){
        contador--;
        txtContador.setText(String.valueOf(contador));
    }

    private void reiniciar(){
        contador =0;
        txtContador.setText(String.valueOf(contador));
        Toast.makeText(this, "El Contador se Reinicio a 0", Toast.LENGTH_SHORT).show();
    }


    //definimos los botones que seran utilizados en la actividad
    public void pulsar(View view) {
        if (view.getId() == R.id.btnMas){
            mas();
        }
        if (view.getId() == R.id.btnMenos){
            menos();
        }
        if (view.getId() == R.id.btnReiniciar){
            reiniciar();
        }
    }
}