package com.sportFeedz.app.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.sportFeedz.app.R;
import com.sportFeedz.app.activity.CreateLimitedUserActivity;
import com.sportFeedz.app.adapter.SelectGamesSpinnerAdapter;
import com.sportFeedz.app.adapter.SelectPlayersSpinnerAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartNewGameFragment extends BaseFragment implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    private Spinner mSpinnerPlayersName;
    private Spinner mSpinnerGameName;
    private TextView mTxtSelectPlayers;
    private TextView mTxtAddPlayers;
    private TextView mTxtCreateLimitedUser;
    private TextView mTxtSelectGames;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_new_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setListener();
        setSpannable();
        ArrayList<String> spinnerAdapterData = new ArrayList<>();
        String[] spinnerItemsArray = getResources().getStringArray(R.array.items);
        Collections.addAll(spinnerAdapterData, spinnerItemsArray);
        SelectPlayersSpinnerAdapter adapter = new SelectPlayersSpinnerAdapter(getActivity(), R.layout.item_players_spinner, spinnerAdapterData, getResources());
        mSpinnerPlayersName.setAdapter(adapter);
        mSpinnerPlayersName.setOnItemSelectedListener(this);


        ArrayList<String> spinnerAdapterRecords = new ArrayList<>();
        String[] spinnerAdapterRecord = getResources().getStringArray(R.array.gameName);
        Collections.addAll(spinnerAdapterRecords, spinnerAdapterRecord);
        SelectGamesSpinnerAdapter selectGamesSpinnerAdapter = new SelectGamesSpinnerAdapter(getActivity(), R.layout.item_players_spinner, spinnerAdapterRecords, getResources());
        mSpinnerGameName.setAdapter(selectGamesSpinnerAdapter);
        mSpinnerGameName.setOnItemSelectedListener(this);
    }

    private void init(View view){
        mSpinnerPlayersName = view.findViewById(R.id.spinner_players_name);
        mTxtSelectPlayers = view.findViewById(R.id.text_select_players);
        mTxtAddPlayers = view.findViewById(R.id.text_addPlayers);
        mTxtCreateLimitedUser = view.findViewById(R.id.text_addLimitedUser);
        mSpinnerGameName = view.findViewById(R.id.spinner_gameName);
        mTxtSelectGames = view.findViewById(R.id.text_select_games);
    }

    private void setListener(){
        mTxtSelectPlayers.setOnClickListener(this);
        mTxtSelectGames.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_select_players:
                mSpinnerPlayersName.performClick();
                break;
            case R.id.text_select_games:
                mSpinnerGameName.performClick();
        }
    }

    private void setSpannable(){
        SpannableStringBuilder spannableString = new SpannableStringBuilder(getString(R.string.click_here_to_add));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)), 65, 68, 0);
        mTxtAddPlayers.setText(spannableString);
        SpannableStringBuilder spannableCreateLimitedUser = new SpannableStringBuilder(getString(R.string.add_a_limited_user));
        spannableCreateLimitedUser.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)), 110, 128
                , 0);
        mTxtCreateLimitedUser.setText(spannableCreateLimitedUser);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(getContext(), CreateLimitedUserActivity.class);
                startActivity(intent);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        spannableCreateLimitedUser.setSpan(clickableSpan, 110, 128, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTxtCreateLimitedUser.setText(spannableCreateLimitedUser);
        mTxtCreateLimitedUser.setMovementMethod(LinkMovementMethod.getInstance());
        mTxtCreateLimitedUser.setHighlightColor(Color.TRANSPARENT);



      /*
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getContext(), CreateLimitedUserActivity.class);
                startActivity(intent);
            }
        };
        spannableCreateLimitedUser.setSpan(clickableSpan, 110, 128, 0);*/
    }
}
