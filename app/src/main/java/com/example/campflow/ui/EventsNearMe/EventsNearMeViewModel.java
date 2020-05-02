package com.example.campflow.ui.EventsNearMe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EventsNearMeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EventsNearMeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is events near me fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}