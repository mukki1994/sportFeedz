package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class LimitedUserAdapter extends RecyclerView.Adapter<LimitedUserAdapter.LimitedUserViewHolder> {
    private Context mContext;

    public LimitedUserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LimitedUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_limited_user, parent, false);
        return new LimitedUserViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull LimitedUserViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class LimitedUserViewHolder extends RecyclerView.ViewHolder {
        public LimitedUserViewHolder(View itemView) {
            super(itemView);
        }
    }
}
