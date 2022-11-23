package com.example.lalishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText txtCorreoLogin;
    private EditText txtContraseñaLogin;
    public static Button btnIniciarSesionLogin;
    private static Button btnregistrarLogin;
    private TextView btnRecuperar;
    private FirebaseAuth mAuth;

    public String email;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtCorreoLogin = findViewById(R.id.TxtCorreoLogin);
        txtContraseñaLogin = findViewById(R.id.TxtContraseñaLogin);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnIniciarSesionLogin = findViewById(R.id.BtnIniciarSesionLogin);
        btnregistrarLogin = findViewById(R.id.BtnregistrarLogin);

        mAuth = FirebaseAuth.getInstance();

        btnIniciarSesionLogin.setOnClickListener(view -> {
            iniciarsesion();
        });

        btnregistrarLogin.setOnClickListener(view -> {
            registrar();
        });

        btnRecuperar.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RecoveryActivity.class));
        });

    }

    public void iniciarsesion(){

        email = txtCorreoLogin.getText().toString();
        password = txtContraseñaLogin.getText().toString();

        if (TextUtils.isEmpty(email)){
            txtCorreoLogin.setError("El correo no puede estar vacío\n");
            txtCorreoLogin.requestFocus();

        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtCorreoLogin.setError("Por favor proporcione un correo electrónico válido\n");
            txtCorreoLogin.requestFocus();

        }else if (TextUtils.isEmpty(password)){
            txtContraseñaLogin.setError("La contraseña no puede estar vacía\n");
            txtContraseñaLogin.requestFocus();

        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    FirebaseUser currentUser = mAuth.getCurrentUser();

                    if (task.isSuccessful()){
                        MainActivity.IDUsuario=currentUser.getUid();
                        Toast.makeText(LoginActivity.this, "El usuario inició sesión con éxito\n", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, ProductsActivity.class));

                    }else{
                        Toast.makeText(LoginActivity.this, "Error de inicio de sesión\n: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    public void registrar(){
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

}