package com.example.fantasytranslator.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.fantasytranslator.DAO.TranslationItemDAO;
import com.example.fantasytranslator.DAO.TranslationItemDatabase;
import com.example.fantasytranslator.Models.TranslationItem;

import java.util.List;

public class TranslationItemRepository {
    private TranslationItemDAO translationItemDAO;
    //private static TranslationItemRepository instance;
    private LiveData<List<TranslationItem>> translationItems;

    public TranslationItemRepository(Application application)
    {
        TranslationItemDatabase translationItemDatabase= TranslationItemDatabase.getInstance(application);
        translationItemDAO=translationItemDatabase.dao();
        translationItems = translationItemDAO.getAllTranslationItems();
    }

    public LiveData<List<TranslationItem>> getAllTranslationItems()
    {
        return translationItems;
    }

    public void insertTranslationItem(TranslationItem item)
    {
        new InsertItemAsync(translationItemDAO).execute(item);
    }

    public void deleteTranslationItem(TranslationItem item)
    {
        new DeleteItemAsync(translationItemDAO).execute(item);

    }

    public void deleteAllTranslationItem()
    {
        new DeleteAllItemAsync(translationItemDAO).execute();

    }

    private static class InsertItemAsync extends AsyncTask<TranslationItem,Void,Void> {
        private TranslationItemDAO translationDAO;

        private InsertItemAsync(TranslationItemDAO translationItemDAO)
        {
            this.translationDAO=translationItemDAO;
        }
        @Override
        protected Void doInBackground(TranslationItem... items) {
            translationDAO.insert(items[0]);
            System.out.println("We've reached the insert............." + items[0].getTranslation());
            return null;
        }
    }

    private static class DeleteItemAsync extends AsyncTask<TranslationItem,Void,Void>{
        private TranslationItemDAO translationDAO;
        private DeleteItemAsync(TranslationItemDAO translationItemDAO)
        {
            this.translationDAO=translationItemDAO;
        }
        @Override
        protected Void doInBackground(TranslationItem... items) {
            translationDAO.delete(items[0]);
            return null;
        }
    }

    private static class DeleteAllItemAsync extends AsyncTask<Void,Void,Void>{
        private TranslationItemDAO translationDAO;
        private DeleteAllItemAsync(TranslationItemDAO translationItemDAO)
        {
            this.translationDAO=translationItemDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            translationDAO.deleteAllTranslationItems();
            return null;
        }
    }
}
