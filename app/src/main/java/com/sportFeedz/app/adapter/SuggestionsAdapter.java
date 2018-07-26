package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.SuggestionsViewHolder>{

    private Context mContext;

    public SuggestionsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SuggestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_suggestions, parent, false);
        return new SuggestionsViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SuggestionsViewHolder extends RecyclerView.ViewHolder {
        public SuggestionsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
