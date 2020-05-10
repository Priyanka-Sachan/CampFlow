package com.example.campflow.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.campflow.R;

public class LogCoverFragment extends Fragment {
    Button SignIn;
    Button SignUp;
    Button Register;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_log_cover, container, false);

        SignIn=(Button)root.findViewById(R.id.sign_in_button);
        SignUp=(Button)root.findViewById(R.id.sign_up_button);
        Register=(Button)root.findViewById(R.id.register_button);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                SignInFragment signinfragment=new SignInFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, signinfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }});

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                SignUpFragment signupfragment=new SignUpFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, signupfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }});

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                RegisterFragment registerfragment=new RegisterFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, registerfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }});
        return root;
    }
}
