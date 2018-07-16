package com.sportFeedz.app.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sportFeedz.app.R;

public class ReceiveOtpActivity extends BaseActivity implements View.OnClickListener{

    private TextView mTxtResendOtp;
    private Button mBtnContinue;
    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_otp);
        init();
        setListener();
        mTxtResendOtp.setPaintFlags(mTxtResendOtp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTxtResendOtp.setText(getString(R.string.resend));
    }

    private void init(){
        mTxtResendOtp = findViewById(R.id.text_resend);
        mBtnContinue = findViewById(R.id.button_continue);
        mImgBack = findViewById(R.id.image_back);

    }


    private void setListener(){
        mBtnContinue.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_continue:
                openActivity(SuccessOtpActivity.class);
                break;
            case R.id.image_back:
                finish();
                break;
        }
    }
}
