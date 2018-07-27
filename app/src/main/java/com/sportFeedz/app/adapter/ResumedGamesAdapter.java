package com.sportFeedz.app.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.MainActivity;
import com.sportFeedz.app.activity.ScoreboardActivity;
import com.sportFeedz.app.activity.StartupActivity;

import static android.content.Context.WINDOW_SERVICE;

public class ResumedGamesAdapter extends RecyclerView.Adapter<ResumedGamesAdapter.ResumedGamesViewHolder>{

    private Context mContext;
    private SwipeLayout preswipes=null;

    public ResumedGamesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ResumedGamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_resumed_games, parent, false);
        return new ResumedGamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumedGamesViewHolder holder, int position) {

        holder.mSwipeDelete.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {

                if(preswipes==null) {
                    preswipes=layout;
                }else
                {
                    preswipes.close(true);
                    preswipes=layout;
                }

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                holder.mImgDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ResumedGamesViewHolder extends RecyclerView.ViewHolder  {
        private SwipeLayout mSwipeDelete;
        private RelativeLayout mConstraintBackLayout;
        private ConstraintLayout mConstraintFrontLayout;
        private ImageView mImgDelete;
        public ResumedGamesViewHolder(View itemView) {
            super(itemView);
            mSwipeDelete = itemView.findViewById(R.id.swipeDelete);
            mConstraintBackLayout = itemView.findViewById(R.id.backLayout);
            mConstraintFrontLayout = itemView.findViewById(R.id.frontLayout);
            mImgDelete = itemView.findViewById(R.id.image_Delete);
        }

    }
}
