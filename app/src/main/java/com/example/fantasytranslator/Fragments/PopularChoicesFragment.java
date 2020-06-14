package com.example.fantasytranslator.Fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasytranslator.Models.TranslationItem;
import com.example.fantasytranslator.R;
import com.example.fantasytranslator.TranslationAdapter;

import com.example.fantasytranslator.ViewModels.TranslationItemViewModel;

import java.util.List;

public class PopularChoicesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TranslationItemViewModel itemViewModel;

    private List<TranslationItem>  list;
    private TranslationAdapter adapter;



    public static PopularChoicesFragment newInstance()
    {
        return new PopularChoicesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_choices_fragment,container,false);
        recyclerView=view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        itemViewModel=new ViewModelProvider(this).get(TranslationItemViewModel.class);


        adapter = new TranslationAdapter();
        recyclerView.setAdapter(adapter);

        itemViewModel.getAllTranslationItems().observe(getViewLifecycleOwner(), new Observer<List<TranslationItem>>() {
            @Override
            public void onChanged(List<TranslationItem> translationItems) {
                adapter.setTranslationItems(translationItems);
        }
        });




        //Get a list from the db and give it to the adapter

        return view;
    }
}
