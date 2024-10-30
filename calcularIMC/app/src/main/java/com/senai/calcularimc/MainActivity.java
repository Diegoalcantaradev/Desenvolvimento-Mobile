package com.senai.calcularimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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
        EditText peso = findViewById(R.id.peso);
        EditText altura = findViewById(R.id.altura);
        Button button = findViewById(R.id.button);
        TextView resultado = findViewById(R.id.resultado);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(altura.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "Campo Vazio!", Toast.LENGTH_SHORT).show();

                }else {
                double valorAltura = Double.parseDouble(altura.getText().toString());
                double valorPeso = Double.parseDouble(peso.getText().toString());
                double valorIMC = valorPeso / (valorAltura * valorAltura);
                String resultIMC = String.format("%.2f",valorIMC);
                resultado.setText("IMC: " + resultIMC);

            }}
        });
    }
}