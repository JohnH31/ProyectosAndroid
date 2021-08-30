package com.jherrera.myapppinturas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView lista;
    ArrayList<String> cate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Barra de Pinturas");
        lista = findViewById(R.id.listaCategoria);

        //Llenado de arrayList
        cate.add("Arte Abstracto");
        cate.add("Impresionismo");
        cate.add("Subrealismo");

        //Declaracion del adaptador para la visualizacion de la informacion de la lista
        //Llenado de la lista
        AdtaptadorListaP adtaptadorListaP = new AdtaptadorListaP(this,R.layout.lista_personalizada,cate);
        lista.setAdapter(adtaptadorListaP);

        //Metodo para poder activar la funcion de presionar los componenetes de la lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this,"A pulsado "+cate.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MAArte.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"A pulsado "+cate.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getApplicationContext(),MAArte02.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"A pulsado "+cate.get(position), Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(getApplicationContext(),MAArte03.class);
                        startActivity(intent3);
                        break;
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Pinturas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this,"Pinturas",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}