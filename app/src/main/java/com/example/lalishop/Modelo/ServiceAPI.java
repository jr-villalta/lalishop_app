package com.example.lalishop.Modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    @GET("productos")
    Call<List<ModeloProductos>> getProductos();

    @GET("categorias")
    Call<List<ModeloCategorias>> getCategorias();

}
