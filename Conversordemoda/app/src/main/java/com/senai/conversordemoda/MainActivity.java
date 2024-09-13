package com.senai.conversordemoda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        EditText input = findViewById(R.id.editTextNumbeReal);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.resultText);

        //Evento de click no botão Enviar para mostrar uma mensagem

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validador de campo
                if(input.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), "Campos Vazios!", Toast.LENGTH_SHORT).show();
                }else{
                    double real = Double.parseDouble(input.getText().toString());
                    input.setText("");
                    textView.setText(String.format("$ %.2f", real / 5.55));
                }
        }});

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}