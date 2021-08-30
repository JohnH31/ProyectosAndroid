package com.jherrera.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappswlocal.complementos.MetodosSW;

import org.json.JSONObject;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editTextNombre,editTextApellido,editTextTelefono,editTextDireccion;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);
        editTextNombre = findViewById(R.id.edtNombreCliente);
        editTextApellido = findViewById(R.id.edtApellidoCliente);
        editTextTelefono = findViewById(R.id.edtTelefonoCliente);
        editTextDireccion = findViewById(R.id.edtDireccionCliente);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertarCliente:
                this.insertar();
                break;
        }

    }
    private void insertar(){
        if (!editTextNombre.getText().toString().isEmpty()&&!editTextApellido.getText().toString().isEmpty()&&
                !editTextTelefono.getText().toString().isEmpty()&&!editTextDireccion.getText().toString().isEmpty()){

            metodosSW.insertarSW(this,editTextNombre.getText().toString(),editTextApellido.getText().toString(),
                    Integer.parseInt(editTextTelefono.getText().toString()),editTextDireccion.getText().toString(),
                    this,this);

            editTextNombre.setText("");
            editTextApellido.setText("");
            editTextTelefono.setText("");
            editTextDireccion.setText("");
        }else {
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente"+error, Toast.LENGTH_SHORT).show();
        System.err.println("I....."+error);
    }
}
