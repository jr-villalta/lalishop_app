package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView txtNombrePerfil;
    TextView txtCorreoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtNombrePerfil = findViewById(R.id.TxtNombrePerfil);
        txtCorreoPerfil = findViewById(R.id.TxtCorreoPerfil);

    }

    public void editarusuario(){

    }
}