package com.sportFeedz.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.MyFansAdapter;
import com.sportFeedz.app.adapter.NewRequestAdapter;
import com.sportFeedz.app.adapter.SuggestionsAdapter;

public class NewRequestActivity extends BaseActivity {

    private RecyclerView mRecyclerNewRequests;
    private RecyclerView mRecyclerSuggestions;
    private NewRequestAdapter mNewRequestsAdapter;
    private SuggestionsAdapter mSuggestionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        init();
    }

    private void init(){
        mRecyclerNewRequests = findViewById(R.id.recycler_new_request);
        mRecyclerNewRequests.setHasFixedSize(true);
        mRecyclerNewRequests.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mNewRequestsAdapter = new NewRequestAdapter(getApplicationContext());
        mRecyclerNewRequests.setAdapter ( mNewRequestsAdapter );
        mRecyclerNewRequests.setNestedScrollingEnabled(false);

        mRecyclerSuggestions = findViewById(R.id.recycler_suggestions);
        mRecyclerSuggestions.setHasFixedSize(true);
        mRecyclerSuggestions.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSuggestionsAdapter = new SuggestionsAdapter(getApplicationContext());
        mRecyclerSuggestions.setAdapter ( mSuggestionsAdapter );
        mRecyclerSuggestions.setNestedScrollingEnabled(false);
    }
}
