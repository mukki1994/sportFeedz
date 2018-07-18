package com.sportFeedz.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.sportFeedz.app.R;
import com.sportFeedz.app.fragment.FollowLimitedUserFragment;
import com.sportFeedz.app.fragment.HomeFieldFragment;
import com.sportFeedz.app.fragment.ResumedGamesFragment;
import com.sportFeedz.app.fragment.SearchFollowPlayersFragment;
import com.sportFeedz.app.fragment.StartNewGameFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemReturnHome;
    private ResideMenuItem itemStartGame;
    private ResideMenuItem itemSearchPlayers;
    private ResideMenuItem itemFollowUser;
    private Button mBtnOpenMenu;
    private TextView mTxtPageTitle;
    private TextView mTxtStartNewGame;
    private ImageView mImgNewGame;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        init();
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new HomeFieldFragment());
    }

    private void init(){
        mBtnOpenMenu = findViewById(R.id.button_openProfile);
        mTxtPageTitle = findViewById(R.id.text_title);
        mTxtStartNewGame = findViewById(R.id.text_start_newGame);
        mImgNewGame = findViewById(R.id.image_start_newGame);


    }

    private void setUpMenu() {

        resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.ic_bg_screen);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.7f);

        itemReturnHome     = new ResideMenuItem(this,     "Return to Home Field");
        itemStartGame  = new ResideMenuItem(this,  "Start a New Game");
        itemSearchPlayers = new ResideMenuItem(this,  "Search & Follow Players");
        itemFollowUser = new ResideMenuItem(this,  "Follow Limited User");

        itemReturnHome.setOnClickListener(this);
        itemStartGame.setOnClickListener(this);
        itemSearchPlayers.setOnClickListener(this);
        itemFollowUser.setOnClickListener(this);

        resideMenu.addMenuItem(itemReturnHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemStartGame, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemSearchPlayers, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFollowUser, ResideMenu.DIRECTION_LEFT);

        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        mBtnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        if (view == itemReturnHome){
            changeFragment(new HomeFieldFragment());
            mTxtPageTitle.setText("Home Field");
            mTxtStartNewGame.setVisibility(View.VISIBLE);
            mImgNewGame.setVisibility(View.VISIBLE);
        }else if (view == itemStartGame){
            changeFragment(new StartNewGameFragment());
            mTxtPageTitle.setText("Start a New Game");
            mTxtStartNewGame.setVisibility(View.INVISIBLE);
            mImgNewGame.setVisibility(View.INVISIBLE);
        }else if (view == itemSearchPlayers){
            changeFragment(new SearchFollowPlayersFragment());
            mTxtPageTitle.setText("Search & Follow a New Player");
            mTxtStartNewGame.setVisibility(View.INVISIBLE);
            mImgNewGame.setVisibility(View.INVISIBLE);
        }else if (view == itemFollowUser){
            changeFragment(new FollowLimitedUserFragment());
            mTxtPageTitle.setText("Follow Limited User");
            mTxtStartNewGame.setVisibility(View.INVISIBLE);
            mImgNewGame.setVisibility(View.INVISIBLE);
        }else if (view == resideMenu){
            resideMenu.closeMenu();
        }
        resideMenu.closeMenu();
    }

    public void replaceResumeGames(){
        changeFragment(new ResumedGamesFragment());
        mTxtPageTitle.setText("Resumed Games");
        mTxtStartNewGame.setVisibility(View.INVISIBLE);
        mImgNewGame.setVisibility(View.INVISIBLE);
    }

    public void goToHomeFragment(){
        changeFragment(new HomeFieldFragment());
        mTxtPageTitle.setText("Home Field");
        mTxtStartNewGame.setVisibility(View.VISIBLE);
        mImgNewGame.setVisibility(View.VISIBLE);
    }

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (mTxtPageTitle.getText().toString().equalsIgnoreCase("Resumed Games")){
            goToHomeFragment();
        }else {
            super.onBackPressed();
        }
    }
}
