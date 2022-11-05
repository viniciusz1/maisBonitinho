package com.example.maisbonitinho;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, emailView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageview);
        this.nameView = itemView.findViewById(R.id.name);
        this.emailView = itemView.findViewById(R.id.email);
    }

}
