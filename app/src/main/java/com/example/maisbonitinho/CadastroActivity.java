package com.example.maisbonitinho;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CadastroActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    Uri uri;

    public void pickImage() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 3);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImagem = data.getData();
            uri =selectedImagem;
            ImageView imageView = findViewById(R.id.imageViewCadastro);
            imageView.setImageURI(selectedImagem);
        }else{
            System.out.println("oi");
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ImageView imageView =  findViewById(R.id.imageViewCadastro);
        imageView.setOnClickListener((view -> pickImage()));



        Button botaoCadastro = findViewById(R.id.botaoCadastro);
        botaoCadastro.setOnClickListener((v -> {
            Intent i = new Intent(CadastroActivity.this, MainActivity.class);
            EditText nome = (EditText)  findViewById(R.id.inputNome);
            i.putExtra("nome", nome.getText().toString());
            EditText sinopse = (EditText)  findViewById(R.id.inputSinopse);
            i.putExtra("sinopse", sinopse.getText().toString());
            EditText editora = (EditText)  findViewById(R.id.inpuEditora);
            i.putExtra("editora", editora.getText().toString());
            EditText ano = (EditText)  findViewById(R.id.inputAno);
            i.putExtra("ano", ano.getText().toString());
            if(uri != null){
                i.putExtra("foto", uri.toString());
            }else{
                i.putExtra("foto", "data:image/png;base64,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");
            }
            startActivity(i);
        }));
        ImageView returnButton = findViewById(R.id.returnCadastro);
        returnButton.setOnClickListener(view -> {
            finish();
        });
    }
}
