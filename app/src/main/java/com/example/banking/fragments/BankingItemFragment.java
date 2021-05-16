package com.example.banking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banking.R;

public class BankingItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String title;
    private String description;
    private int image;

    private TextView txtTitle, txtDescription;
    private ImageView imgImage;


    public BankingItemFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BankingItemFragment newInstance(String title, String description, int image) {
        BankingItemFragment fragment = new BankingItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, description);
        args.putInt(ARG_PARAM3, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            description = getArguments().getString(ARG_PARAM2);
            image = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banking_item, container, false);
        txtTitle = view.findViewById(R.id.item_title_txt);
        txtDescription = view.findViewById(R.id.item_description_txt);
        imgImage = view.findViewById(R.id.item_image_img);
        setData();
        return view;
    }

    private void setData() {
        txtTitle.setText(title);
        txtDescription.setText(description);
        imgImage.setImageResource(image);
    }
}