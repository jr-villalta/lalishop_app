package com.example.lalishop.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeloProductos {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("categoria")
    @Expose
    public String categoria;
    @SerializedName("nombre_producto")
    @Expose
    public String nombreProducto;
    @SerializedName("descripcion_producto")
    @Expose
    public String descripcionProducto;
    @SerializedName("precio_producto")
    @Expose
    public String precioProducto;
    @SerializedName("stock_producto")
    @Expose
    public String stockProducto;
    @SerializedName("imagen_producto")
    @Expose
    public String imagenProducto;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    public ModeloProductos(Integer id, String categoria, String nombreProducto,
                           String descripcionProducto, String precioProducto, String stockProducto,
                           String imagenProducto, String createdAt, String updatedAt) {
        this.id = id;
        this.categoria = categoria;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.imagenProducto = imagenProducto;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
