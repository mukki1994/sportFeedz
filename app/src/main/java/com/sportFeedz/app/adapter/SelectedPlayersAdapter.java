package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class SelectedPlayersAdapter extends RecyclerView.Adapter<SelectedPlayersAdapter.SelectedPlayersViewHolder>{
    private Context mContext;

    public SelectedPlayersAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SelectedPlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_select_players, parent, false);
        return new SelectedPlayersViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull SelectedPlayersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class SelectedPlayersViewHolder extends RecyclerView.ViewHolder {
        public SelectedPlayersViewHolder(View itemView) {
            super(itemView);
        }
    }
}
