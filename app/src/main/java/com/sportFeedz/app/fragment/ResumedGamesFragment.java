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

import static com.facebook.FacebookSdk.getApplicationContext;
public class ResumedGamesFragment extends Fragment {
    private RecyclerView mRecyclerResumedGames;
    private ResumedGamesAdapter mResumedGamesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumed_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        mRecyclerResumedGames.setHasFixedSize(true);
        mRecyclerResumedGames.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mResumedGamesAdapter = new ResumedGamesAdapter(getApplicationContext());
        mRecyclerResumedGames.setAdapter ( mResumedGamesAdapter );
    }

    private void init(View view){
        mRecyclerResumedGames = view.findViewById(R.id.recycler_resumedGames);
    }

}
