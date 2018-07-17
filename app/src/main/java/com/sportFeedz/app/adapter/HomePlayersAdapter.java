package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class HomePlayersAdapter extends RecyclerView.Adapter<HomePlayersAdapter.HomePlayersViewHolder> {

    private Context mContext;

    public HomePlayersAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomePlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_players_list, parent, false);
        return new HomePlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePlayersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class HomePlayersViewHolder extends RecyclerView.ViewHolder {
        public HomePlayersViewHolder(View itemView) {
            super(itemView);
        }
    }
}
