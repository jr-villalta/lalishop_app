package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lalishop.Modelo.Carrito;
import com.google.firebase.auth.FirebaseAuth;

public class InfoProductoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Carrito CarritoInfProducto = new Carrito();
    private ImageView imgInfoProducto;
    private TextView txtNombreInfoProducto, txtPrecioInfoProducto,
                    txtCategoriaInfoProducto, txtDescripcionInfoProducto;
    private Button btnCarrito;

    private String ID, Stock, imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_producto);

        mAuth = FirebaseAuth.getInstance();

        txtNombreInfoProducto = findViewById(R.id.TxtNombreInfoProducto);
        txtPrecioInfoProducto = findViewById(R.id.TxtPrecioInfoProducto);
        txtCategoriaInfoProducto = findViewById(R.id.TxtCategoriaInfoProducto);
        txtDescripcionInfoProducto = findViewById(R.id.TxtDescripcionInfoProducto);
        imgInfoProducto = findViewById(R.id.ImgInfoProducto);

        informacion();
    }

    public void informacion(){

        txtNombreInfoProducto.setText(getIntent().getStringExtra("Nombre"));
        txtPrecioInfoProducto.setText("Precio: "+getIntent().getStringExtra("Precio"));
        txtCategoriaInfoProducto.setText("Categoria: "+getIntent().getStringExtra("Categoria"));
        txtDescripcionInfoProducto.setText(getIntent().getStringExtra("Descripcion"));

        ID = getIntent().getStringExtra("ID");
        Stock = getIntent().getStringExtra("Stock");
        imagen = getIntent().getStringExtra("Imagen");

        Log.d("Respuesta",String.valueOf(getIntent().getStringExtra("Imagen")));

        Glide.with(getApplicationContext()).load(imagen).into(imgInfoProducto);

    }

    public  void agregar_al_carrito(View view) {

        CarritoInfProducto.setProduto_ID(ID);
        CarritoInfProducto.setUsuario_ID(MainActivity.IDUsuario);
        CarritoInfProducto.setNombre(txtNombreInfoProducto.getText().toString());
        CarritoInfProducto.setDescripcion(txtDescripcionInfoProducto.getText().toString());
        CarritoInfProducto.setPrecio(txtPrecioInfoProducto.getText().toString());
        CarritoInfProducto.setStock(Stock);
        CarritoInfProducto.setImagen(imagen);

        MainActivity.ListCarrito.add(CarritoInfProducto);

    }

    public void cerrarsesioninfoProduts(View view){
        mAuth.signOut();
        finish();

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}