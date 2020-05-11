package com.example.campflow.ui.EventsNearMe;

import android.os.Bundle;
import android.util.ArrayMap;
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

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
    String key="$2b$10$SyqurjWi0MDaL0ag302at.kUAcYH5zWnZPz51p2QVFGUAkViZpbxm";

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

        //Using fake Rest API,hence data sent in JSON format.
        Map<String,Object> jsonParams = new ArrayMap<>();
        jsonParams.put("event_id", eventsNearMeClass.getEvent_id());
        jsonParams.put("event_head",eventsNearMeClass.getEvent_head());
        jsonParams.put("event_location",eventsNearMeClass.getEvent_location());
        jsonParams.put("event_description",eventsNearMeClass.getEvent_description());
        jsonParams.put("event_image",eventsNearMeClass.getEvent_image());
        jsonParams.put("event_web",eventsNearMeClass.getEvent_web());
        jsonParams.put("event_interested",eventsNearMeClass.getEvent_interested());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());
        Log.e("Json Created",new JSONObject(jsonParams).toString());

        Call<ResponseBody> response = jsonInterface.createEvent(key, body);
        response.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                try
                {
                    BackToHome();
                    Log.e("OnResponse", "RetroFit2.0 :RetroGetLogin: " + rawResponse.body().string());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    BackToHome();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                Log.e("OnFailure :",t.getMessage());

            }
        });

    }
    public void BackToHome() {
        //getParentFragmentManager() is used since getFragmentManager() got deprecated.
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventsNearMeFragment eventsNearMeFragment = new EventsNearMeFragment();
        fragmentTransaction.replace(R.id.nav_host_fragment, eventsNearMeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
