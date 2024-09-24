package com.senai.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.senai.sharedpreferences.entities.Student;
import com.senai.sharedpreferences.entities.database.DatabaseHelper;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText cadastroNome,cadastroEmail,cadastroSenha;
    private Button btnCadastrar, btnloginvoltar;

    private DatabaseHelper databaseHelper = new DatabaseHelper(new ArrayList<>());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        cadastroEmail = findViewById(R.id.cadastroEmail);
        cadastroSenha = findViewById(R.id.cadastroSenha);
        cadastroNome = findViewById(R.id.cadastroNome);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnloginvoltar = findViewById(R.id.btnloginvoltar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long i = 0;
                databaseHelper.saveObject(
                        new Student(i++,
                                cadastroNome.getText().toString(),
                                cadastroEmail.getText().toString(),
                                cadastroSenha.getText().toString()
                                ));
                Snackbar.make(view,"Estudante cadastrado com sucesso!",Snackbar.LENGTH_SHORT).show();
            }
        });
        btnloginvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            }
        });
    }
}