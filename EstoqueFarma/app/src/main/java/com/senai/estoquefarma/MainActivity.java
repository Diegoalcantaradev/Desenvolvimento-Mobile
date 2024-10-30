package com.senai.estoquefarma;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtNome, edtCategoria, edtPreco, edtQuantidade;
    Button btnSalvar;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        btnSalvar.setOnClickListener(v -> {
            String nome = edtNome.getText().toString();
            Produto produto = new Produto(nome, categoria, preco, quantidade);
            dbHelper.insertProduto(produto);
            finish();
        });
    }
}