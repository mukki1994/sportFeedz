package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class SearchFollowPlayersAdapter extends RecyclerView.Adapter<SearchFollowPlayersAdapter.SearchFollowPlayersViewHolder>{

    private Context mContext;

    public SearchFollowPlayersAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SearchFollowPlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_follow_layers, parent, false);
        return new SearchFollowPlayersViewHolder(view);     }

    @Override
    public void onBindViewHolder(@NonNull SearchFollowPlayersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SearchFollowPlayersViewHolder extends RecyclerView.ViewHolder {
        public SearchFollowPlayersViewHolder(View itemView) {
            super(itemView);
        }
    }

}
