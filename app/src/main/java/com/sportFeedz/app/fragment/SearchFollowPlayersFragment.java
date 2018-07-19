package com.sportFeedz.app.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.ResumedGamesAdapter;
import com.sportFeedz.app.adapter.SearchFollowPlayersAdapter;

import static com.facebook.FacebookSdk.getApplicationContext;

public class SearchFollowPlayersFragment extends BaseFragment {

    private RecyclerView mRecyclerSearchFollow;
    private SearchFollowPlayersAdapter mSearchFollowPlayerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_follow_players, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        mRecyclerSearchFollow.setHasFixedSize(true);
        mRecyclerSearchFollow.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSearchFollowPlayerAdapter = new SearchFollowPlayersAdapter(getApplicationContext());
        mRecyclerSearchFollow.setAdapter ( mSearchFollowPlayerAdapter );
    }

    private void init(View view){
        mRecyclerSearchFollow = view.findViewById(R.id.recycler_followSearchPlayers);

    }
}
