package com.example.lalishop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

public class RecoveryActivity extends AppCompatActivity {

    private EditText txtCorreoRecuperar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        txtCorreoRecuperar = findViewById(R.id.TxtCorreoRecuperar);

    }

    public void recuperarcontraseña(){

    }
}