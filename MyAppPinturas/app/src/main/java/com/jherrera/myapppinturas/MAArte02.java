package com.jherrera.myapppinturas;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MAArte02 extends AppCompatActivity {
    private ListView listas;
    private ArrayList<Integer> img = new ArrayList<>();
    private ArrayList<Integer> texto = new ArrayList<>();
    private ArrayList<String> textoD = new ArrayList<>();
    private ArrayList<Integer> textoP = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maarte);
        listas = findViewById(R.id.listaCategorias);

        //llenado de arrayList de imagenes a trasladar
        img.add(R.drawable.impresionismo);
        img.add(R.drawable.impresionismo1);
        img.add(R.drawable.impresionismo2);

        //nombrer pintura
        textoD.add("Villeneuve, Sisley");
        textoD.add("Naturaleza muerta con manzanas");
        textoD.add("En el Cafe");

        //Precio pintura
        textoP.add(5665);
        textoP.add(9865);
        textoP.add(3463);

        //descripcion
        texto.add(R.string.VilleneuveSisley);
        texto.add(R.string.Naturalezamuertaconmanzanas);
        texto.add(R.string.EnelCafé);


        AdaptadorLista adaptadorLista = new AdaptadorLista(this,R.layout.lista_personalizar,texto,img,textoP,textoD);
        listas.setAdapter(adaptadorLista);
        //listas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //  @Override
        //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //  Intent intent = new Intent(getApplicationContext(),MACompra.class);
        //intent.putExtra("imagen",img.get(position));
        //intent.putExtra("texto",texto.get(position));
        //intent.putExtra("textoP",textoP.get(position));
        //intent.putExtra("textoD",textoD.get(position));
        //startActivity(intent);
        //finish();
        //}
        //});
    }

    //public void onClick(AdapterView<?> parent, View view, int position, long id) {
    //  switch (view.getId()) {
    //    case R.id.btnEnviar:
    //      Intent intent = new Intent(getApplicationContext(),MACompra.class);
    //    intent.putExtra("imagen",img.get(position));
    //  intent.putExtra("texto",texto.get(position));
    //startActivity(intent);
    //finish();
    //break;
    //}
    //}
}

