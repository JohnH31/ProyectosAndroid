package com.jherrera.myappsuma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo1;
    private TextView resultado;
    private EditText campo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 =findViewById(R.id.txtNum1);
        campo2 =findViewById(R.id.txtNum2);
        resultado =findViewById(R.id.txtResultado);
    }

    public void suma(){
        String num1;
        String num2;
        num1 = campo1.getText().toString();
        num2 = campo2.getText().toString();
        if (!num1.isEmpty()&&!num2.isEmpty()){
            int resul;
            resul = Integer.parseInt(num1) + Integer.parseInt(num2);
            resultado.setText("resultado: "+resul);

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.suma();
                break;
        }
    }
}