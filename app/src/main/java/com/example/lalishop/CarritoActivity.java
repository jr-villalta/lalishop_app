package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lalishop.Adaptador.AdaptadorCarrito;
import com.example.lalishop.Modelo.Carrito;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private TextView txtTotalcarrito;
    private ListView listproductoscarrito;
    private Spinner spinercategoria;
    private AdaptadorCarrito adaptadorcarrito;
    private ArrayList<Carrito> ListproduCarrito = new ArrayList<>();
    private double total;
    private double precioitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        listproductoscarrito = findViewById(R.id.ListProductoscarrito);
        txtTotalcarrito = findViewById(R.id.BtnPagar);

        Log.d("Respuesta Produx", MainActivity.IDUsuario);

        getProductos();
    }

    public void getProductos(){

        for (Carrito itemscarrito:MainActivity.ListCarrito) {

            Log.d("Respuesta", String.valueOf(itemscarrito.getNombre()));
            ListproduCarrito.add(itemscarrito);

            /*precioitem = Double.parseDouble(itemscarrito.getPrecio());
            total = total+precioitem;*/
        }

        //txtTotalcarrito.setText(""+total);

        adaptadorcarrito = new AdaptadorCarrito(ListproduCarrito, getApplicationContext());
        listproductoscarrito.setAdapter((ListAdapter) adaptadorcarrito);

    }

    public void Pago(){

    }


}