package com.sportFeedz.app.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.sportFeedz.app.R;

public class ReceiveOtpActivity extends BaseActivity implements View.OnClickListener{

    private TextView mTxtResendOtp;
    private Button mBtnContinue;
    private ImageView mImgBack;
    private PinView mPinOtp;


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
        mPinOtp = findViewById(R.id.text_pin);
    }


    private void setListener(){
        mBtnContinue.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_continue:
                Intent intent = new Intent(this,SuccessOtpActivity.class) ;
                intent.putExtra("PIN",mPinOtp.getText().toString());
                startActivity(intent);
                break;
            case R.id.image_back:
                finish();
                break;
        }
    }
}
