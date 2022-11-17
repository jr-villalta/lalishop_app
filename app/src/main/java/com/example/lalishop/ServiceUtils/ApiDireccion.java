package com.example.lalishop.ServiceUtils;

import com.example.lalishop.Modelo.ServiceAPI;

public class ApiDireccion {

    public static final String base = " ";

    public static ServiceAPI getServiceProductos(){
        return ApiUtils.getProducto(base+" ").create(ServiceAPI.class);
    }

    public static ServiceAPI getServiceDetallesCompras(){
        return ApiUtils.getDetalleCompras(base+" ").create(ServiceAPI.class);
    }


}
