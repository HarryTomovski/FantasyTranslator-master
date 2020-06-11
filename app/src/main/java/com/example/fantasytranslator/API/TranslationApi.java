package com.example.fantasytranslator.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TranslationApi {
    @GET("{translation}.json")
    Call<TranslationResponse> getTranslation(@Path("translation") String translation, @Query("text") String text);
}

