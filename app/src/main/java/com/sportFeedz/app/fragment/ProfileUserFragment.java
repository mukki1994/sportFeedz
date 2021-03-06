package com.sportFeedz.app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.ChangePasswordActivity;
import com.sportFeedz.app.activity.EditProfileActivity;
import com.sportFeedz.app.activity.FollowingActivity;
import com.sportFeedz.app.activity.LimitedUserActivity;
import com.sportFeedz.app.activity.MyFansActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileUserFragment extends BaseFragment implements View.OnClickListener{

    private ToggleButton mBtnTogglePrivacy;
    private Button mBtnEditProfile;
    private TextView mTxtChangePassword;
    private TextView mTxtLimitedUser;
    private TextView mTxtFollowings;
    private TextView mTxtMyFans;

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
        mBtnEditProfile = view.findViewById(R.id.button_editProfile);
        mTxtChangePassword = view.findViewById(R.id.text_changePassword);
        mTxtFollowings = view.findViewById(R.id.text_following);
        mTxtLimitedUser = view.findViewById(R.id.text_limitedUser);
        mTxtMyFans = view.findViewById(R.id.text_myFans);
    }

    private void setListener(){
      mBtnTogglePrivacy.setOnClickListener(this);
      mBtnEditProfile.setOnClickListener(this);
      mTxtChangePassword.setOnClickListener(this);
      mTxtMyFans.setOnClickListener(this);
      mTxtLimitedUser.setOnClickListener(this);
      mTxtFollowings.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toggle_privacy:
                boolean on = ((ToggleButton) view).isChecked();
                if (on) {
                    mBtnTogglePrivacy.setBackground(getActivity().getDrawable(R.drawable.ic_toggle_off));
                } else {

                    mBtnTogglePrivacy.setBackground(getActivity().getDrawable(R.drawable.ic_toogle_on));
                }
                break;
            case R.id.button_editProfile:
                Intent editProfile = new Intent(getContext(), EditProfileActivity.class);
                startActivity(editProfile);
                break;
            case R.id.text_changePassword:
                Intent changePassword = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(changePassword);
                break;
            case R.id.text_following:
                Intent followings = new Intent(getContext(), FollowingActivity.class);
                startActivity(followings);
                break;
            case R.id.text_myFans:
                Intent myfans = new Intent(getContext(), MyFansActivity.class);
                startActivity(myfans);
                break;
            case R.id.text_limitedUser:
                Intent limitedUser = new Intent(getContext(), LimitedUserActivity.class);
                startActivity(limitedUser);
                break;

        }
    }
}
