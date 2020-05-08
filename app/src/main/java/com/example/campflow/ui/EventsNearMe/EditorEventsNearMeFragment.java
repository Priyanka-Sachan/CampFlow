package com.example.campflow.ui.EventsNearMe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.campflow.JsonInterface;
import com.example.campflow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditorEventsNearMeFragment extends Fragment {

    EventsNearMeAdapter eventsNearMeAdapter;

    EventsNearMeClass event;

    private JsonInterface jsonInterface;

    //Later,key would be made more private
    String key;

    private EditText EventId;
    private EditText EventHead;
    private EditText EventLocation;
    private EditText EventDescription;
    private EditText EventImage;
    private EditText EventWeb;
    private EditText EventInterested;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_editor_events_near_me, container, false);
        EventId=(EditText)root.findViewById(R.id.edit_event_id);
        EventHead=(EditText)root.findViewById(R.id.edit_event_head);
        EventLocation=(EditText)root.findViewById(R.id.edit_event_location);
        EventDescription=(EditText)root.findViewById(R.id.edit_event_description);
        EventImage=(EditText)root.findViewById(R.id.edit_event_image);
        EventWeb=(EditText)root.findViewById(R.id.edit_event_web);
        EventInterested=(EditText)root.findViewById(R.id.edit_event_interested);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventsNearMeAdapter=new EventsNearMeAdapter(getContext());

        jsonInterface= retrofit.create(JsonInterface.class);

        FloatingActionButton save =root.findViewById(R.id.save_event);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event=new EventsNearMeClass(EventId.getText().toString(),EventHead.getText().toString(),
                 EventLocation.getText().toString(),EventDescription.getText().toString(),EventImage.getText().toString()
                  ,EventWeb.getText().toString(),EventInterested.getText().toString());
                createEvent(event);
            }
        });
        return root;
    }
    public void createEvent(EventsNearMeClass eventsNearMeClass) {
        //Log.e("creteEvent","Reached here.");
        Call<EventsNearMeClass> call = jsonInterface.createEvent(key,eventsNearMeClass);
        //Log.e("creteEvent","After Call.");

        call.enqueue(new Callback<EventsNearMeClass>() {

            @Override
            public void onResponse(Call<EventsNearMeClass> call, Response<EventsNearMeClass> response) {
                if(!(response.isSuccessful())){
                    Toast.makeText(getContext(),"Sorry!!!Content Not Available.",Toast.LENGTH_SHORT).show();
                    //Log.e("OnResponse :","Not Successful...."+response.body());
                    BackToHome();
                }
                //Log.e("createEvent","Before intent");
                BackToHome();
                //Log.e("createEvent","After intent");
            }
            @Override
            public void onFailure(Call<EventsNearMeClass> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                //t.printStackTrace();
                //Log.e("OnFailure :",t.getMessage());

            }
        });

    }
    public void BackToHome() {
        //getParentFragmentManager() is used since getFragmentManager() got deprecated.
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventsNearMeFragment eventsNearMeFragment = new EventsNearMeFragment();
        fragmentTransaction.replace(R.id.nav_host_fragment, eventsNearMeFragment);
        fragmentTransaction.commit();
    }
}
