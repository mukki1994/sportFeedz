package com.sportFeedz.app.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.sportFeedz.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileUserFragment extends BaseFragment implements View.OnClickListener{

    private ToggleButton mBtnTogglePrivacy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setListener();
    }

    private void init(View view){
        mBtnTogglePrivacy = view.findViewById(R.id.toggle_privacy);
    }

    private void setListener(){
      mBtnTogglePrivacy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toggle_privacy:
                boolean on = ((ToggleButton) view).isChecked();
                if (on) {
                    mBtnTogglePrivacy.setTextOff("OFF");
                } else {

                    mBtnTogglePrivacy.setTextOn("ON");

                }

        }
    }
}
