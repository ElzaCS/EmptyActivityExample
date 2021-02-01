package com.example.emptyactivityexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LangaugeAdapter extends RecyclerView.Adapter<LangaugeAdapter.LanguageViewHolder>{
    String[] mLanguages;
    public LangaugeAdapter(String[] mLanguages){
        this.mLanguages = mLanguages;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View languageView = inflater.inflate(R.layout.language_item, parent, false);
        LanguageViewHolder viewHolder = new LanguageViewHolder(languageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        String currentLanguage = mLanguages[position];
        holder.txtLanguage.setText(currentLanguage);
    }

    @Override
    public int getItemCount() {
        return mLanguages.length;
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder{
        TextView txtLanguage;
        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLanguage = itemView.findViewById(R.id.txt_language);
        }
    }
}
