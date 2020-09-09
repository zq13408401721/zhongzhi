package com.app.zhongying.ui.ticketing.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.app.zhongying.R;
import com.bumptech.glide.Glide;

public class ImageFragment extends Fragment {


    private Integer integer;
    private Context context;
    private ImageView img;

    public ImageFragment(Integer integer, Context context) {
        this.integer = integer;
        this.context = context;
    }


    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        img = view.findViewById(R.id.img);
        Glide.with(context).load(integer).into(img);
    }
}