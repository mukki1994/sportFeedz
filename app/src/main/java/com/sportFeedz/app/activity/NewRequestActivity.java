package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.MyFansAdapter;
import com.sportFeedz.app.adapter.NewRequestAdapter;
import com.sportFeedz.app.adapter.SuggestionsAdapter;

public class NewRequestActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerNewRequests;
    private RecyclerView mRecyclerSuggestions;
    private NewRequestAdapter mNewRequestsAdapter;
    private SuggestionsAdapter mSuggestionsAdapter;
    private ImageView mImgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        init();
        setListener();
        setRecyclerView();
    }

    private void init(){
        mRecyclerNewRequests = findViewById(R.id.recycler_new_request);
        mRecyclerSuggestions = findViewById(R.id.recycler_suggestions);
        mImgClose = findViewById(R.id.image_close);
    }

    private void setListener(){
        mImgClose.setOnClickListener(this);
    }
    private void setRecyclerView(){
        mRecyclerNewRequests.setHasFixedSize(true);
        mRecyclerNewRequests.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mNewRequestsAdapter = new NewRequestAdapter(getApplicationContext());
        mRecyclerNewRequests.setAdapter ( mNewRequestsAdapter );
        mRecyclerNewRequests.setNestedScrollingEnabled(false);

        mRecyclerSuggestions.setHasFixedSize(true);
        mRecyclerSuggestions.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSuggestionsAdapter = new SuggestionsAdapter(getApplicationContext());
        mRecyclerSuggestions.setAdapter ( mSuggestionsAdapter );
        mRecyclerSuggestions.setNestedScrollingEnabled(false);
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
