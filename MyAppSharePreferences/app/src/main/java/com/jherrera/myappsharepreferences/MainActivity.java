package com.jherrera.myappsharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextN, editTextE, editTextA, editTextNi;
    private TextView textViewN, textViewE, textViewA, textViewNi ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextN = findViewById(R.id.edtNombre);
        editTextE = findViewById(R.id.edtEdad);
        editTextA = findViewById(R.id.edtApellido);
        editTextNi = findViewById(R.id.edtNit);

        textViewN = findViewById(R.id.txtNombre);
        textViewE = findViewById(R.id.txtEdad);
        textViewA = findViewById(R.id.txtApellido);
        textViewNi = findViewById(R.id.txtNit);
        this.loadPreferences();

    }


    public void onClick(View view) {
        this.savePreferences();
        editTextN.setText("");
        editTextE.setText("");
        editTextA.setText("");
        editTextNi.setText("");
    }
    //metodo para almacenar los registros como preferencia
    private void savePreferences(){
        if (!editTextN.getText().toString().isEmpty() && !editTextE.getText().toString().isEmpty() && !editTextA.getText().toString().isEmpty() && !editTextNi.getText().toString().isEmpty()){
            String nombre;
            String apellido;
            int edad;
            int nit;

            //instancia del objeto sharepreferences para la creacion del archivo que almacenara las preferencias
            SharedPreferences preferences = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);
            nombre = editTextN.getText().toString();
            apellido = editTextA.getText().toString();
            edad = Integer.parseInt(editTextE.getText().toString());
            nit = Integer.parseInt(editTextNi.getText().toString());
            //se registra los datos obtenidos como preferencias
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre",nombre);
            editor.putString("apellido",apellido);
            editor.putInt("edad", edad);
            editor.putInt("nit", nit);

            textViewN.setText(nombre);
            textViewA.setText(apellido);
            textViewE.setText(String.valueOf(edad));
            textViewNi.setText(String.valueOf(nit));

            editor.commit();

        }else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadPreferences(){
        String nombre;
        String apellido;
        int edad;
        int nit;
        SharedPreferences preferences = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);
        //Se obtienen las preferencias almacenadas en el archivo respectivo
        nombre = preferences.getString("nombre","---");
        apellido = preferences.getString("apellido","---");
        edad = preferences.getInt("edad",0);
        nit = preferences.getInt("nit",0);
        textViewN.setText(nombre);
        textViewA.setText(apellido);
        textViewE.setText(String.valueOf(edad));
        textViewNi.setText(String.valueOf(nit));
    }
}