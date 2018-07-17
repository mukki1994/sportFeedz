package com.sportFeedz.app.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TwitterAuthProvider;
import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.utilities.Utils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView mTxtRecoverPassword;
    private ImageView mImgBack;
    private LinearLayout mLnrRecoverPassword;
    private ScrollView mScrollViewLogin;
    private EditText mEdtEmailAddress;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private ImageView mImgFbLogin;
    private LoginButton mBtnFbLogin;
    private CallbackManager mCallbackManager;
    private AlertDialog mAlerDialog;
    private URL mProfilePic;
    private String id;

    private ImageView mImgGoogleLogin;
    private SignInButton mBtnSignInGoogle;
    private GoogleApiClient mGoogleApiClient;
    public static final int RC_SIGN_IN = 9001;

    private TwitterLoginButton mBtnTwitterLogin;
    private ImageView mImgTwitterLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        init();
        setListener();
        signInWithGoogle();
        twitterLogin();
        mCallbackManager = CallbackManager.Factory.create();
        mAlerDialog  = showLoadingProgress(this);
        mTxtRecoverPassword.setPaintFlags(mTxtRecoverPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTxtRecoverPassword.setText(getString(R.string.recover));
    }

    private void init(){
        mTxtRecoverPassword = findViewById(R.id.text_recover_password);
        mImgBack = findViewById(R.id.image_back);
        mLnrRecoverPassword = findViewById(R.id.linearForgotPassword);
        mScrollViewLogin = findViewById(R.id.scrollviewLogin);
        mEdtEmailAddress = findViewById(R.id.edittext_email);
        mEdtPassword = findViewById(R.id.edittext_password);
        mBtnLogin = findViewById(R.id.button_submit);
        mImgFbLogin = findViewById(R.id.image_fb);
        mBtnFbLogin = findViewById(R.id.button_Login);
        mBtnSignInGoogle = findViewById(R.id.button_googleSign);
        mImgGoogleLogin = findViewById(R.id.image_google);
        mBtnTwitterLogin = findViewById(R.id.button_twitterSignIn);
        mImgTwitterLogin = findViewById(R.id.image_twitter);

    }

    private void setListener(){
        mImgBack.setOnClickListener(this);
        mLnrRecoverPassword.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mImgFbLogin.setOnClickListener(this);
        mBtnFbLogin.setOnClickListener(this);
        mImgGoogleLogin.setOnClickListener(this);
        mBtnSignInGoogle.setOnClickListener(this);
        mImgTwitterLogin.setOnClickListener(this);
        mBtnTwitterLogin.setOnClickListener(this);
    }

    private void facebookLogin(){
        mBtnFbLogin.setReadPermissions("email");
        mBtnFbLogin.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String accessToken = loginResult.getAccessToken().getToken();
                Log.i("accessToken",accessToken);
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.i("response",response.toString());
                        Bundle mFacebookData = getFacebookData(object);
                        String firstname = mFacebookData.getString("first_name");
                        String lastname = mFacebookData.getString("last_name");
                        String email = mFacebookData.getString("email");
                        String profilepic = mFacebookData.getString("profile_pic");
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("firstname", firstname);
                        intent.putExtra("lastname", lastname);
                        intent.putExtra("email", email);
                        intent.putExtra("image", profilepic);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields","id, first_name, last_name, email");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

        });
    }

    private Bundle getFacebookData(JSONObject object) {
        Bundle bundle = new Bundle();
        try {
            id = object.getString("id");
            mProfilePic = new URL("https://graph.facebook.com/" + id + "/picture?width=100&height=100");
            Log.i("profile_pic",mProfilePic+" ");
            bundle.putString("profile_pic",mProfilePic.toString());
            if (object.has("first_name")){
                bundle.putString("first_name", object.getString("firstname"));
            }
            if (object.has("last_name")){
                bundle.putString("last_name", object.getString("lastname"));
            }
            if (object.has("email")){
                bundle.putString("email", object.getString("email"));
            }
            bundle.putString("idFacebook",id);

        } catch (JSONException | MalformedURLException e) {
            e.printStackTrace();
        }
        return bundle;
    }

    private void twitterLogin(){
        mBtnTwitterLogin.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.d("status", "twitterLogin:success" + result.data.getUserName());
                handleTwitterSession(result.data);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.w("status", "twitterLogin:failure", exception);
                updateUI(null);
            }
        });
    }

    private void signInWithGoogle() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    private void onSignIn(){
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void handleTwitterSession(TwitterSession session) {
        Log.d("twitter session", "handleTwitterSession:" + session);
        mAlerDialog.show();
        AuthCredential credential = TwitterAuthProvider.getCredential(
                session.getAuthToken().token,
                session.getAuthToken().secret);

        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("success", "signInWithCredential:success");
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            Log.i("username",user.getDisplayName()+" ");
                            Log.i("email",user.getEmail()+" ");

                            Log.i("phone number",user.getPhoneNumber()+" ");

                            Log.i("uid",user.getUid()+" ");

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("failure", "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        mAlerDialog.dismiss();
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        mAlerDialog.dismiss();
        if (user != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,resultCode,data);
        mBtnTwitterLogin.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                Log.i("result",result.getSignInAccount().getId()+" ");
                Log.i("result",result.getSignInAccount().getEmail()+" ");
                Log.i("result",result.getSignInAccount().getDisplayName()+" ");


                GoogleSignInAccount acct = result.getSignInAccount();
                String username = acct.getDisplayName();
                String email = acct.getEmail();
                String photoUrl = String.valueOf(acct.getPhotoUrl());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                intent.putExtra("image", photoUrl);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            } else {
                Utils.getInstance().showToast(this,"Something went wrong");
            }
        } else {
            Log.i("error","error occured");
        }

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.linearForgotPassword:
                openActivity(MainActivity.class);
                break;
            case R.id.button_submit:
                if (validateEmailandPassword()){
                   openActivity(SuccessRegisterActivity.class);
                   mEdtEmailAddress.setText("");
                   mEdtPassword.setText("");
                }
                break;
            case R.id.image_fb:
                mBtnFbLogin.performClick();
                facebookLogin();
                break;
            case R.id.image_google:
                onSignIn();
                break;
            case R.id.image_twitter:
                mBtnTwitterLogin.performClick();
                break;

        }
    }

    /**
     * this method is used to validate the email and password
     */
    private boolean validateEmailandPassword() {
        String email = mEdtEmailAddress.getText ().toString ().trim ();
        String password = mEdtPassword.getText ().toString ().trim ();
        boolean valid= true;
        if (TextUtils.isEmpty ( email )) {
            Utils.getInstance().showSnackbar(mScrollViewLogin,getString(R.string.empty_email));
            valid = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher ( email ).matches ()) {
            Utils.getInstance().showSnackbar(mScrollViewLogin,getString(R.string.valid_email));
            valid = false;
        } else if (TextUtils.isEmpty ( password )) {
            Utils.getInstance().showSnackbar(mScrollViewLogin,getString(R.string.empty_password));
            valid = false;
        }
        return valid;
    }
}
