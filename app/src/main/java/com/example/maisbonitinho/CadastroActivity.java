package com.example.maisbonitinho;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
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


    private static final int PICK_PHOTO_FOR_AVATAR = 0;

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
                Toast.makeText(null, "hehehehehe", Toast.LENGTH_SHORT);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
//                EditText foto = (EditText)  findViewById(R.id.inputFoto);
//                i.putExtra("foto", foto.getText().toString());
            startActivity(i);
        }));
    }
}
