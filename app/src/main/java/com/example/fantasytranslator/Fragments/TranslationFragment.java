package com.example.fantasytranslator.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fantasytranslator.Models.Translation;
import com.example.fantasytranslator.Models.TranslationItem;
import com.example.fantasytranslator.R;
import com.example.fantasytranslator.ViewModels.FragmentCommunicationViewModel;
import com.example.fantasytranslator.ViewModels.TranslationItemViewModel;
import com.example.fantasytranslator.ViewModels.TranslationViewModel;


public class TranslationFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText toBeTranslated;
    private TextView translationTextView;
    private EditText language;

    private TranslationViewModel translationViewModel;
    private TranslationItemViewModel itemViewModel;


    public static TranslationFragment newInstance()
    {
        TranslationFragment fragment =  new TranslationFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.translator_fragment, container, false);
        toBeTranslated = view.findViewById(R.id.toBeTranslated);
        translationTextView = view.findViewById(R.id.translation);
        language=view.findViewById(R.id.language);

        itemViewModel = new ViewModelProvider(this).get(TranslationItemViewModel.class);

        translationViewModel = new  ViewModelProvider(this).get(TranslationViewModel.class);
        translationViewModel.getTranslation().observe(getViewLifecycleOwner(), new Observer<Translation>() {
            @Override
            public void onChanged(Translation translation) {

                translationTextView.setText("");
                translationTextView.setText(translation.getTranslated());
            }
        });

        ImageButton translationButton= view.findViewById(R.id.translateButton);
        translationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Language: "+language.getText().toString() +"Sentance: "+ toBeTranslated.getText().toString());
                translationViewModel.requestTranslation(language.getText().toString(),toBeTranslated.getText().toString());
            }
        });
        Button addToFavouritesButton=view.findViewById(R.id.addToFavourites);
        addToFavouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = (language.getText().toString().trim());

                int imageId=0;
                switch (s)
                {
                    case "sith":
                        imageId=R.drawable.sith;
                        break;
                    case "dothraki":
                        imageId=R.drawable.snoopkhaleesi;
                        break;
                    case "sindarin":
                        imageId=R.drawable.sindarin;
                        break;
                    default:
                        imageId=R.drawable.mr_worldwide;
                        break;
                }

                itemViewModel.insert(new TranslationItem(s,imageId));
            }
    });
        return view;
    }




}
