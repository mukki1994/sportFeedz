package com.sportFeedz.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.sportFeedz.app.R;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnChangePassword;
    private TextView mTxtShowOldPassword;
    private TextView mTxtHideOldPassword;
    private TextView mTxtShowNewPassword;
    private TextView mTxtHideNewPassword;
    private EditText mEdtOldPassword;
    private EditText mEdtNewPassword;
    private ImageView mImgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        init();
        setListener();

    }

    private void init(){
        mBtnChangePassword = findViewById(R.id.button_changePassword);
        mTxtShowOldPassword = findViewById(R.id.text_show_password);
        mTxtHideOldPassword = findViewById(R.id.text_hide_password);
        mTxtShowNewPassword = findViewById(R.id.text_show_password_second);
        mTxtHideNewPassword = findViewById(R.id.text_hide_password_second);
        mEdtOldPassword = findViewById(R.id.edit_text_old_password);
        mEdtNewPassword = findViewById(R.id.edit_text_password);
        mImgClose = findViewById(R.id.image_close);

    }

    private void setListener(){
        mBtnChangePassword.setOnClickListener(this);
        mTxtShowOldPassword.setOnClickListener(this);
        mTxtHideOldPassword.setOnClickListener(this);
        mTxtShowNewPassword.setOnClickListener(this);
        mTxtHideNewPassword.setOnClickListener(this);
        mImgClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_changePassword:
                Intent intent = new Intent(this,SuccesChangePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.text_show_password:
                showOldPassword();
                break;
            case R.id.text_hide_password:
                hideOldPassword();
                break;
            case R.id.text_show_password_second:
                showNewPassword();
                break;
            case R.id.text_hide_password_second:
                hideNewPassword();
                break;
            case R.id.image_close:
                finish();
                break;
        }
    }

    private void showOldPassword(){
        if (mEdtOldPassword.getText().toString().length() > 0) {
            mEdtOldPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            mTxtShowOldPassword.setVisibility(View.GONE);
            mTxtHideOldPassword.setVisibility(View.VISIBLE);
        }
    }

    private void showNewPassword(){
        if (mEdtNewPassword.getText().toString().length() > 0){
            mEdtNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            mTxtShowNewPassword.setVisibility(View.GONE);
            mTxtHideNewPassword.setVisibility(View.VISIBLE);
        }
    }

    private void hideOldPassword(){
        if (mEdtOldPassword.getText().toString().length() > 0) {
            mEdtOldPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            mTxtShowOldPassword.setVisibility(View.VISIBLE);
            mTxtHideOldPassword.setVisibility(View.GONE);
        }
    }

    private void hideNewPassword(){
        if (mEdtNewPassword.getText().toString().length() > 0){
            mEdtNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            mTxtShowNewPassword.setVisibility(View.VISIBLE);
            mTxtHideNewPassword.setVisibility(View.GONE);

        }
    }
}
