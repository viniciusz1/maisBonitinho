package com.example.maisbonitinho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));
        items.add(new Item("John wick", "johnalçsdlfkj@gmail.com", R.drawable.ima));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}