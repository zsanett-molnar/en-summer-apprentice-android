package com.example.tms.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.tms.R;
import com.example.tms.adapter.OrderAdapter;
import com.example.tms.model.Event;
import com.example.tms.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        RecyclerView rvOrders = (RecyclerView) findViewById(R.id.orders);

        List<Order> orders = getOrders();
        OrderAdapter adapter = new OrderAdapter(orders);
        rvOrders.setAdapter(adapter);
        rvOrders.setLayoutManager(new LinearLayoutManager(this));



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("CONFIRMATION")
                .setTitle("CONFIRMATION2")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // CONFIRM
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // CANCEL
                    }
                });
        // Create the AlertDialog object and return it
        builder.create();

    }

    private List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Untold","VIP", new Date(), 3, 300L));
        orders.add(new Order("Wine festival","Basic", new Date(), 4, 400L));
        orders.add(new Order("Electric castle","VIP", new Date(), 5, 500L));
        orders.add(new Order("Neversea","VIP", new Date(), 1, 300L));
        return orders;
    }
}