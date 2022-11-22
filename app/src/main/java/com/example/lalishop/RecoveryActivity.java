package com.example.lalishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class RecoveryActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private EditText txtCorreoRecuperar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        mAuth = FirebaseAuth.getInstance();
        txtCorreoRecuperar = findViewById(R.id.TxtCorreoRecuperar);
        progressBar = findViewById(R.id.progressBar);

    }

    public void recuperarcontraseña(View view){

        String correo = txtCorreoRecuperar.getText().toString();

        if (TextUtils.isEmpty(correo)){
            txtCorreoRecuperar.setError("El correo no puede estar vacío\n");
            txtCorreoRecuperar.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            txtCorreoRecuperar.setError("Por favor proporcione un correo electrónico válido\n");
            txtCorreoRecuperar.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RecoveryActivity.this, "Verifica tu correo", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(RecoveryActivity.this, "Vuelve a intentarlo, algo salió mal", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}