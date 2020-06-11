package com.example.fantasytranslator.Models;

public class Translation {
    private String translated;
    private String text;
    //Language
    private String translation;


    public Translation(String translated, String text, String translation) {
        this.text = text;
        this.translated = translated;
        this.translation = translation;
    }

    public String getText() {
        return text;
    }

    public String getTranslated() {
        return translated;
    }

    public String getTranslation() {
        return translation;
    }

}
