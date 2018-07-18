package com.sportFeedz.app.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.MainActivity;
import com.sportFeedz.app.adapter.HomePlayersAdapter;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HomeFieldFragment extends BaseFragment implements View.OnClickListener{

    private RecyclerView mRecyclerHomePlayers;
    private HomePlayersAdapter mHomePlayersAdapter;
    private TextView mTxtResumeGames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setListener();
        mRecyclerHomePlayers.setHasFixedSize(true);
        mRecyclerHomePlayers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mHomePlayersAdapter = new HomePlayersAdapter(getApplicationContext());
        mRecyclerHomePlayers.setAdapter ( mHomePlayersAdapter );
    }

    private void init(View view){
        mRecyclerHomePlayers = view.findViewById(R.id.recycler_players);
        mTxtResumeGames = view.findViewById(R.id.text_resumeGame);
    }

    private void setListener(){
        mTxtResumeGames.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_resumeGame:
                ((MainActivity)getActivity()).replaceResumeGames();
                break;
        }

    }
}
