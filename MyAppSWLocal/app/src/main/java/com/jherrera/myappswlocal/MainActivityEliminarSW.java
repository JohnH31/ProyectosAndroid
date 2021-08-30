package com.jherrera.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jherrera.myappswlocal.complementos.ClienteVO;
import com.jherrera.myappswlocal.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityEliminarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editText;
    TextView textViewNombre,textViewApellido,textViewTelefono,textViewDireccion;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar_sw);
        editText = findViewById(R.id.edtEliminarBuscarCliente);
        textViewNombre = findViewById(R.id.txtNombreEliminarCliente);
        textViewApellido = findViewById(R.id.txtApellidoEliminarCliente);
        textViewTelefono = findViewById(R.id.txtTelefonoEliminarCliente);
        textViewDireccion = findViewById(R.id.txtDireccionEliminarCliente);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEliminarCliente:
                this.eliminar();
                break;
            case R.id.imgBuscarE:
                this.buscarID();
                break;
        }
    }

    public void eliminar(){
        if (!editText.getText().toString().isEmpty()){
            metodosSW.eliminarSW(this,Integer.parseInt(editText.getText().toString()),this,this);
            editText.setText("");
            textViewNombre.setText("...");
            textViewApellido.setText("...");
            textViewTelefono.setText("...");
            textViewDireccion.setText("...");
            Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }
    private void buscarID(){
        if (!editText.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this,Integer.parseInt(editText.getText().toString()),this,this);
        }else{
            Toast.makeText(this, "Debe de llenar el campo ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultadoConsulta(JSONObject response){
        ClienteVO clienteVO = new ClienteVO();
        JSONArray jsonArray = response.optJSONArray("tbl_cliente");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            clienteVO.setNombreCliente(jsonObject.optString("nombre_cliente"));
            clienteVO.setApellidoCliente(jsonObject.optString("apellido_cliente"));
            clienteVO.setTelefonoCliente(jsonObject.optInt("telefono_cliente"));
            clienteVO.setDireccionCliente(jsonObject.optString("direccion_cliente"));

            String dato = clienteVO.getNombreCliente();
            if (!dato.equals("...")){
                textViewNombre.setText(clienteVO.getNombreCliente());
                textViewApellido.setText(clienteVO.getApellidoCliente());
                textViewTelefono.setText(String.valueOf(clienteVO.getTelefonoCliente()));
                textViewDireccion.setText(clienteVO.getDireccionCliente());
            }
            else{
                textViewNombre.setText("...");
                textViewApellido.setText("...");
                textViewTelefono.setText("...");
                textViewDireccion.setText("...");
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a E", Toast.LENGTH_SHORT).show();
            System.err.println("E....."+e.getCause()+"------"+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a E"+error, Toast.LENGTH_SHORT).show();
        System.err.println("E....."+error);
    }

}