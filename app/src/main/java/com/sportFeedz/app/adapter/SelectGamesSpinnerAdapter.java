package com.sportFeedz.app.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sportFeedz.app.R;

import java.util.ArrayList;


public class SelectGamesSpinnerAdapter extends ArrayAdapter<String> {

    private ArrayList mData;
    public Resources mResources;
    private LayoutInflater mInflater;


    public SelectGamesSpinnerAdapter(Activity activitySpinner, int textViewResourceId, ArrayList objects,
                                       Resources resLocal
    ) {
        super(activitySpinner, textViewResourceId, objects);

        mData = objects;
        mResources = resLocal;
        mInflater = (LayoutInflater) activitySpinner.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = mInflater.inflate(R.layout.item_players_spinner, parent, false);
        return row;
    }
}
