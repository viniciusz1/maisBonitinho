package com.example.maisbonitinho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<Item> items = new ArrayList<Item>();


    public void mudarParaDetalhes(int posicao){
        Item item = items.get(posicao);
        Intent i = new Intent(this, DetalhesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com","sdkjçflas", "çldsakfjçlasjd", R.drawable.ima));
        items.add(new Item("Cléber", "johnalçsdlfkj@gmail.com","sdkjçflas", "çldsakfjçlasjd", R.drawable.ima));

        FloatingActionButton botao = findViewById(R.id.botaoflutuante);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(i);
            }

        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}