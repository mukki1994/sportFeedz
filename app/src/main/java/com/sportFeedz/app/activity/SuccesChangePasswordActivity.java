package com.sportFeedz.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sportFeedz.app.R;

public class SuccesChangePasswordActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mImgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_change_password);
        init();
        setListener();
    }

    private void init(){
        mImgClose = findViewById(R.id.image_close);
    }

    private void setListener(){
        mImgClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.image_close:
               finish();
               break;
       }
    }
}
