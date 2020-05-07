package com.example.campflow.ui.Posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campflow.JsonInterface;
import com.example.campflow.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsFragment extends Fragment {

    RecyclerView recyclerView;
    PostsAdapter postsAdapter;
    ArrayList<PostsClass> Posts;

    private JsonInterface jsonInterface;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);
        recyclerView=root.findViewById(R.id.recycler_root_posts);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postsAdapter=new PostsAdapter(getContext());
        jsonInterface= retrofit.create(JsonInterface.class);
        getAllPosts();
        return root;
    }

    public void UpdateUI(ArrayList<PostsClass> Posts) {

        if (Posts != null)
            postsAdapter = new PostsAdapter(getContext(),Posts);
        recyclerView.setAdapter(postsAdapter);
    }
    public void getAllPosts(){
        Call<ArrayList<PostsClass>> call =jsonInterface.getPosts();
        call.enqueue(new Callback<ArrayList<PostsClass>>() {

            @Override
            public void onResponse(Call<ArrayList<PostsClass>> call, Response<ArrayList<PostsClass>> response) {
                if(!(response.isSuccessful())){
                    Toast.makeText(getContext(),"Sorry!!!Content Not Available.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Posts =response.body();
                UpdateUI(Posts);
            }

            @Override
            public void onFailure(Call<ArrayList<PostsClass>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}