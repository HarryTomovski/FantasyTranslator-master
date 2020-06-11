package com.example.fantasytranslator.DAO;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.fantasytranslator.Models.TranslationItem;
import com.example.fantasytranslator.R;

@Database(entities = {TranslationItem.class}, version = 1)
public abstract class TranslationItemDatabase extends RoomDatabase {
    private static TranslationItemDatabase instance;
    public abstract TranslationItemDAO dao();

    public static synchronized TranslationItemDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    TranslationItemDatabase.class,"TranslationItemDB").fallbackToDestructiveMigration().addCallback(callback).allowMainThreadQueries().build();
        }
        return instance;
    }
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance).execute();
        }
    };
    private static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private TranslationItemDAO dao;
        private PopulateAsyncTask(TranslationItemDatabase db)
        {
            dao=db.dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {

          dao.insert(new TranslationItem("sith", R.drawable.sith));

            return null;
        }
    }
}