package com.example.maisbonitinho;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context context;
    public static List<Item> items;
    public SelectListener listener;

    public MyAdapter(Context context, List<Item> items, SelectListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameView.setText(items.get(position).getNome());
        holder.emailView.setText(items.get(position).getSinopse());
        holder.imageView.setImageResource(items.get(position).getFoto());

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onItemClicked(items.get(position));
            };
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}