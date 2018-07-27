package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.MyFansAdapter;
import com.sportFeedz.app.adapter.StatsAdapter;

public class MyFansActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerMyFans;
    private MyFansAdapter mMyFansAdapter;
    private ImageView mImgClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans);
        init();
        setListener();

        mRecyclerMyFans.setHasFixedSize(true);
        mRecyclerMyFans.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMyFansAdapter = new MyFansAdapter(getApplicationContext());
        mRecyclerMyFans.setAdapter ( mMyFansAdapter );
    }

    private void init(){
        mRecyclerMyFans = findViewById(R.id.recycler_my_fans);
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
