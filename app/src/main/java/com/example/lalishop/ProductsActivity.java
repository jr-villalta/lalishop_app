package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.lalishop.Adaptador.AdaptadorProductos;
import com.example.lalishop.Modelo.ModeloCategorias;
import com.example.lalishop.Modelo.ModeloProductos;
import com.example.lalishop.Modelo.ServiceAPI;
import com.example.lalishop.ServiceUtils.ApiDireccion;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ListView listproductos;
    private Spinner spinercategoria;
    private AdaptadorProductos adaptadorProductos;
    private ServiceAPI serviceproductos, servicecategorias;
    private ArrayList<ModeloProductos> ListProductos = new ArrayList<>();
    private ArrayList<String> ListCategorias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        mAuth = FirebaseAuth.getInstance();
        listproductos = findViewById(R.id.ListProductos);
        spinercategoria = findViewById(R.id.SpinerCategoriaProducto);

        getCategorias();

        spinercategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getProductos(ListCategorias.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void getCategorias(){
        ListCategorias.clear();

        servicecategorias = ApiDireccion.getServiceCategorias();

        servicecategorias.getCategorias().enqueue(new Callback<List<ModeloCategorias>>() {
            @Override
            public void onResponse(Call<List<ModeloCategorias>> call,
                                   Response<List<ModeloCategorias>> response) {
                //VERIFICA SI HAY DATOS
                if (response.isSuccessful()) {
                    ListCategorias.add("Seleccione una Categoria");
                    //CICLO FOREACH PARA LA OBTENCION DE DATOS
                    for (ModeloCategorias itemscategorias : response.body()) {
                        //ALMACENA LOS DATOS EN LAS LISTA DE LOS ARRAY
                        ListCategorias.add(itemscategorias.getNombreCategoria());
                    }

                    //SE ASIGNAN LOS DATOS AL SPINNER DE PAISES
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductsActivity.this,
                            android.R.layout.simple_dropdown_item_1line, ListCategorias);
                    spinercategoria.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ModeloCategorias>> call, Throwable t) {
                //MUESTRA MENSAJE EN CONSOLA DEL FALLO
                Log.d("Respuesta", "Fail " + t);
            }
        });
    }

    public void getProductos(String categoria){
        ListProductos.clear();

        serviceproductos = ApiDireccion.getServiceProductos();

        serviceproductos.getProductos().enqueue(new Callback<List<ModeloProductos>>() {
            @Override
            public void onResponse(Call<List<ModeloProductos>> call,
                                   Response<List<ModeloProductos>> response) {
                if (response.isSuccessful()){

                    for (ModeloProductos itemsproductos:response.body()) {

                        if(categoria.equals(itemsproductos.categoria)){
                            Log.d("Respuesta", String.valueOf(itemsproductos));
                            ListProductos.add(itemsproductos);
                        }
                        else if (categoria.equals(ListCategorias.get(0))){
                            Log.d("Respuesta", String.valueOf(itemsproductos));
                            ListProductos.add(itemsproductos);
                        }

                    }

                    adaptadorProductos = new AdaptadorProductos(getApplicationContext(), ListProductos);
                    listproductos.setAdapter(adaptadorProductos);
                }
            }

            @Override
            public void onFailure(Call<List<ModeloProductos>> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });

    }

    public void cerrarsesion(View view){
        mAuth.signOut();
        finish();

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}