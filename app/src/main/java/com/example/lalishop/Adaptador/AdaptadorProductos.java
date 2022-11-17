package com.example.lalishop.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lalishop.Modelo.ModeloProductos;
import com.example.lalishop.R;

import java.util.List;

public class AdaptadorProductos extends ArrayAdapter<ModeloProductos> {

    List<ModeloProductos> listaproductos;

    public AdaptadorProductos(Context context, List<ModeloProductos> lista) {
        super(context, R.layout.item_products, lista);
        listaproductos = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_products, null);

        TextView Titulo = view.findViewById(R.id.TxtNombreItem);
        TextView Precio = view.findViewById(R.id.TxtPrecioItem);
        ImageView Imagen = view.findViewById(R.id.ImgItem);

        //Titulo.setText(listaproductos.get(position).getNombre_producto());
        //Precio.setText(listaproductos.get(position).getPrecio_producto());

        //Glide.with(getContext()).load(listaproductos.get(position).getImagen()).into(Imagen);

        return view;

    }

}
