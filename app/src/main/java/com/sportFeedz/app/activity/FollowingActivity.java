package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.FollowingAdapter;
import com.sportFeedz.app.adapter.MyFansAdapter;

public class FollowingActivity extends BaseActivity {

    private RecyclerView mRecyclerFollowing;
    private FollowingAdapter mFollowingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        init();
    }

    private void init(){
        mRecyclerFollowing = findViewById(R.id.recycler_following);
        mRecyclerFollowing.setHasFixedSize(true);
        mRecyclerFollowing.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mFollowingAdapter = new FollowingAdapter(getApplicationContext());
        mRecyclerFollowing.setAdapter ( mFollowingAdapter );
    }
}
