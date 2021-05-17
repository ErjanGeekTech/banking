package com.example.banking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banking.adapters.OnBoardAdapter;
import com.example.banking.model.OnBoardModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BankingActivity extends AppCompatActivity {

    private ViewPager pager;
    private OnBoardAdapter adapter;
    TabLayout tadIndicator;
    Button btn_next, btn_white_next;
   TextView txt_swiftza, txt_digital;
   Button btn_getStarted;
   View view;
   View fon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        pager = findViewById(R.id.vp_banking);
        btn_next = findViewById(R.id.btn_next);
        btn_white_next = findViewById(R.id.btn_next_white);
        tadIndicator = findViewById(R.id.tad_indicator);
        txt_swiftza = findViewById(R.id.txt_swiftza);
        txt_digital = findViewById(R.id.txt_digital);
        btn_getStarted = findViewById(R.id.btn_getStarted);
        fon = findViewById(R.id.fon);
        view = findViewById(R.id.view);
//        checkShowingOnBoard();
        List<OnBoardModel> list = new ArrayList<>();
        list.add(new OnBoardModel("", "", 0));
        list.add(new OnBoardModel("Smart Wallet", "Managing your money can be the easiest thing you do all day.", R.drawable.wallet));
        list.add(new OnBoardModel("Effortless Budgeting", "Customize your budget categories and stay on top of your spending 24/7.", R.drawable.mony));
        list.add(new OnBoardModel("Automatic Savings", "Set your savings goal, and let Empower figure out how to get you there.", R.drawable.piggy));
        adapter = new OnBoardAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);
        tadIndicator.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    btn_next.setText("next");
                    btn_next.setVisibility(View.VISIBLE);
                } else {
                    btn_next.setVisibility(View.GONE);
                }

                if (position == 2) {
                    btn_white_next.setVisibility(View.VISIBLE);
                } else {
                    btn_white_next.setVisibility(View.GONE);
                }

                if (position >= 1){
                    fon.setVisibility(View.GONE);
                }else {
                    fon.setVisibility(View.VISIBLE);
                }

                if (position == 3) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_next.setText("start");
                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(BankingActivity.this, MainActivity.class);
                            startActivity(intent);
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(BankingActivity.this);
                            preferences.edit().putBoolean("showOnBoard", true).apply();
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

//    private void checkShowingOnBoard() {
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(BankingActivity.this);
//        Boolean showOnBoard = preferences.getBoolean("showOnBoard", false);
//        if (showOnBoard) {
//            Intent intent = new Intent(BankingActivity.this, MainActivity.class);
//            startActivity(intent);
//        }
//    }
}