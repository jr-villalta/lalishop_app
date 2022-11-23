package com.example.lalishop.Modelo;

public class Carrito {

    private String produto_ID;
    private String Usuario_ID;
    private String Nombre;
    private String Descripcion;
    private String Precio;
    private String Stock;
    private String Imagen;

    public Carrito(){

    }

    public Carrito(String produto_ID, String usuario_ID, String nombre, String descripcion,
                   String precio, String stock, String imagen) {
        this.produto_ID = produto_ID;
        Usuario_ID = usuario_ID;
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        Stock = stock;
        Imagen = imagen;
    }

    public String getProduto_ID() {
        return produto_ID;
    }

    public void setProduto_ID(String produto_ID) {
        this.produto_ID = produto_ID;
    }

    public String getUsuario_ID() {
        return Usuario_ID;
    }

    public void setUsuario_ID(String usuario_ID) {
        Usuario_ID = usuario_ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
