package com.example.maisbonitinho;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, emailView;
    RelativeLayout cardView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageview);
        this.nameView = itemView.findViewById(R.id.name);
        this.emailView = itemView.findViewById(R.id.email);
        this.cardView = itemView.findViewById(R.id.containerItem);
    }




}
