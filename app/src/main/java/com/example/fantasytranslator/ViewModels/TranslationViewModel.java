package com.example.fantasytranslator.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fantasytranslator.Models.Translation;
import com.example.fantasytranslator.Repositories.TranslationRepository;

public class TranslationViewModel extends ViewModel {
    private TranslationRepository repository;
    public TranslationViewModel()
    {
        repository= TranslationRepository.getInstance();
    }
    public LiveData<Translation> getTranslation()
    {
        return repository.getMutableLiveData();
    }
    public void requestTranslation(String translation,String text)
    {
        repository.requestTranslation(translation, text);
    }
}
