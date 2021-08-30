package com.jherrera.myapppinturas;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MAArte03 extends AppCompatActivity {
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
        img.add(R.drawable.subrealismo);
        img.add(R.drawable.subrealismo1);
        img.add(R.drawable.subrealismo2);

        //nombrer pintura
        textoD.add("Los hombres que no saben nada");
        textoD.add("La persistencia de la memoria");
        textoD.add("El cazador");

        //Precio pintura
        textoP.add(5456);
        textoP.add(7654);
        textoP.add(6789);

        //descripcion
        texto.add(R.string.Loshombresquenosabennada);
        texto.add(R.string.Lapersistenciadelamemoria);
        texto.add(R.string.Elcazador);


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
