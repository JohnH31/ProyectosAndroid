package com.jherrera.myapplista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    ArrayList<String> vocales = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaVocales);

        //Llenado de arrayList
        vocales.add("A");
        vocales.add("E");
        vocales.add("I");
        vocales.add("O");
        vocales.add("U");

        //llenado de arrayList de imagenes a trasladar
        img.add(R.drawable.a);
        img.add(R.drawable.mi);
        img.add(R.drawable.yo);
        img.add(R.drawable.o);
        img.add(R.drawable.u);

        //Declaracion del adaptador para la visualizacion de la informacion de la lista
        //Llenado de la lista
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vocales);
        lista.setAdapter(adapter);

        //Metodo para poder activar la funcion de presionar los componenetes de la lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"A pulsado "+vocales.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MAVocales.class);
                intent.putExtra("imagen",img.get(position));
                startActivity(intent);
            }
        });



    }
}