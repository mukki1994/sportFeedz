package com.sportFeedz.app.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.adapter.HomePlayersAdapter;
import com.sportFeedz.app.adapter.PlayersUpdationAdapter;
import com.sportFeedz.app.adapter.SelectPlayersSpinnerAdapter;
import com.sportFeedz.app.adapter.SelectedPlayersAdapter;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ScoreboardActivity extends BaseActivity implements View.OnTouchListener,View.OnClickListener{

    private RecyclerView mRecyclerSelectedPlayers;
    private SelectedPlayersAdapter mSelectedPlayers;
    private RecyclerView mRecyclerUpdationPlayers;
    private PlayersUpdationAdapter mPlayersUpdation;
    private TextView mTxtPoints;
    private TextView mTxtYards;
    private TextView mTxtName;
    private TextView mTxtNameAbout;
    private TextView mTxtNameAboutSecond;
    private TextView mTxtPointsNumber;
    private TextView mTxtNameAboutThird;
    private Button mBtnFinishGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        init();
        setListener();
    }

    private void init(){
        mRecyclerSelectedPlayers = findViewById(R.id.recycler_sekected_players);
        mRecyclerUpdationPlayers = findViewById(R.id.recycler_players_updation);
        mRecyclerSelectedPlayers.setHasFixedSize(true);
        mRecyclerUpdationPlayers.setHasFixedSize(true);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerSelectedPlayers.setLayoutManager(layoutManager);
        mSelectedPlayers = new SelectedPlayersAdapter(getApplicationContext());
        mRecyclerSelectedPlayers.setAdapter ( mSelectedPlayers );

        mRecyclerUpdationPlayers.setHasFixedSize(true);
        mRecyclerUpdationPlayers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mPlayersUpdation = new PlayersUpdationAdapter(getApplicationContext());
        mRecyclerUpdationPlayers.setAdapter ( mPlayersUpdation );
        mTxtPoints = findViewById(R.id.text_points);
        mTxtYards = findViewById(R.id.text_yards);
        mTxtName = findViewById(R.id.text_name);
        mTxtNameAbout = findViewById(R.id.text_name_about);
        mTxtNameAboutSecond = findViewById(R.id.text_name_about_second);
        mTxtNameAboutThird = findViewById(R.id.text_name_about_three);
        mTxtPointsNumber = findViewById(R.id.text_yards_point);
        mBtnFinishGame = findViewById(R.id.button_finish);

    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListener(){
        mTxtPoints.setOnTouchListener(this);
        mTxtYards.setOnTouchListener(this);
        mBtnFinishGame.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.text_points:
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mTxtPoints.setBackground(getDrawable(R.drawable.bg_button));
                        mTxtYards.setBackgroundResource(R.color.black);;
                        mTxtName.setVisibility(View.VISIBLE);
                        mTxtNameAbout.setVisibility(View.VISIBLE);
                        mTxtNameAboutSecond.setVisibility(View.INVISIBLE);
                        mTxtNameAboutThird.setVisibility(View.INVISIBLE);
                        mTxtPointsNumber.setVisibility(View.INVISIBLE);
                        break;
                }
                break;
            case R.id.text_yards:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mTxtYards.setBackground(getDrawable(R.drawable.bg_button));
                        mTxtPoints.setBackgroundResource(R.color.black);;
                        mTxtName.setVisibility(View.INVISIBLE);
                        mTxtNameAbout.setVisibility(View.INVISIBLE);
                        mTxtNameAboutSecond.setVisibility(View.VISIBLE);
                        mTxtNameAboutThird.setVisibility(View.VISIBLE);
                        mTxtPointsNumber.setVisibility(View.VISIBLE);
                }
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.button_finish:
               showDialog();
               break;
       }
    }

    private void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_finish_game);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        final Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        Button mBtnCancel = dialog.findViewById(R.id.button_cancel);
        Button mBtnFinish = dialog.findViewById(R.id.button_finish);
        mBtnCancel.setOnClickListener(v -> dialog.dismiss());
        mBtnFinish.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
        dialog.show();
    }
}
