package com.example.myapp_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends BaseAdapter {
    private Context context;
    private int referencia;
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Integer> img = new ArrayList<>();

    public AdaptadorGrid(Context context, int referencia, ArrayList<String> nombres, ArrayList<Integer> img) {
        this.context = context;
        this.referencia = referencia;
        this.nombres = nombres;
        this.img = img;
    }

    @Override
    public int getCount() {
        return nombres.size();
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
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado, null);
        String nom;
        int img;
        nom = this.nombres.get(position);
        img = this.img.get(position);
        TextView campoN;
        ImageView campoI;
        campoN = v.findViewById(R.id.txtGrid);
        campoI = v.findViewById(R.id.imgGrid);

        campoN.setText(nom);
        campoI.setImageResource(img);


        return v;
    }
}
