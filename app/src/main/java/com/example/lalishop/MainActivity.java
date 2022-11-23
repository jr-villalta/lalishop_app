package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.lalishop.Modelo.Carrito;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    public static String IDUsuario;
    public static ArrayList<Carrito> ListCarrito = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        inicio();

    }

    public void inicio(){
        //VERIFICAR QUE SE TENGA CONEXION A INTERNET
        ConnectivityManager cm =
                (ConnectivityManager)MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected){
            // Verifica si el usuario tiene sesion iniciada (non-null) y actualiza la vista
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null){
                IDUsuario=currentUser.getUid();
                startActivity(new Intent(getApplicationContext(),ProductsActivity.class));
            }else{
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        }else{
            Intent intent = new Intent(this, SinInternetActivity.class);
            startActivity(intent);
            finish();
        }
    }

}