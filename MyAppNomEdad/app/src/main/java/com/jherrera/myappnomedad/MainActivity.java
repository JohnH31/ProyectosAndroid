package com.jherrera.myappnomedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campo1;
    private TextView resultNombre;
    private EditText campo2;
    private TextView resultEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //establece y encuentra la vista por id para ser utilizada dentro de la clase
        campo1 = findViewById(R.id.txtNombre);
        campo2 = findViewById(R.id.txtEdad);
        resultNombre = findViewById(R.id.txtResulNombre);
        resultEdad = findViewById(R.id.txtResulEdad);
    }
    public void mostrarDatos(){
        String campoNombre;
        String campoEdad;
        campoNombre = campo1.getText().toString();
        campoEdad = campo2.getText().toString();
        if (!campoNombre.isEmpty()&&!campoEdad.isEmpty()){
            int ano;
            ano = 2021 - Integer.parseInt(campoEdad);
            resultNombre.setText("Su nombre es: "+campoNombre);
            resultEdad.setText("Su año de nacimiento es: "+ano);

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.mostrarDatos();
                break;
        }
    }
}