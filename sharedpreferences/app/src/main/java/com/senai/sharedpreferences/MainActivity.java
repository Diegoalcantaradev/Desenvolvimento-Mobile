package com.senai.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.senai.sharedpreferences.controllers.StudentController;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private EditText inputEmail;
    private EditText inputPass;
    private Button btnLogin;
    private Button btnRegister;
    private SwitchMaterial switchMaterial;
    private StudentController studentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        inputEmail=findViewById(R.id.email);
        inputPass=findViewById(R.id.inputPass);
        switchMaterial= findViewById(R.id.switchMaterial);

        //criando um arquivo compartilhável para armazenar dados do usuário em modo privado
        //O MODE_PRIVATE permite que apenas a applicação possa acessar o arquivo
        sp = getSharedPreferences(getString(R.string.prefs_login), Context.MODE_PRIVATE);
        //Recuperar dados do arquivo de preferências
        //Capturar o valor armazenado na chave correspondente a senha
        inputEmail.setText(sp.getString(getString(R.string.prefs_email),""));
        //Capturar o valor armazenado na chave correspondente ao email
        inputPass.setText(sp.getString(getString(R.string.prefs_pass),""));
        //Capturar o valor armazenado na chave correspondente ao switch
        switchMaterial.setChecked(sp.getBoolean(getString(R.string.prefs_switch),false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                studentController= new StudentController(MainActivity.this);
                boolean login = studentController.authenticantion(inputEmail.getText().toString(),inputPass.getText().toString());
                
                if(login){
                    editor = sp.edit();
                    if (switchMaterial.isChecked()){

                        editor.putString(getString(R.string.prefs_email), inputEmail.getText().toString());
                        editor.putString(getString(R.string.prefs_pass), inputPass.getText().toString());
                        editor.putBoolean(getString(R.string.prefs_switch),switchMaterial.isChecked());
                    }else{
                        editor.remove(getString(R.string.prefs_email));
                        editor.remove(getString(R.string.prefs_pass));
                        editor.remove(getString(R.string.prefs_switch));
                    }
                    editor.apply();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();//Finalizar a execução da activity atual
                }else{
                    Snackbar.make(v, "Usuário ou senha inválidos", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        }
    }
