package com.sportFeedz.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sportFeedz.app.R;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnChangePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        init();
        setListener();
    }

    private void init(){
        mBtnChangePassword = findViewById(R.id.button_changePassword);
    }

    private void setListener(){
        mBtnChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_changePassword:
                Intent intent = new Intent(this,SuccesChangePasswordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
