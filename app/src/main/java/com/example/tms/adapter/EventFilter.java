package com.example.tms.adapter;

import android.widget.Filter;

import com.example.tms.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventFilter extends Filter {
    private List<Event> eventList;
    private List<Event> filteredEventList;
    private EventAdapter adapter;

    public EventFilter(List<Event> eventList, EventAdapter adapter) {
        this.adapter = adapter;
        this.eventList = eventList;
        this.filteredEventList = new ArrayList();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredEventList.clear();
        final FilterResults results = new FilterResults();


        for (final Event item : eventList) {
            if (item.getEventName().toLowerCase().trim().contains(constraint)) {
                filteredEventList.add(item);
            }
        }

        results.values = filteredEventList;
        results.count = filteredEventList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.setmEvents(filteredEventList);
        adapter.notifyDataSetChanged();
    }
}
