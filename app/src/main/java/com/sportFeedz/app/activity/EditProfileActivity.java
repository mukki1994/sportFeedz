package com.sportFeedz.app.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.utilities.Utils;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEdtFullName;
    private EditText mEdtEmailId;
    private EditText mEdtPhoneNumber;
    private TextView mTxtDone;
    private ImageView mImgClose;
    private ConstraintLayout mConstraintEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
        setListener();
        showDone();
    }

    private void init(){
        mEdtFullName = findViewById(R.id.edit_text_fullname);
        mEdtEmailId = findViewById(R.id.edit_text_email);
        mEdtPhoneNumber = findViewById(R.id.edit_text_phoneNumber);
        mTxtDone = findViewById(R.id.text_Done);
        mImgClose = findViewById(R.id.image_close);
        mConstraintEditProfile = findViewById(R.id.constraint_editprofile);
    }

    private void setListener(){
        mImgClose.setOnClickListener(this);
    }

    private void showDone(){
        mEdtPhoneNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    if (isValidate()){
                        mTxtDone.setVisibility(View.VISIBLE);
                    }else {
                        mTxtDone.setVisibility(View.INVISIBLE);

                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_close:
                finish();
        }
    }
    private boolean isValidate(){
        String email = mEdtEmailId.getText ().toString ().trim ();
        String fullname = mEdtFullName.getText ().toString ().trim ();
        String phone_number = mEdtPhoneNumber.getText().toString().trim();
        boolean valid= true;
        if (TextUtils.isEmpty(fullname)){
            Utils.getInstance().showSnackbar(mConstraintEditProfile,getString(R.string.empty_fullname));
            valid = false;
        } else if (mEdtFullName.length() < 5){
            Utils.getInstance().showSnackbar(mConstraintEditProfile,getString(R.string.valid_fullname));
            valid = false;
        }else if (TextUtils.isEmpty ( email )) {
            Utils.getInstance().showSnackbar(mConstraintEditProfile,getString(R.string.empty_email));
            valid = false;
        } else if (!Utils.getInstance().isEmailValid(email)) {
            Utils.getInstance().showSnackbar(mConstraintEditProfile,getString(R.string.valid_email));
            valid = false;
        } else if (TextUtils.isEmpty ( phone_number )) {
            Utils.getInstance().showSnackbar(mConstraintEditProfile,"Please enter phone number");
            valid = false;
        } else if (mEdtPhoneNumber.length() < 10 && mEdtPhoneNumber.length() > 20){
            Utils.getInstance().showSnackbar(mConstraintEditProfile,"Please enter a valid phone number");
            valid = false;
        }
        return valid;
    }
}
