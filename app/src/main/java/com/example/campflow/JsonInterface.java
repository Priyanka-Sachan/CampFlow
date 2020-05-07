package com.example.campflow;

import com.example.campflow.ui.EventsNearMe.EventsNearMeClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonInterface {

    @GET("b/5eb4039047a2266b14745cf7")
    Call<ArrayList<EventsNearMeClass>> getEvents();

}
