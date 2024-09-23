package com.senai.splashscreenandintent;

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

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        btnEnviar = findViewById(R.id.button);
        //Validação para preencher o campo de input

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validação para preencher o campo
                if(inputName.getText().toString().isEmpty()){
                    Snackbar.make(view,"Preencha o campo com seu nome!", Snackbar.LENGTH_SHORT).setAction("Teste", null).show();
                }else{
                    String nome = inputName.getText().toString();

                    Intent i = new Intent (MainActivity.this, ResultActivity.class);
                    i.putExtra("nome",nome);
                    startActivity(i);
                }

            }
        });
    }
}