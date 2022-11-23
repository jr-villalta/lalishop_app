package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lalishop.Adaptador.CategoryAdapter;
import com.example.lalishop.Modelo.Category;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    TextView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);

        mAuth = FirebaseAuth.getInstance();

        inicio();

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.shirt));
        categoryList.add(new Category(2, R.drawable.shirt));
        categoryList.add(new Category(3, R.drawable.shirt));
        categoryList.add(new Category(4, R.drawable.shirt));
        categoryList.add(new Category(5, R.drawable.shirt));
        categoryList.add(new Category(6, R.drawable.shirt));
        categoryList.add(new Category(7, R.drawable.shirt));
        categoryList.add(new Category(8, R.drawable.shirt));

        setCategoryRecycler(categoryList);


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
                startActivity(new Intent(getApplicationContext(),ProductsActivity.class));
            }else{
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        }else{
            cargarSinInternetActivity();
        }
    }

    public void cargarSinInternetActivity(){
        Intent intent = new Intent(this, SinInternetActivity.class);
        startActivity(intent);
        finish();
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
}