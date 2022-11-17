package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.lalishop.Adaptador.AdaptadorProductos;
import com.example.lalishop.Modelo.ModeloProductos;
import com.example.lalishop.Modelo.ServiceAPI;
import com.example.lalishop.ServiceUtils.ApiDireccion;
import com.example.lalishop.ServiceUtils.ApiUtils;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ListView listView;
    private AdaptadorProductos adaptadorProductos;
    //private ServiceAPI service = ApiUtils.getProducto(ApiDireccion.base).create(ServiceAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        mAuth = FirebaseAuth.getInstance();
        listView = findViewById(R.id.ListProductos);

        //getProductos();

    }
    /*
    public void getProductos(){
        Call<List<ModeloProductos>> listCall = service.getProductos();

        listCall.enqueue(new Callback<List<ModeloProductos>>() {
            @Override
            public void onResponse(Call<List<ModeloProductos>> call, Response<List<ModeloProductos>> response) {
                if (response.isSuccessful()){
                    adaptadorProductos = new AdaptadorProductos(getApplicationContext(), response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ModeloProductos>> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }*/

    public void cerrarsesion(View view){
        mAuth.signOut();
        finish();

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}