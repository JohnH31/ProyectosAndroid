package com.jherrera.myapppinturas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    private ArrayList<Integer> dato = new ArrayList<>();
    private ArrayList<Integer> img = new ArrayList<>();
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<String> nomP = new ArrayList<>();

    public AdaptadorLista(Context context, int referenciaLista,ArrayList<Integer> dato,ArrayList<Integer> img,ArrayList<Integer> pre,ArrayList<String> nomP ){
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.dato = dato;
        this.img = img;
        this.pre = pre;
        this.nomP = nomP;

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
        int pins;
        int ima;
        int pree;
        String dess;
        pins = this.dato.get(position);
        ima = this.img.get(position);
        pree = this.pre.get(position);
        dess = this.nomP.get(position);
        TextView campo,campo4,campo5;
        ImageView campo2;
        Button campo3;
        campo3 = v.findViewById(R.id.btnEnviar);
        campo = v.findViewById(R.id.txtDescripcion);
        campo2 = v.findViewById(R.id.imgLista);
        campo4 = v.findViewById(R.id.txtPresioPintura);
        campo5 = v.findViewById(R.id.txtNomPintura);
        campo.setText(pins);
        campo4.setText(String.valueOf(pree));
        campo5.setText(String.valueOf(dess));
        campo2.setImageResource(ima);
        campo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MACompra.class);
                intent.putExtra("imagen",img.get(position));
                intent.putExtra("texto",dato.get(position));
                intent.putExtra("textoP",pre.get(position));
                intent.putExtra("textoD",nomP.get(position));
                context.startActivity(intent);
            }
        });
        //campo3.setFocusable(false);
        //campo3.setClickable(false);
        return v;
    }
}
