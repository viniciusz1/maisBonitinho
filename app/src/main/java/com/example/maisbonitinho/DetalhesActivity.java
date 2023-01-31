package com.example.maisbonitinho;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nome = extras.getString("nome");
            TextView nometxt = (TextView) findViewById(R.id.txtNome);
            nometxt.setText(nome);
            String sinopse = extras.getString("sinopse");
            TextView sinopsetxt = (TextView) findViewById(R.id.txtSinopse);
            sinopsetxt.setText(sinopse);
            String editora = extras.getString("editora");
            TextView editoratxt = (TextView) findViewById(R.id.txtEditora);
            editoratxt.setText(editora);
            String ano = extras.getString("ano");
            TextView anotxt = (TextView) findViewById(R.id.txtano);
            anotxt.setText(ano);
            int foto = extras.getInt("foto");
            ImageView imageview = (ImageView) findViewById(R.id.imageDetalhes);
            imageview.setImageResource(foto);
        }

        Button botaoVoltar = findViewById(R.id.buttonReturnDetalhes);
        botaoVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
