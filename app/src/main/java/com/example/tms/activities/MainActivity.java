package com.example.tms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    //private MyAdapter myAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button eventsButton = findViewById(R.id.events_button);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(i);
            }
        });

        Button ordersButton = findViewById(R.id.orders_button);
        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OrdersActivity.class);
                startActivity(i);
            }
        });


    }


}
