package com.example.fantasytranslator.API;

import com.example.fantasytranslator.Models.Translation;

import java.io.Serializable;

public class TranslationResponse implements Serializable {
    private Contents contents;

    public Translation getTranslation()
    {
        return new Translation(contents.translated,contents.text,contents.translation);
    }

    private class Contents
    {
        private String translated;
        private String text;
        //Language
        private String translation;
    }
}
