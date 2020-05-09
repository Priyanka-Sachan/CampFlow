package com.example.campflow.ui.ContactUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.campflow.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ContactUsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);
        AppCompatActivity appCompatActivity=(AppCompatActivity)getActivity();
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) appCompatActivity.findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Contact Us");
        collapsingToolbarLayout.setBackgroundResource(R.drawable.contact_us_appbar);
        return root;
    }
}