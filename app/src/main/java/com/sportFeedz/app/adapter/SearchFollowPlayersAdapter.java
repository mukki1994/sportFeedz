package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return new SearchFollowPlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFollowPlayersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SearchFollowPlayersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTxtFollow;

        public SearchFollowPlayersViewHolder(View itemView) {
            super(itemView);
            mTxtFollow = itemView.findViewById(R.id.text_follow);
            mTxtFollow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.text_follow:
                    String text = mTxtFollow.getText().toString();
                    if (text.equals("Follow")){
                        mTxtFollow.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_following));
                        mTxtFollow.setText("Following");
                        break;
                    }else {
                        mTxtFollow.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_follow));
                        mTxtFollow.setText("Follow");
                        break;
                    }

            }
        }
    }

}
