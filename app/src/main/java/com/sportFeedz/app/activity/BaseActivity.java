package com.sportFeedz.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.sportFeedz.app.R;
import com.wang.avi.AVLoadingIndicatorView;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    //git remote add origin https://github.com/mukku1994/recyclerTest.git
    public void openActivity( Class c){
        Intent intent = new Intent(this,c) ;
        startActivity(intent);
    }

    public AlertDialog showLoadingProgress(Activity context) {
        final  AlertDialog alertDialog ;
        final AlertDialog.Builder builder;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog_progress_bar,null,false);
        AVLoadingIndicatorView avLoadingIndicatorView = (AVLoadingIndicatorView)layout.findViewById(R.id.progress_avi);
        avLoadingIndicatorView.show();
        builder = new AlertDialog.Builder(context, R.style.NewDialog);
        builder.setView(layout);
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return alertDialog;
    }

    public void changeFragment(Fragment targetFragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, targetFragment, "fragments")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }


}
