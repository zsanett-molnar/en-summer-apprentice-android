package com.example.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.R;
import com.example.tms.model.Event;

import java.util.List;
import java.util.Locale;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> mEvents;
    EventFilter filter;
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public ImageView event_image;
        public TextView nameTextView;
        public TextView descriptionTextView;

        public Button detailsButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.event_name);
            descriptionTextView = (TextView) itemView.findViewById(R.id.event_description);
            detailsButton = (Button) itemView.findViewById(R.id.event_details);
            event_image = (ImageView) itemView.findViewById(R.id.event_image);

        }
    }



    // Pass in the contact array into the constructor
    public EventAdapter(List<Event> events) {
        mEvents = events;
        filter = new EventFilter(mEvents, this);
    }
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.event_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Event event = mEvents.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(event.getEventName());

        TextView textView2 = holder.descriptionTextView;
        textView2.setText("Event type: "+event.getEventTypeName());

        ImageView img = holder.event_image;
        img.setImageResource(event.getImageID());

        Button detailsButton = holder.detailsButton;
        detailsButton.setText("Show details");
        detailsButton.setEnabled(true);
    }

    public void filterList(String text) {
        filter.filter(text);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public void setmEvents(List<Event> mEvents) {
        this.mEvents = mEvents;
    }
}
