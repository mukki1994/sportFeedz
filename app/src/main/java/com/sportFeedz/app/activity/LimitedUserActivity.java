package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.FollowingAdapter;
import com.sportFeedz.app.adapter.LimitedUserAdapter;

public class LimitedUserActivity extends BaseActivity {

    private RecyclerView mRecyclerLimitedUser;
    private LimitedUserAdapter mLimitedUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limited_user);
        init();
    }

    private void init(){
        mRecyclerLimitedUser = findViewById(R.id.recycler_limited_user);
        mRecyclerLimitedUser.setHasFixedSize(true);
        mRecyclerLimitedUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mLimitedUserAdapter = new LimitedUserAdapter(getApplicationContext());
        mRecyclerLimitedUser.setAdapter ( mLimitedUserAdapter );
    }
}
