package com.sportFeedz.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sportFeedz.app.R;

public class SuccessCreatedUserAcitvity extends BaseActivity implements View.OnClickListener {

    private Button mBtnShareNow;
    private ImageView mImgTick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_created_user);
        init();
        setListener();
    }

    private void init(){
       mBtnShareNow = findViewById(R.id.button_share_now);
       mImgTick = findViewById(R.id.image_oval_tick);

    }

    private void setListener(){
        mBtnShareNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_share_now:
                shareCode();
                break;
        }
    }

    /**
     * this method is used for share code
     */
    private void shareCode(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }
}
