package com.example.myapp_gridview;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridViewId);

        nombres.add("Perro");
        nombres.add("Gato");
        nombres.add("Hamster");
        nombres.add("Tortuga");
        nombres.add("Loro");
        nombres.add("Huron");

        img.add(R.drawable.perro);
        img.add(R.drawable.gato);
        img.add(R.drawable.hamster);
        img.add(R.drawable.tortuga);
        img.add(R.drawable.loro);
        img.add(R.drawable.huron);

        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(this, R.layout.grid_personalizado,nombres,img);
        gridView.setAdapter(adaptadorGrid);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres);
        //gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "A pulsado "+nombres.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MAImagen.class);
                intent.putExtra("imagen", img.get(position));
                startActivity(intent);
            }
        });
    }
}