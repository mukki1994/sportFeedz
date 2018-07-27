package com.sportFeedz.app.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.special.ResideMenu.OnClickProfile;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.special.ResideMenu.ResideMenuProfileItem;
import com.sportFeedz.app.R;
import com.sportFeedz.app.fragment.FollowLimitedUserFragment;
import com.sportFeedz.app.fragment.HomeFieldFragment;
import com.sportFeedz.app.fragment.ProfileUserFragment;
import com.sportFeedz.app.fragment.ResumedGamesFragment;
import com.sportFeedz.app.fragment.SearchFollowPlayersFragment;
import com.sportFeedz.app.fragment.StartNewGameFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener,OnClickProfile{

    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemReturnHome;
    private ResideMenuItem itemStartGame;
    private ResideMenuItem itemSearchPlayers;
    private ResideMenuItem itemFollowUser;
    private ResideMenuItem itemProfileLogout;
    private ResideMenuProfileItem itemProfile;
    private Button mBtnOpenMenu;
    private TextView mTxtPageTitle;
    private TextView mTxtStartNewGame;
    private ImageView mImgNewGame;
    private ImageView mImgProfileOval;
    private ImageView mImgAddFriends;
    private TextView mTxtFriendsCount;

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
        mTxtFriendsCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewRequestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        mBtnOpenMenu = findViewById(R.id.button_openProfile);
        mTxtPageTitle = findViewById(R.id.text_title);
        mTxtStartNewGame = findViewById(R.id.text_start_newGame);
        mImgNewGame = findViewById(R.id.image_start_newGame);
        mImgAddFriends = findViewById(R.id.image_add_friend);
        mImgProfileOval = findViewById(R.id.image_oval);
        mTxtFriendsCount = findViewById(R.id.textFriendsCount);

    }

    private void setUpMenu() {

        resideMenu = new ResideMenu(this,this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.ic_bg_screen);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.7f);

        itemProfile = new ResideMenuProfileItem(this,R.drawable.ic_andy_rubin,"Mukesh Rawat",
                "mukesh.rawat@gmail.com");
        itemReturnHome     = new ResideMenuItem(this,     "Return to Home Field");
        itemStartGame  = new ResideMenuItem(this,  "Start a New Game");
        itemSearchPlayers = new ResideMenuItem(this,  "Search & Follow Players");
        itemFollowUser = new ResideMenuItem(this,  "Follow Limited User");
        itemProfileLogout = new ResideMenuItem(this,  "Logout");



        itemReturnHome.setOnClickListener(this);
        itemStartGame.setOnClickListener(this);
        itemSearchPlayers.setOnClickListener(this);
        itemFollowUser.setOnClickListener(this);
        itemProfileLogout.setOnClickListener(this);

        resideMenu.addMenuProfileItems(itemProfile,ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(itemReturnHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemStartGame, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemSearchPlayers, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFollowUser, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfileLogout, ResideMenu.DIRECTION_LEFT);

        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

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
            mTxtFriendsCount.setVisibility(View.INVISIBLE);
            mImgAddFriends.setVisibility(View.INVISIBLE);
            mImgProfileOval.setVisibility(View.INVISIBLE);

        }else if (view == itemStartGame){
            changeFragment(new StartNewGameFragment());
            mTxtPageTitle.setText("Start a New Game");
            setVisibility();
        }else if (view == itemSearchPlayers){
            changeFragment(new SearchFollowPlayersFragment());
            mTxtPageTitle.setText("Search & Follow a New Player");

            setVisibility();
        }else if (view == itemFollowUser){
            changeFragment(new FollowLimitedUserFragment());
            mTxtPageTitle.setText("Follow Limited User");
            setVisibility();
        }else if (view == itemProfileLogout){
            resideMenu.closeMenu();
            showDialog();
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
                .commitAllowingStateLoss();
    }

    private void setVisibility(){
        mTxtStartNewGame.setVisibility(View.INVISIBLE);
        mImgNewGame.setVisibility(View.INVISIBLE);
        mImgProfileOval.setVisibility(View.INVISIBLE);
        mImgAddFriends.setVisibility(View.INVISIBLE);
        mTxtFriendsCount.setVisibility(View.INVISIBLE);
    }

    private void showDialog(){
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_logout);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            final Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
            Button mBtnCancel = dialog.findViewById(R.id.button_cancel);
            Button mBtnLogout = dialog.findViewById(R.id.button_logout);
            mBtnCancel.setOnClickListener(v -> dialog.dismiss());
            mBtnLogout.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this,StartupActivity.class);
                startActivity(intent);
            });
            dialog.show();
        }
    @Override
    public void onBackPressed() {
        if (mTxtPageTitle.getText().toString().equalsIgnoreCase("Resumed Games")){
            goToHomeFragment();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void clickProfile() {
       changeFragment(new ProfileUserFragment());
        mTxtPageTitle.setText("Profile");
        mImgProfileOval.setVisibility(View.VISIBLE);
        mImgAddFriends.setVisibility(View.VISIBLE);
        mTxtFriendsCount.setVisibility(View.VISIBLE);
        mTxtStartNewGame.setVisibility(View.INVISIBLE);
        mImgNewGame.setVisibility(View.INVISIBLE);
       resideMenu.closeMenu();
    }

}
