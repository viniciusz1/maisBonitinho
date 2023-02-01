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

        Button imageButton = findViewById(R.id.inputImagem);
        imageButton.setOnClickListener((v -> pickImage()));

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
                i.putExtra("foto", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAITSURBVHgB7Zg7SANBFEU3fgkoBC1SpEmTQiux0EKstBIxmo+aOq12KbW1TSfYCDZiayUWYiFWVlqIhY0kfgtB8P8b75AFl9nRjHnxbYo5cAlJzs7elw277DqOxWKxWCyWxkIIMYlcIefIhIF7iZSruaygzADyKL65qIfLCorE3KPgpUR1WUGJMHKgFPtEchSXFRQIIevCzxLFZQclFjTFNpEmissKCkwhH0qxI6ST4rKCAn3IvVLsBolTXFZQIIqcKcVekGGKywoKtCF7wk+e4rKDEquaYkWqywpKFDTFtpEWissKCowh70qxEyRCcVlBgR7kTil2iyQoLiso0IWcKsXekBGKywoKtCI7ws88xWUHJZY1xVaoLisoMacptit/eYpbbadJUbnLkkk7RLDGqPvf9iL/+90U12THZc8ictFZp0awbUJUzjJe5Fmol+Ka7rykLFbTMNgmghwra8nrwTjF/UuBFPJKGQZuM7Il/BQobi3DZCjDwCtqiq1RXdZh8H1eU2wfaae4rMPg8yHkWfHl/UOU4rIOg/dx5FrxHpB+zZrGLusweO1ADpXv5WOZjGYtY/e/hpkR/ouVfJ8TlacXKovudt4LbPY3lw3scFpzZHRsICF3m7Kpyz1MVviPjBf55C/s8UumbhDD/HRk5NPwmOKmTN1AEP4TwBMySHUDAWXS7i8rk6yXa7FYLBZL0HwBYmOUou1TWSkAAAAASUVORK5CYII=");
            }
            startActivity(i);
        }));
    }
}
