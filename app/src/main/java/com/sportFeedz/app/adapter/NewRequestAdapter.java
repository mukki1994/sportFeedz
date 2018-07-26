package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class NewRequestAdapter extends RecyclerView.Adapter<NewRequestAdapter.NewRequestViewHolder>{

    private Context mContext;

    public NewRequestAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NewRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_new_requests, parent, false);
        return new NewRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRequestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class NewRequestViewHolder extends RecyclerView.ViewHolder {
        public NewRequestViewHolder(View itemView) {
            super(itemView);
        }
    }
}
