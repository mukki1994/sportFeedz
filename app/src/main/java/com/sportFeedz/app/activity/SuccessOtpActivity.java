package com.sportFeedz.app.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.sportFeedz.app.R;

public class SuccessOtpActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnContinue;
    private ImageView mImgBack;
    private TextView mTxtShowPassword;
    private TextView mTxtHidePassword;
    private EditText mEdtPassword;
    private PinView mPinOtpReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_otp);
        init();
        setListener();
    }

    private void init(){
       mBtnContinue = findViewById(R.id.button_continue);
       mImgBack = findViewById(R.id.image_back);
       mTxtShowPassword = findViewById(R.id.text_show_password);
       mTxtHidePassword = findViewById(R.id.text_hide_password);
       mEdtPassword = findViewById(R.id.edit_text_new_password);
       mPinOtpReceive = findViewById(R.id.text_pin_code);
       Intent intent = getIntent();
       mPinOtpReceive.setText(intent.getStringExtra("PIN"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPinOtpReceive.setTextColor(getColor(R.color.white));
        }
    }

    private void setListener(){
       mBtnContinue.setOnClickListener(this);
       mImgBack.setOnClickListener(this);
       mTxtShowPassword.setOnClickListener(this);
       mTxtHidePassword.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_continue:
                openActivity(LoginActivity.class);
                break;
            case R.id.image_back:
                finish();
                break;
            case R.id.text_show_password:
                showPassword();
                break;
            case R.id.text_hide_password:
                hidePassword();
                break;

        }
    }

    private void showPassword(){
        if (mEdtPassword.getText().toString().length() > 0) {
            mEdtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            mTxtShowPassword.setVisibility(View.GONE);
            mTxtHidePassword.setVisibility(View.VISIBLE);
        }
    }

    private void hidePassword(){
        mEdtPassword.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        mTxtHidePassword.setVisibility(View.GONE);
        mTxtShowPassword.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
