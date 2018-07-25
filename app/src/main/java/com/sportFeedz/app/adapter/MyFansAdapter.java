package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;

public class MyFansAdapter extends RecyclerView.Adapter<MyFansAdapter.MyFansViewHolder>{

    private Context mContext;

    public MyFansAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyFansViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_my_fans, parent, false);
        return new MyFansViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyFansViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MyFansViewHolder extends RecyclerView.ViewHolder {
        public MyFansViewHolder(View itemView) {
            super(itemView);
        }
    }
}
