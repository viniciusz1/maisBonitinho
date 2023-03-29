package com.example.maisbonitinho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                MainActivity extends AppCompatActivity implements SelectListener{

    static List<Item> items = new ArrayList<Item>();
    private MyAdapter myAdapter;


    public void mudarParaDetalhes(int posicao){
        Item item = items.get(posicao);
        Intent i = new Intent(this, DetalhesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nome = extras.getString("nome");
            String sinopse = extras.getString("sinopse");
            String editora = extras.getString("editora");
            String ano = extras.getString("ano");
            String foto = extras.getString("foto");
            Uri fotoconvetida = Uri.parse(foto);
            items.add(new Item(nome, sinopse, editora, ano, fotoconvetida));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);



        FloatingActionButton botao = findViewById(R.id.botaoflutuante);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(i);
            }

        });
        myAdapter = new MyAdapter(getApplicationContext(), items, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(Item item) {
        Intent i = new Intent(MainActivity.this, DetalhesActivity.class);
        i.putExtra("nome", item.getNome());
        i.putExtra("sinopse",  item.getSinopse());
        i.putExtra("editora", item.getEditora());
        i.putExtra("ano", item.getAno());
        i.putExtra("foto", item.getFoto().toString());
        startActivity(i);
    }
    @Override
    public void deleteItem(int position){
        items.remove(position);
        myAdapter.notifyItemRemoved(position);
    }

}