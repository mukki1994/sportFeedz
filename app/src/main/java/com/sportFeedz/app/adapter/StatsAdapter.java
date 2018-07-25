package com.sportFeedz.app.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sportFeedz.app.R;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.StatsViewHolder>{

    private Context mContext;

    public StatsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public StatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_stats, parent, false);
        return new StatsViewHolder(view);     }

    @Override
    public void onBindViewHolder(@NonNull StatsViewHolder holder, int position) {
        holder.setSpannable();
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class StatsViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtUserPoints;
        public StatsViewHolder(View itemView) {
            super(itemView);
            mTxtUserPoints = itemView.findViewById(R.id.text_about_points);
        }
        public void setSpannable(){
            SpannableString spannableString = new SpannableString(mContext.getString(R.string.gurdeep_just_scored_a_point));
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 7, 0);
            mTxtUserPoints.setText(spannableString);
        }
    }
}
