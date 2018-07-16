package com.sportFeedz.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sportFeedz.app.R;

public class StartupActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnLogin;
    private Button mBtnNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        init();
        setListener();
    }

    private void init(){
        mBtnLogin = findViewById(R.id.button_login);
        mBtnNewUser = findViewById(R.id.button_new_user);
    }

    private void setListener(){
        mBtnLogin.setOnClickListener(this);
        mBtnNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.button_login:
              openActivity(LoginActivity.class);
              break;
          case R.id.button_new_user:
              openActivity(RegistrationActivity.class);
              break;
      }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
