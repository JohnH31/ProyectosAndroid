package com.jherrera.myapppinturas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdtaptadorListaP extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    private ArrayList<String> dato = new ArrayList<>();

    public AdtaptadorListaP(Context context, int referenciaLista,ArrayList<String> dato){
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.dato = dato;
    }

    @Override
    public int getCount() {
        return this.dato.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //variable de tipo vista que sera el retorno
        View v = convertView;
        //reconoce el contexto donde se va mostrar la lista personalizada
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //cra la referencia para el retorno de la nueva lista personalizada
        v = layoutInflater.inflate(R.layout.lista_personalizada,null);
        String kilo;
        kilo = this.dato.get(position);
        TextView campk;
        campk = v.findViewById(R.id.txtTitulo);
        campk.setText(kilo);
        return v;
    }

}
