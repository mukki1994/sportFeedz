package com.sportFeedz.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;


public class MyApplication extends MultiDexApplication {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        try {
            if (!FirebaseApp.getApps(this).isEmpty()){
                FirebaseApp.initializeApp(this);
            }

            TwitterAuthConfig authConfig =  new TwitterAuthConfig(
                    getString(R.string.twitter_api_key),
                    getString(R.string.twitter_api_secret));

            TwitterConfig twitterConfig = new TwitterConfig.Builder(this)
                    .twitterAuthConfig(authConfig)
                    .build();

            Twitter.initialize(twitterConfig);

        } catch (Exception e) {
        }
    }

    public static Context getInstance() {
        return mInstance;
    }
}