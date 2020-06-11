package com.example.fantasytranslator.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.funtranslations.com/translate/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static TranslationApi translationApi = retrofit.create(TranslationApi.class);

    public static TranslationApi getTranslationApi()
    {
        return translationApi;
    }

}
