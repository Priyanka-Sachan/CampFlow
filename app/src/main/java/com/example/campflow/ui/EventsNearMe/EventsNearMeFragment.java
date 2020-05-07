package com.example.campflow.ui.EventsNearMe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campflow.R;

import java.util.ArrayList;

public class EventsNearMeFragment extends Fragment {

    RecyclerView recyclerView;
    EventsNearMeAdapter eventsNearMeAdapter;
    ArrayList<EventsNearMeClass> Events;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_events_near_me, container, false);
        recyclerView=root.findViewById(R.id.recycler_root_events_near_me);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        eventsNearMeAdapter = new EventsNearMeAdapter(getContext());
        return root;
    }
}