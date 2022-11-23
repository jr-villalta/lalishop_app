package com.example.lalishop.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lalishop.Modelo.Carrito;
import com.example.lalishop.R;

import java.util.ArrayList;

public class AdaptadorCarrito extends BaseAdapter {

    public ArrayList<Carrito> datos;
    public Context context;

    TextView TxtNombreItem, TxtPrecioItem;

    public AdaptadorCarrito(ArrayList<Carrito> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Carrito carrito = (Carrito) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_products,null);

        TxtNombreItem = view.findViewById(R.id.TxtNombreItem);
        TxtPrecioItem = view.findViewById(R.id.TxtPrecioItem);
        ImageView img = view.findViewById(R.id.ImgItem);

        TxtNombreItem.setText(carrito.getNombre());
        TxtPrecioItem.setText(carrito.getPrecio());
        Glide.with(context).load(carrito.getImagen()).into(img);

        return view;
    }

}
