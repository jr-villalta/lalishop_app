package com.example.lalishop.Modelo;

import com.example.lalishop.Clases.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    @GET(" ")
    Call<List<ModeloProductos>> getProductos();

}
