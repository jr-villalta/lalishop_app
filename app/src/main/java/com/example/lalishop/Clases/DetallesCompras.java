package com.example.lalishop.Clases;

public class DetallesCompras {

    int id;
    String nombre;
    String descripcion_producto;

    public DetallesCompras(int id, String nombre, String descripcion_producto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion_producto = descripcion_producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }
}
