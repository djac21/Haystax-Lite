package com.djac21.haystax.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.djac21.haystax.activities.IncidentsListActivity;

public class IncidentListViewModel extends ViewModel {

    private MutableLiveData<IncidentsListModel> mutableLiveData;

    public void init(String cookies) {
        if (mutableLiveData != null)
            return;

        mutableLiveData = new IncidentsListActivity().getNews(cookies);
    }

    public LiveData<IncidentsListModel> getIncidentsRepository() {
        return mutableLiveData;
    }
}