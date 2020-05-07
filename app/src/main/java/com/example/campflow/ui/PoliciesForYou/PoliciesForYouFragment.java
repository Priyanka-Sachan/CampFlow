package com.example.campflow.ui.PoliciesForYou;

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

public class PoliciesForYouFragment extends Fragment {

    RecyclerView recyclerView;
    PoliciesForYouAdapter policiesForYouAdapter;
    ArrayList<PoliciesForYouClass> Policies;

    private JsonInterface jsonInterface;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_policies_for_you, container, false);
        recyclerView=root.findViewById(R.id.recycler_root_policies_for_you);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        policiesForYouAdapter=new PoliciesForYouAdapter(getContext());
        jsonInterface= retrofit.create(JsonInterface.class);
        getAllPolicies();
        return root;
    }
    public void UpdateUI(ArrayList<PoliciesForYouClass> Policies) {

        if (Policies != null)
            policiesForYouAdapter = new PoliciesForYouAdapter(getContext(),Policies);
        recyclerView.setAdapter(policiesForYouAdapter);
    }
    public void getAllPolicies(){
        Call<ArrayList<PoliciesForYouClass>> call =jsonInterface.getPolicies();
        call.enqueue(new Callback<ArrayList<PoliciesForYouClass>>() {

            @Override
            public void onResponse(Call<ArrayList<PoliciesForYouClass>> call, Response<ArrayList<PoliciesForYouClass>> response) {
                if(!(response.isSuccessful())){
                    Toast.makeText(getContext(),"Sorry!!!Content Not Available.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Policies =response.body();
                UpdateUI(Policies);
            }

            @Override
            public void onFailure(Call<ArrayList<PoliciesForYouClass>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}