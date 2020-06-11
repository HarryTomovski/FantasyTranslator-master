package com.example.fantasytranslator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fantasytranslator.Models.TranslationItem;

import java.util.ArrayList;
import java.util.List;

public class TranslationAdapter extends RecyclerView.Adapter<TranslationAdapter.ItemHolder> {

    List<TranslationItem> translations = new ArrayList<>();


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.translation_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.language.setText(translations.get(position).getTranslation());
        holder.image.setImageResource(translations.get(position).getImageId());
       /* imageId's would be a few and  they would repeat for the most popular choices: Sith, dothraki, elvish
       * the rest would be the a general picture*/
    }

    @Override
    public int getItemCount() {
        return translations.size();
    }

    public void setTranslationItems(List<TranslationItem> items)
    {
        this.translations = items;
        notifyDataSetChanged();
    }


    class ItemHolder extends RecyclerView.ViewHolder {
        TextView language;
        ImageView image;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            language=itemView.findViewById(R.id.language_rv);
            image=itemView.findViewById(R.id.image_rv);
        }
    }
}
