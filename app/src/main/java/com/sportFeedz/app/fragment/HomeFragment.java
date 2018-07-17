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
import android.widget.FrameLayout;

import com.special.ResideMenu.ResideMenu;
import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.MainActivity;
import com.sportFeedz.app.adapter.HomePlayersAdapter;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HomeFragment extends BaseFragment {

    private RecyclerView mRecyclerHomePlayers;
    private HomePlayersAdapter mHomePlayersAdapter;
    private View parentView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentView = inflater.inflate(R.layout.fragment_home, container, false);
        return parentView;    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        mRecyclerHomePlayers = view.findViewById(R.id.recycler_players);
        mRecyclerHomePlayers.setHasFixedSize(true);
        mRecyclerHomePlayers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mHomePlayersAdapter = new HomePlayersAdapter(getApplicationContext());
        mRecyclerHomePlayers.setAdapter ( mHomePlayersAdapter );
    }
}
