package com.example.campflow;

import com.example.campflow.ui.EventsNearMe.EventsNearMeClass;
import com.example.campflow.ui.PoliciesForYou.PoliciesForYouClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonInterface {

    @GET("b/5eb4039047a2266b14745cf7")
    Call<ArrayList<EventsNearMeClass>> getEvents();

    @GET("b/5eb433aaa47fdd6af15f3873")
    Call<ArrayList<PoliciesForYouClass>> getPolicies();

}
