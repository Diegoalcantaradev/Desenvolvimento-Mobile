package com.senai.conversordetemperatura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.editTextNumbeReal);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.resultText);
        RadioGroup radioGroup = findViewById(R.id.radioGroupOptions);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int i) {
                                                      radioButton = findViewById(i);
                                                  }
                                              });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().equals("")) {
                    Toast.makeText(textView.getContext(), "Campos Vazios!", Toast.LENGTH_SHORT).show();
                }else if (radioButton.getText().equals("Fahrenheit")){
                    double c = Double.parseDouble(input.getText().toString());
                    input.setText("");
                    textView.setText(String.format("F %2.f", c * 1.8 + 32 ));
                }else {
                    double c = Double.parseDouble(input.getText().toString());
                    input.setText("");
                    textView.setText(String.format("K %2.f", c + 273 ));
                }

            }});
            }}