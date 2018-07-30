package com.sportFeedz.app.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.utilities.Utils;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTxtLogin;
    private ImageView mImgBack;
    private LinearLayout mLnrAlreadyMember;
    private ScrollView mScrollViewRegister;
    private Button mBtnRegister;
    private EditText mEdtFullName;
    private EditText mEdtEmailAddress;
    private EditText mEdtPassword;
    private EditText mEdtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        setListener();
        mTxtLogin.setPaintFlags(mTxtLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTxtLogin.setText("LOGIN");
    }

    private void init(){
        mTxtLogin = findViewById(R.id.text_login);
        mImgBack = findViewById(R.id.image_back);
        mLnrAlreadyMember = findViewById(R.id.linearAlreadyMember);
        mScrollViewRegister = findViewById(R.id.scrollviewRegister);
        mBtnRegister = findViewById(R.id.button_register);
        mEdtEmailAddress = findViewById(R.id.edit_text_EmailAddress);
        mEdtFullName = findViewById(R.id.edit_text_fullName);
        mEdtPassword = findViewById(R.id.edit_text_setPassword);
        mEdtPhoneNumber = findViewById(R.id.edit_text_phoneNumber);
    }

    private void setListener(){
        mImgBack.setOnClickListener(this);
        mLnrAlreadyMember.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.linearAlreadyMember:
                openActivity(LoginActivity.class);
                break;
            case R.id.button_register:
                if (isValidateDetails()){
                    openActivity(SuccessRegisterActivity.class);
                    mEdtFullName.setText("");
                    mEdtEmailAddress.setText("");
                    mEdtPhoneNumber.setText("");
                    mEdtPassword.setText("");
                }
                break;

        }
    }

    private boolean isValidateDetails(){
        String email = mEdtEmailAddress.getText ().toString ().trim ();
        String password = mEdtPassword.getText ().toString ().trim ();
        String fullname = mEdtFullName.getText().toString().trim();
        boolean valid= true;
        if (TextUtils.isEmpty(fullname)){
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.empty_fullname));
            valid = false;
        } else if (fullname.length() < 4){
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.valid_fullname));
            valid = false;
        }else if (TextUtils.isEmpty ( email )) {
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.empty_email));
            valid = false;
        } else if (!Utils.getInstance().isEmailValid(email)) {
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.valid_email));
            valid = false;
        } else if (TextUtils.isEmpty ( password )) {
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.empty_password));
            valid = false;
        } else if (password.length() < 8){
            Utils.getInstance().showSnackbar(mScrollViewRegister,getString(R.string.valid_password));
            valid = false;
        }
        return valid;
    }
}