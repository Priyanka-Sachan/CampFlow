package com.example.campflow;

import com.example.campflow.ui.EventsNearMe.EventsNearMeClass;
import com.example.campflow.ui.PoliciesForYou.PoliciesForYouClass;
import com.example.campflow.ui.Posts.PostsClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonInterface {

    @GET("b/5eb4039047a2266b14745cf7")
    Call<ArrayList<EventsNearMeClass>> getEvents();

    @Headers({"Content-Type:application/json","private:false"})
    @POST("b/5eb4039047a2266b14745cf7")
    Call<EventsNearMeClass> createEvent(@Header ("secret-key") String keyHeader,@Body EventsNearMeClass eventsNearMeClass);

    @GET("b/5eb433aaa47fdd6af15f3873")
    Call<ArrayList<PoliciesForYouClass>> getPolicies();

    @GET("b/5eb4411b47a2266b14747ceb")
    Call<ArrayList<PostsClass>> getPosts();

}
