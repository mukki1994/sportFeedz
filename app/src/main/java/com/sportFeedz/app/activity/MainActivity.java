package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.sportFeedz.app.R;
import com.sportFeedz.app.fragment.HomeFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemReturnHome;
    private ResideMenuItem itemStartGame;
    private ResideMenuItem itemSearchPlayers;
    private ResideMenuItem itemFollowUser;
    private Button mBtnOpenMenu;

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
            changeFragment(new HomeFragment());
    }

    private void init(){
        mBtnOpenMenu = findViewById(R.id.button_openProfile);

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.ic_bg_screen);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.7f);

        // create menu items;
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
            changeFragment(new HomeFragment());
        }
        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
