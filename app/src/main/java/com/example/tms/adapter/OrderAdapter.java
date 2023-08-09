package com.example.tms.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.R;
import com.example.tms.activities.EventsActivity;
import com.example.tms.activities.MainActivity;
import com.example.tms.activities.OrdersActivity;
import com.example.tms.model.Event;
import com.example.tms.model.Order;

import org.w3c.dom.Text;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Order> mOrders;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView orderIdentifier;
        public TextView orderDescription;
        public TextView noTickets;

        public TextView ticketCategory;

        public TextView totalPrice;
        public Button detailsButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            orderIdentifier = (TextView) itemView.findViewById(R.id.order_identifier);
            ticketCategory = (TextView) itemView.findViewById(R.id.ticket_category);
            orderDescription = (TextView) itemView.findViewById(R.id.order_description);
            noTickets = (TextView) itemView.findViewById(R.id.no_tickets);
            totalPrice = (TextView) itemView.findViewById(R.id.totalprice);
            detailsButton = (Button) itemView.findViewById(R.id.order_details);

        }

        public Button getDetailsButton() {
            return detailsButton;
        }
    }

    public OrderAdapter(List<Order> orders) {
        mOrders = orders;
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.order_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Order order = mOrders.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.orderIdentifier;
        textView.setText(order.getEventName());

        TextView textView2 = holder.orderDescription;
        textView2.setText("Number of tickets: " + order.getNumberOfTickets().toString());

        TextView textView3 = holder.noTickets;
        textView3.setText("Ordered at: " + order.getOrderedAt().toString());

        TextView textView4 = holder.totalPrice;
        textView4.setText("Total price: " + order.getTotalPrice().toString());

        TextView textView5 = holder.ticketCategory;
        textView5.setText("Ticket category: " + order.getTicketCategory());

        Button detailsButton = holder.detailsButton;
       /* detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                //startActivity(i);

                AlertDialog.Builder builder = new AlertDialog.Builder();
                builder.setCancelable(true);
                builder.setTitle("Title");
                builder.setMessage("Message");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/
        //detailsButton.setText("Show details");
        detailsButton.setEnabled(true);
    }

    @Override
    public int getItemCount() {
        return mOrders.size();
    }

    public List<Order> getmOrders() {
        return mOrders;
    }

    public void setmOrders(List<Order> mOrders) {
        this.mOrders = mOrders;
    }


}
