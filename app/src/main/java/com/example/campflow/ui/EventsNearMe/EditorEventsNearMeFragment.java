package com.example.campflow.ui.EventsNearMe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.campflow.JsonInterface;
import com.example.campflow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditorEventsNearMeFragment extends Fragment {

    EventsNearMeAdapter eventsNearMeAdapter;
    ArrayList<EventsNearMeClass> Events;
    EventsNearMeClass eventsNearMeClass;
    //Later,we will find a way to make key private
    String key ="";

    private JsonInterface jsonInterface;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.editor_events_near_me, container, false);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        eventsNearMeAdapter=new EventsNearMeAdapter(getContext());
        jsonInterface= retrofit.create(JsonInterface.class);
        FloatingActionButton fab = root.findViewById(R.id.save_event);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return root;
    }
    public void createdummyEvent() {
        Log.e("creteEvent","Reached here.");
        EventsNearMeClass eventsNearMeClass =new EventsNearMeClass("7","Learn Evidence-Based Mindfulness Practices in Medicine",
                "Online","Watch from home and learn mindfulness for you, your patients, and the culture of healthcare\n" +
                "The Awake Network and Mindful have partnered to create the Mindful Healthcare Summit, a 5-day FREE online event featuring 25+ leading " +
                "neuroscience researchers, mindfulness experts, and dedicated medical professionals who are making a difference in their healthcare systems, " +
                "universities, and hospitals nationwide.\nOur mission is to create a community platform of healthcare professionals exploring how individual " +
                "and organizational mindfulness and compassion and can help address the complex and systemic issues of chronic stress, overwork, burnout, and" +
                " patient safety.",
                "https://www.mindfulhealthcaresummit.com/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/sites/5/2019/05/facebook_" +
                        "share.jpg.webp","https://www.mindfulhealthcaresummit.com/","123");
        Call<EventsNearMeClass> call = jsonInterface.createEvent(key,eventsNearMeClass);
        //Log.e("creteEvent","After Call.");

        call.enqueue(new Callback<EventsNearMeClass>() {

            @Override
            public void onResponse(Call<EventsNearMeClass> call, Response<EventsNearMeClass> response) {
                if(!(response.isSuccessful())){
                    Toast.makeText(getContext(),"Sorry!!!Content Not Available.",Toast.LENGTH_SHORT).show();
                    //Log.e("OnREsponse :","Not Successfull...."+response.body());
                    return;
                }
                //Log.e("creteEvent","Before getAllEvents()");
                //Log.e("creteEvent","After getAllEvents()");
            }
            @Override
            public void onFailure(Call<EventsNearMeClass> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                //t.printStackTrace();
                //Log.e("OnFailure :",t.getMessage());

            }
        });
    }
}
