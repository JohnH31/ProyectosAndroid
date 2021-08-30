package com.jherrera.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MAArte extends AppCompatActivity {
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
        img.add(R.drawable.abstracto);
        img.add(R.drawable.abstracto1);
        img.add(R.drawable.abstracto2);

        //nombrer pintura
        textoD.add("La Loba");
        textoD.add("Amarrillo, Rojo y Azul");
        textoD.add("Composición suprematista");

        //Precio pintura
        textoP.add(1005);
        textoP.add(4500);
        textoP.add(1050);

        //descripcion
        texto.add(R.string.Laloba);
        texto.add(R.string.Amarrillorojoazul);
        texto.add(R.string.Composiciónsuprematista);


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