package com.jherrera.myappproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo1;
    private EditText campo2;
    private EditText campo3;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 =findViewById(R.id.txtNombreP);
        campo2 =findViewById(R.id.txtValor);
        campo3 =findViewById(R.id.txtCantidad);
        resultado =findViewById(R.id.txtResultado);
    }

    public void producto(){
        String nombre;
        String valor;
        String cantidad;
        nombre = campo1.getText().toString();
        valor = campo2.getText().toString();
        cantidad = campo3.getText().toString();
        if (!nombre.isEmpty()&&!valor.isEmpty()&&!cantidad.isEmpty()){
            double val;
            double valo;
            double total;
            val = (double) (0.12 * Double.parseDouble(valor));
            valo = Double.parseDouble(valor) + val;
            total = valo * Double.parseDouble(cantidad);
            resultado.setText("Nombre del Producto:"+nombre+"\nValorConIva:"+valo+"\nTotal:"+total);

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.producto();
                break;
        }
    }
}