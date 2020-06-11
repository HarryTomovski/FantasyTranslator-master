package com.example.fantasytranslator.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentCommunicationViewModel extends ViewModel {

    private static FragmentCommunicationViewModel instance;

    public static synchronized FragmentCommunicationViewModel getInstance()
    {
        if (instance==null)
        {
            instance = new FragmentCommunicationViewModel();
        }
        return instance;
    }

    public MutableLiveData<String> language;
    public FragmentCommunicationViewModel() {
        language = new MutableLiveData<>();
    }

    public LiveData<String> getLanguage() {
        System.out.println("In getLanguage CommunicatinViewHolder");
        return language;
    }

    public void setLanguage(String language) {
        System.out.println("Setting language in communicationViewHolder");
        this.language.setValue(language);
        System.out.println(language);
    }


}
