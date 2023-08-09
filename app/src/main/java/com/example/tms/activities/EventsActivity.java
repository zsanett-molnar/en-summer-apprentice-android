package com.example.tms.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.tms.R;
import com.example.tms.adapter.EventAdapter;
import com.example.tms.model.Event;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        SearchView search = (SearchView) findViewById(R.id.simpleSearchView);


        List<Event> events = getEvents();
        EventAdapter adapter = new EventAdapter(events);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filterList(newText);
                return false;
            }
        });

    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(R.drawable.untold_icon,"Music", "Muzica faina", "Untold", null, null ));
        events.add(new Event(R.drawable.ec,"Music", "Festival la castel", "Electric castle", null, null ));
        events.add(new Event(R.drawable.neversea2,"Music", "Festival la mare", "Neversea", null, null ));
        events.add(new Event(R.drawable.wine,"Drinks", "Gustari de vin", "Wine Festival", null, null ));
        events.add(new Event(R.drawable.football,"Sport", "Friendly match", "Football match", null, null ));
        return events;
    }
}