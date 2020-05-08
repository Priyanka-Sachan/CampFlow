package com.example.campflow.ui.EventsNearMe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campflow.JsonInterface;
import com.example.campflow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsNearMeFragment extends Fragment {

    RecyclerView recyclerView;
    EventsNearMeAdapter eventsNearMeAdapter;
    ArrayList<EventsNearMeClass> Events;

    private JsonInterface jsonInterface;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_events_near_me, container, false);
        recyclerView=root.findViewById(R.id.recycler_root_events_near_me);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        eventsNearMeAdapter=new EventsNearMeAdapter(getContext());
        jsonInterface= retrofit.create(JsonInterface.class);
        getAllEvents();
        FloatingActionButton editEvent=root.findViewById(R.id.edit_event);
        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                EditorEventsNearMeFragment editorEventsNearMeFragment = new EditorEventsNearMeFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, editorEventsNearMeFragment);
                fragmentTransaction.commit();
            }
        });        return root;
    }

    public void UpdateUI(ArrayList<EventsNearMeClass> Events) {

        if (Events != null)
            eventsNearMeAdapter = new EventsNearMeAdapter(getContext(),Events);
        recyclerView.setAdapter(eventsNearMeAdapter);
    }
        public void getAllEvents(){
        Call<ArrayList<EventsNearMeClass>> call =jsonInterface.getEvents();
        call.enqueue(new Callback<ArrayList<EventsNearMeClass>>() {

            @Override
            public void onResponse(Call<ArrayList<EventsNearMeClass>> call, Response<ArrayList<EventsNearMeClass>> response) {
                if(!(response.isSuccessful())){
                    Toast.makeText(getContext(),"Sorry!!!Content Not Available.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Events =response.body();
                UpdateUI(Events);
            }

            @Override
            public void onFailure(Call<ArrayList<EventsNearMeClass>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}