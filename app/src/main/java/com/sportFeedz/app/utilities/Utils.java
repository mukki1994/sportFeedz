package com.sportFeedz.app.utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this is singleton class
 * its contains private constructor, we can ensure that no more than one object can be created at a time
 * Created by android on 5/7/18.
 */

public class Utils {
  private static Utils utils;
  private Toast msg;
  private Snackbar mSnackbar;
  //private constructor
  private Utils() {
  }

  public static Utils getInstance(){
    if (utils==null){

      /*This logic will ensure that no more than
	 * one object can be created at a time */
      utils=new Utils ();

    }
    return utils;
  }

  /**
   * Show toast.
   *
   * @param context the context
   * @param toast   String value which needs to shown in the toast.
   * @description if you want to print a toast just call this method and pass
   * what you want to be shown.
   */
  public Toast showToast(Context context, String toast) {
    if (context != null && msg == null || msg.getView().getWindowVisibility() != View.VISIBLE) {
      msg = Toast.makeText(context, toast, Toast.LENGTH_LONG);
      msg.setGravity(Gravity.BOTTOM , 0, 0);
      msg.show();
    }
    return msg;
  }

  public void hideKeyboard(Context ctx) {
    InputMethodManager inputManager = (InputMethodManager) ctx
        .getSystemService(Context.INPUT_METHOD_SERVICE);
    View v = ((Activity) ctx).getCurrentFocus();
    if (v == null)
      return;
    inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
  }

  /**
   * this
   * @param content
   * @param toast
   * @return
   */
  public synchronized Snackbar showSnackbar(View content, String toast) {
    mSnackbar = null;
    if (content != null) {
      mSnackbar = Snackbar.make(content, toast, Snackbar.LENGTH_LONG);
      mSnackbar.setActionTextColor(Color.RED);
      View snackbarView = mSnackbar.getView();
      snackbarView.setBackgroundColor(Color.WHITE);
      TextView textView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
      textView.setTextColor(Color.argb(255,240,78,50));
      mSnackbar.show();
    }
    return mSnackbar;
  }


}
