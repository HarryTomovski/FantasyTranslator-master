package com.example.fantasytranslator.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslationItemTest {

    private TranslationItem translationItem;
    private int id;

    @Before
    public void setUp()
    {
        translationItem = new TranslationItem("Sith",1);
        translationItem.setId(2);
    }


    @Test
    public void getTranslation() {
        String translation = translationItem.getTranslation();
        assertEquals(translation,"Sith");
    }

    @Test
    public void getImageId() {
        int tempId = translationItem.getImageId();
        assertEquals(tempId,1);
    }

    @Test
    public void getId() {
        int id =translationItem.getId();
        assertEquals(id,2);
    }

    @Test
    public void setId() {
        translationItem.setId(3);
        int TId = translationItem.getId();
        assertEquals(TId,3);
    }
}