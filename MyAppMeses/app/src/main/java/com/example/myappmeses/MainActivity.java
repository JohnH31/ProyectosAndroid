package com.example.myappmeses;

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
    ArrayList<String> meses = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    ArrayList<Integer> texto = new ArrayList<>();
    ArrayList<Integer> texto2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaMeses);

        //Llenado de arrayList
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");

        texto.add(R.string.Enero);
        texto.add(R.string.Febrero);
        texto.add(R.string.Marzo);
        texto.add(R.string.Abril);
        texto.add(R.string.Mayo);
        texto.add(R.string.Junio);
        texto.add(R.string.Julio);
        texto.add(R.string.Agosto);
        texto.add(R.string.Septiembre);
        texto.add(R.string.Octubre);
        texto.add(R.string.Noviembre);
        texto.add(R.string.Diciembre);

        texto2.add(R.string.historia1);
        texto2.add(R.string.historia2);
        texto2.add(R.string.historia3);
        texto2.add(R.string.historia4);
        texto2.add(R.string.historia5);
        texto2.add(R.string.historia6);
        texto2.add(R.string.historia7);
        texto2.add(R.string.historia8);
        texto2.add(R.string.historia9);
        texto2.add(R.string.historia10);
        texto2.add(R.string.historia11);
        texto2.add(R.string.historia12);

        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        num.add(9);
        num.add(10);
        num.add(11);
        num.add(12);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses);
        //lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"A pulsado "+meses.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MAMeses.class);

                intent.putExtra("texto",texto.get(position));
                intent.putExtra("texto2",texto2.get(position));
                startActivity(intent);
            }

        });

        AdaptadorLista adaptadorLista = new AdaptadorLista(this,R.layout.lista_personalizar,meses,num);
        lista.setAdapter(adaptadorLista);

    }
}