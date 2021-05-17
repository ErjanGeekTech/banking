package com.example.banking.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.banking.fragments.BankingItemFragment;
import com.example.banking.model.OnBoardModel;

import java.util.ArrayList;
import java.util.List;

public class OnBoardAdapter extends FragmentStatePagerAdapter {

    List<OnBoardModel> list = new ArrayList<>();
    FragmentManager manager;

    public OnBoardAdapter(@NonNull FragmentManager fm, List<OnBoardModel> list) {
        super(fm);
        this.manager = fm;
        this.list = list;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new BankingItemFragment();
        switch (position){
            case 1:
                fragment = BankingItemFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
                break;
            case 2:
                fragment = BankingItemFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
                break;
            case 3:
                fragment = BankingItemFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
