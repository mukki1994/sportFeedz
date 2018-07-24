package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class PlayersUpdationAdapter extends RecyclerView.Adapter<PlayersUpdationAdapter.PlayersUpdationViewHolder>{

    private Context mContext;

    public PlayersUpdationAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PlayersUpdationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_updation_players, parent, false);
        return new PlayersUpdationViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull PlayersUpdationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class PlayersUpdationViewHolder extends RecyclerView.ViewHolder {
        public PlayersUpdationViewHolder(View itemView) {
            super(itemView);
        }
    }
}
