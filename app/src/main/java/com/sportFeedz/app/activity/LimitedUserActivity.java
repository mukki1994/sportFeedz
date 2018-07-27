package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.LimitedUserAdapter;

public class LimitedUserActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerLimitedUser;
    private LimitedUserAdapter mLimitedUserAdapter;
    private ImageView mImgClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limited_user);
        init();
        setListener();

        mRecyclerLimitedUser.setHasFixedSize(true);
        mRecyclerLimitedUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mLimitedUserAdapter = new LimitedUserAdapter(getApplicationContext());
        mRecyclerLimitedUser.setAdapter ( mLimitedUserAdapter );
    }

    private void init(){
        mRecyclerLimitedUser = findViewById(R.id.recycler_limited_user);
        mImgClose = findViewById(R.id.image_close);
    }

    private void setListener(){
        mImgClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_close:
                finish();
                break;
        }
    }
}
