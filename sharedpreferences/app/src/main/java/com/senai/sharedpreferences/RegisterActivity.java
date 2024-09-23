package com.senai.sharedpreferences;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private EditText cadastroNome,cadastroEmail,cadastroSenha;
    private Button btnCadastrar, btnloginvoltar;

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

    }
}