package com.example.campflow.ui.JoinUs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JoinUsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JoinUsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is join us fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}