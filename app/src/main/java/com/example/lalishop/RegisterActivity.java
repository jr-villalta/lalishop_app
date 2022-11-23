package com.example.lalishop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    EditText txtNombreRegistrar;
    EditText txtCorreoRegistrar;
    EditText txtContraseñaRegistrar;

    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNombreRegistrar = findViewById(R.id.TxtNombreRegistrar);
        txtCorreoRegistrar = findViewById(R.id.TxtCorreoRegistrar);
        txtContraseñaRegistrar = findViewById(R.id.TxtContreseñaRegistrar);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

    }

    public void registrarusuario(View view){

        String nombre = txtNombreRegistrar.getText().toString();
        String correo = txtCorreoRegistrar.getText().toString();
        String contraseña = txtContraseñaRegistrar.getText().toString();

        if(TextUtils.isEmpty(nombre)){
            txtNombreRegistrar.setError("El Nombre no puede estar vacío\n");
            txtNombreRegistrar.requestFocus();
        }else if (TextUtils.isEmpty(correo)) {
            txtCorreoRegistrar.setError("El correo no puede estar vacío\n");
            txtCorreoRegistrar.requestFocus();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            txtCorreoRegistrar.setError("Por favor proporcione un correo electrónico válido\n");
            txtCorreoRegistrar.requestFocus();
        }else if (TextUtils.isEmpty(contraseña)) {
            txtContraseñaRegistrar.setError("La contraseña no puede estar vacía\n");
            txtContraseñaRegistrar.requestFocus();
        }else{

            mAuth.createUserWithEmailAndPassword(correo,contraseña)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        Toast.makeText(RegisterActivity.this,
                                "Usuario registrado con éxito\n", Toast.LENGTH_SHORT).show();
                        mAuth.signOut();
                        finish();

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this,
                                "No se pudieron crear los datos correctamente\n" +
                                task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

}