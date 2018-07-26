package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder> {

    private Context mContext;

    public FollowingAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FollowingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_following, parent, false);
        return new FollowingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class FollowingViewHolder extends RecyclerView.ViewHolder {
        public FollowingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
