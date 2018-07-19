package com.special.ResideMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.special.ResideMenu.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * User: special
 * Date: 13-12-10
 * Time: 下午11:05
 * Mail: specialcyci@gmail.com
 */
public class ResideMenuProfileItem extends LinearLayout{

    /** menu item  title */
     TextView mTxtUserName;
     TextView mTxtEmail;
     CircleImageView mImgProfilePic;

    public ResideMenuProfileItem(Context context) {
        super(context);
        initViews(context);
    }

    public ResideMenuProfileItem(Context context, int title) {
        super(context);
        initViews(context);
        //tv_title.setText(title);
    }

    public ResideMenuProfileItem(Context context, int image,String username, String email) {
        super(context);
        initViews(context);
        //tv_title.setText(title);
    }

    private void initViews(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.residemenu_profile_item, this);
        mTxtUserName = findViewById(R.id.text_userName);
        mTxtEmail = findViewById(R.id.text_userEmail);
        mImgProfilePic = findViewById(R.id.image_user_profile);
    }

    public void setTitle(int title){
        //tv_title.setText(title);
    }


    public void setTitle(String title){
        //tv_title.setText(title);
    }


}
