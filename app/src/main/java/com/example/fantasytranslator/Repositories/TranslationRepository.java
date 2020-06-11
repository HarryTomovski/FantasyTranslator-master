package com.example.fantasytranslator.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fantasytranslator.API.ServiceGenerator;
import com.example.fantasytranslator.Models.Translation;
import com.example.fantasytranslator.API.TranslationApi;
import com.example.fantasytranslator.API.TranslationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslationRepository {
    private static TranslationRepository instance;
    private MutableLiveData<Translation> mutableLiveData;

    private TranslationRepository()
    {
        mutableLiveData = new MutableLiveData<>();
    }
    public static synchronized TranslationRepository getInstance()
    {
        if (instance==null)
        {
            instance = new TranslationRepository();
        }
        return instance;
    }
    public LiveData<Translation> getMutableLiveData()
    {
        return mutableLiveData;
    }
    public void requestTranslation(final String translation, String  text)
    {
        TranslationApi translationApi = ServiceGenerator.getTranslationApi();
        Call<TranslationResponse> call = translationApi.getTranslation(translation, text);
        System.out.println("Request goes like skraaa :" + call.request().toString());
        call.enqueue(new Callback<TranslationResponse>() {
            @Override
            public void onResponse(Call<TranslationResponse> call, Response<TranslationResponse> response) {
                if (response.code()==200)
                {
                    System.out.println("Response code:" + response.code());
                    mutableLiveData.setValue(response.body().getTranslation());
                    System.out.println("Method has been called 200");
                    Log.i("Retrofit","We reached this point");
                }
                else if (response.code()==429)
                {
                    System.out.println("too many request have been send to the api, wait for an hour!");
                }

            }

            @Override
            public void onFailure(Call<TranslationResponse> call, Throwable t) {
                System.out.println("No success, try not to cry" + t.getMessage());

                Log.i("Retrofit","An Error occurred!"+ t.getCause());

            }
        });
    }

}

