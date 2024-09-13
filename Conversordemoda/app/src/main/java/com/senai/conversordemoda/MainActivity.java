package com.senai.conversordemoda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText realvalor = findViewById(R.id.editTextNumbeReal);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.resultText);

        //Evento de click no botão Enviar para mostrar uma mensagem

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Capturar Real
            Double real = Double.parseDouble(realvalor.getText().toString());
            //calculo
                Double valorfinal = real/5.62;

            //Adicionar um texto no campo textView no xml
            textView.setText(String.format("Seu dinheiro vale %.2f dolares",valorfinal));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}