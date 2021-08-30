package com.example.myappmeses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<String> dato = new ArrayList<>();
    private ArrayList<Integer> num = new ArrayList<>();

    public AdaptadorLista(Context context, int referenciaLista,ArrayList<String> dato,ArrayList<Integer> num ){
    this.context = context;
    this.referenciaLista = referenciaLista;
    this.dato = dato;
    this.num = num;
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
        v = layoutInflater.inflate(R.layout.lista_personalizar,null);
        String mes;
        int numero;
        mes = this.dato.get(position);
        numero = this.num.get(position);
        TextView campo,campo2;
        campo = v.findViewById(R.id.txtLista);
        campo2 = v.findViewById(R.id.txtNum);
        campo.setText(String.valueOf(mes));
        campo2.setText(String.valueOf(numero));
        return v;
    }
}
