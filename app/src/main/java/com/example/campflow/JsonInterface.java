package com.example.campflow;

import com.example.campflow.ui.EventsNearMe.EventsNearMeClass;
import com.example.campflow.ui.PoliciesForYou.PoliciesForYouClass;
import com.example.campflow.ui.Posts.PostsClass;

import java.util.ArrayList;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JsonInterface {

    @GET("b/5eb8e675a47fdd6af161335f")
    Call<ArrayList<EventsNearMeClass>> getEvents();

    @Headers({"Content-Type:application/json","private:false"})
    @PUT("b/5eb8e675a47fdd6af161335f")
    Call<ResponseBody> createEvent(@Header ("secret-key") String keyHeader, @Body RequestBody requestBody);

    @GET("b/5eb433aaa47fdd6af15f3873")
    Call<ArrayList<PoliciesForYouClass>> getPolicies();

    @GET("b/5eb4411b47a2266b14747ceb")
    Call<ArrayList<PostsClass>> getPosts();

}
