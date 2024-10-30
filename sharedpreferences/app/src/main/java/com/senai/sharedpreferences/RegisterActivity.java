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
import com.google.android.material.textfield.TextInputLayout;
import com.senai.sharedpreferences.controllers.StudentController;
import com.senai.sharedpreferences.entities.Student;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText cadastroNome,cadastroEmail,cadastroSenha;
    private Button btnCadastrar, btnloginvoltar;

    private TextInputLayout layoutEmail;
    private StudentController studentController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        cadastroEmail = findViewById(R.id.cadastroEmail);
        cadastroSenha = findViewById(R.id.cadastroSenha);
        cadastroNome = findViewById(R.id.cadastroNome);
        btnCadastrar = findViewById(R.id.btnRegister);
        btnloginvoltar = findViewById(R.id.btnloginvoltar);
        layoutEmail = findViewById(R.id.layoutEmail);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Student student = new Student(
                        null,
                        cadastroNome.getText().toString(),
                        cadastroEmail.getText().toString(),
                        cadastroSenha.getText().toString()
                        );
                try{
                    studentController=new StudentController(RegisterActivity.this);
                    if(studentController.checkEmail(cadastroEmail.getText().toString())){
                        layoutEmail.setError("Email já cadastrado!");
                    }else{
                        layoutEmail.setError(null);
                        Snackbar.make(view, studentController.save(student),Snackbar.LENGTH_SHORT).show();
                        inputName.setText("");
                        inputEmail.setText("");
                        inputPass.setText("");
                    }

                }catch (Exception e){}
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