package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.MyFansAdapter;
import com.sportFeedz.app.adapter.StatsAdapter;

public class MyFansActivity extends BaseActivity {

    private RecyclerView mRecyclerMyFans;
    private MyFansAdapter mMyFansAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans);
        init();
    }

    private void init(){
        mRecyclerMyFans = findViewById(R.id.recycler_my_fans);
        mRecyclerMyFans.setHasFixedSize(true);
        mRecyclerMyFans.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMyFansAdapter = new MyFansAdapter(getApplicationContext());
        mRecyclerMyFans.setAdapter ( mMyFansAdapter );
    }
}
