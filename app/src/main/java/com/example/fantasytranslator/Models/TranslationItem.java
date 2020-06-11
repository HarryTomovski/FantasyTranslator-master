package com.example.fantasytranslator.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "translation_item_table")
public class TranslationItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String translation;
    private int imageId;

    public TranslationItem(String translation, int imageId) {
        this.translation = translation;
        this.imageId = imageId;
    }

    public String getTranslation() {
        return translation;
    }

    public int getImageId() {
        return imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
