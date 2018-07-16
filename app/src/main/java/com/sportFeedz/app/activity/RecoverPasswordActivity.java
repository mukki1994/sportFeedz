package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sportFeedz.app.R;

public class RecoverPasswordActivity extends BaseActivity implements View.OnClickListener{

    private EditText mEdtEmailAddress;
    private EditText mEdtPhoneNumber;
    private RadioGroup mRdGroup;
    private Button mBtnContinue;
    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        init();
        setListener();
        selectType();
    }

    private void init(){
     mEdtEmailAddress = findViewById(R.id.edittext_type_email);
     mEdtPhoneNumber = findViewById(R.id.edittext_type_phone);
     mRdGroup = findViewById(R.id.radio_otp_type);
     mBtnContinue = findViewById(R.id.button_continue);
     mImgBack = findViewById(R.id.image_back);
    }

    private void setListener(){
        mBtnContinue.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
    }

    private void selectType(){
        mRdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radio_email:
                        mEdtEmailAddress.setVisibility(View.VISIBLE);
                        mEdtPhoneNumber.setVisibility(View.GONE);
                        break;
                    case R.id.radio_phone:
                        mEdtPhoneNumber.setVisibility(View.VISIBLE);
                        mEdtEmailAddress.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){

          case R.id.image_back:
              finish();
              break;
          case R.id.button_continue:
              openActivity(ReceiveOtpActivity.class);
              break;
      }
    }
}
