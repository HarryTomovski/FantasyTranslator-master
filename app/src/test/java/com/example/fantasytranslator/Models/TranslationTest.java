package com.example.fantasytranslator.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslationTest {

    private Translation translation;
    @Before
    public void setUp() {
        translation= new Translation("Sky in dothraki","sky","dothraki");
    }

    @Test
    public void getText() {
        String text = translation.getText();
        assertEquals(text,"sky");
    }

    @Test
    public void getTranslated() {
        String translated = translation.getTranslated();
        assertEquals(translated,"Sky in dothraki");
    }

    @Test
    public void getTranslation() {
        String tempTranslation = translation.getTranslation();
        assertEquals(tempTranslation,"dothraki");
    }
}