package com.example.banking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.banking.adapters.OnBoardAdapter;
import com.example.banking.fragments.BankingItemFragment;
import com.example.banking.model.OnBoardModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.banking.R.drawable.item_start;

public class BankingActivity extends AppCompatActivity {

    private ViewPager pager;
    private OnBoardAdapter adapter;
    TabLayout tadIndicator;
    Button btn_next, btn_next_white, btn_start;
    View fon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        pager = findViewById(R.id.vp_banking);
        btn_next = findViewById(R.id.btn_next);
        btn_next_white = findViewById(R.id.btn_next_white);
        btn_start = findViewById(R.id.btn_start);
        tadIndicator = findViewById(R.id.tad_indicator);
        initButtons();
        fon = findViewById(R.id.fon);
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
                    btn_next.setVisibility(View.VISIBLE);
                } else {
                    btn_next.setVisibility(View.GONE);
                }

                if (position == 2) {
                    btn_next_white.setVisibility(View.VISIBLE);

                } else {
                    btn_next_white.setVisibility(View.GONE);
                }

                if (position >= 1) {
                    fon.setVisibility(View.GONE);
                } else {
                    btn_next.setVisibility(View.GONE);
                    fon.setVisibility(View.VISIBLE);
                }

                if (position == 3) {
                    btn_start.setVisibility(View.VISIBLE);
                } else {
                    btn_start.setVisibility(View.GONE);
                }

                if (position != 0) {
                    tadIndicator.setVisibility(View.VISIBLE);
                } else {
                    tadIndicator.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BankingActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(pager.getCurrentItem() + 1);
                    }
                });
                btn_next_white.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(pager.getCurrentItem() + 1);
                    }
                });
            }
        });
    }

    private void initButtons() {

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