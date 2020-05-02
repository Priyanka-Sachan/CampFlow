package com.example.campflow.ui.PoliciesForYou;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PoliciesForYouViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PoliciesForYouViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is policies for you fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}