package com.example.lalishop.ServiceUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    private static Retrofit retrofitProducto = null;
    private static Retrofit retrofitDetalleCompra = null;

    public static Retrofit getProducto(String urlBase){
        if (retrofitProducto==null){
            retrofitProducto = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitProducto;
    }

    public static Retrofit getDetalleCompras(String urlBase){
        if (retrofitDetalleCompra==null){
            retrofitDetalleCompra = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitDetalleCompra;
    }

}
