package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sportFeedz.app.R;

public class SuccessRegisterActivity extends BaseActivity implements View.OnClickListener{


    private Button mBtnGoHomePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
        init();
        setListener();
    }

    private void init(){
        mBtnGoHomePage = findViewById(R.id.button_continue);
    }

    private void setListener(){
        mBtnGoHomePage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_continue:
                openActivity(MainActivity.class);
                break;
        }
    }
}
