package com.sportFeedz.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.sportFeedz.app.R;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnChangePassword;
    private TextView mTxtShowOldPassword;
    private TextView mTxtHideOldPassword;
    private TextView mTxtShowNewPassword;
    private TextView mTxtHideNewPassword;
    private PinView mPinOldPassword;
    private PinView mPinNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        init();
        setListener();
        mPinNewPassword.requestFocus();
        mPinOldPassword.requestFocus();
    }

    private void init(){
        mBtnChangePassword = findViewById(R.id.button_changePassword);
        mTxtShowOldPassword = findViewById(R.id.text_show_password);
        mTxtHideOldPassword = findViewById(R.id.text_hide_password);
        mTxtShowNewPassword = findViewById(R.id.text_show_password_second);
        mTxtHideNewPassword = findViewById(R.id.text_hide_password_second);
        mPinNewPassword = findViewById(R.id.pin_new_password);
        mPinOldPassword = findViewById(R.id.pin_old_password);
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
            case R.id.text_show_password:
                showPassword();
                break;
            case R.id.text_hide_password:
                hidePassword();
                break;
            case R.id.text_show_password_second:
                showPassword();
                break;
            case R.id.text_hide_password_second:
                hidePassword();
                break;
        }
    }

    private void showPassword(){

    }

    private void hidePassword(){

    }
}
