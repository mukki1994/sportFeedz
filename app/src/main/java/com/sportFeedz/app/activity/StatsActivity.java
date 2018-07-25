package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.ResumedGamesAdapter;
import com.sportFeedz.app.adapter.StatsAdapter;

import static com.facebook.FacebookSdk.getApplicationContext;

public class StatsActivity extends BaseActivity {
    private RecyclerView mRecyclerStats;
    private StatsAdapter mStatsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        init();
    }

    private void init(){
        mRecyclerStats = findViewById(R.id.recycler_stats);
        mRecyclerStats.setHasFixedSize(true);
        mRecyclerStats.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mStatsAdapter = new StatsAdapter(getApplicationContext());
        mRecyclerStats.setAdapter ( mStatsAdapter );
    }
}
