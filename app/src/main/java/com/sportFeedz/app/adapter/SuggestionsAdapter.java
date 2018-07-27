package com.sportFeedz.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sportFeedz.app.R;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.SuggestionsViewHolder>{

    private Context mContext;

    public SuggestionsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SuggestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_suggestions, parent, false);
        return new SuggestionsViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SuggestionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTxtFollow;

        public SuggestionsViewHolder(View itemView) {
            super(itemView);
            mTxtFollow = itemView.findViewById(R.id.text_follow);
            mTxtFollow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.text_follow:
                    String text = mTxtFollow.getText().toString();
                    if (text.equals("Follow")) {
                        mTxtFollow.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_white_following));
                        mTxtFollow.setText("Following");
                        mTxtFollow.setTextColor(mContext.getResources().getColor(R.color.orange));
                        break;
                    } else {
                        mTxtFollow.setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_follow));
                        mTxtFollow.setText("Follow");
                        mTxtFollow.setTextColor(mContext.getResources().getColor(R.color.white));
                        break;
                    }

            }
        }
    }
}
