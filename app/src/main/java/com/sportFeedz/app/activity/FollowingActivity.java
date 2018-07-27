package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.FollowingAdapter;

public class FollowingActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mRecyclerFollowing;
    private FollowingAdapter mFollowingAdapter;
    private ImageView mImgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        init();
        setListener();

        mRecyclerFollowing.setHasFixedSize(true);
        mRecyclerFollowing.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mFollowingAdapter = new FollowingAdapter(getApplicationContext());
        mRecyclerFollowing.setAdapter ( mFollowingAdapter );
    }

    private void init(){
        mRecyclerFollowing = findViewById(R.id.recycler_following);
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
