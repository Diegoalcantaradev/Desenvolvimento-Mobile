package com.senai.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<Produto> produtos;
    private ArrayAdapter<String> adapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        produtos = new ArrayList<>();

        //popular a minha lista 'produtos'
        produtos.add(new Produto("mouse",99.9f,15));
        produtos.add(new Produto("mesa",250f,2));
        produtos.add(new Produto("mousepad",25.99f,100));
        produtos.add(new Produto("monitor",999.9f,10));
        produtos.add(new Produto("Teclado",500f,10));

        //Instãnciar o adapter e definir o layout em que os dados serão apresentados

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //Passar o adapter para a lista

        lista.setAdapter(adapter);


    }
}