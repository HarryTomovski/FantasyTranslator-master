package com.example.fantasytranslator.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fantasytranslator.Models.TranslationItem;

import java.util.List;

@Dao
public interface TranslationItemDAO {
    @Insert
    void insert(TranslationItem item);

    @Update
    void update(TranslationItem item);

    @Delete
    void delete(TranslationItem item);

    @Query("DELETE FROM translation_item_table")
    void deleteAllTranslationItems();

    @Query("SELECT * FROM translation_item_table")
    LiveData<List<TranslationItem>> getAllTranslationItems();
}
