package com.example.fantasytranslator.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fantasytranslator.Models.TranslationItem;
import com.example.fantasytranslator.Repositories.TranslationItemRepository;

import java.util.List;

public class TranslationItemViewModel extends AndroidViewModel {

    private TranslationItemRepository repository;
    private LiveData<List<TranslationItem>> allItems;
    public TranslationItemViewModel(@NonNull Application application) {
        super(application);
        repository = new TranslationItemRepository(application);
        allItems=repository.getAllTranslationItems();
//                getInstance(application);
    }

    public void insert(TranslationItem item) {
        repository.insertTranslationItem(item);
    }

    public void delete(TranslationItem item) {
        repository.deleteTranslationItem(item);
    }

    public LiveData<List<TranslationItem>> getAllTranslationItems() {
        return allItems;
    }

    public void deleteAllItems() {
        repository.deleteAllTranslationItem();
    }
}
