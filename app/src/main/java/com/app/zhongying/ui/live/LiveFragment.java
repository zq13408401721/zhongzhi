package com.app.zhongying.ui.live;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;

public class LiveFragment extends Fragment {
    private ImageView titleLayoutLeftImage;
    private ImageView titleLayoutRightImage;
    private TextView titleLayoutMiddenText;
    private Toolbar titleLayoutToolbar;
    private RecyclerView liverv;

    public LiveFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        View title = view.findViewById(R.id.title_live);
        titleLayoutLeftImage = title.findViewById(R.id.title_layout_left_image);
        titleLayoutMiddenText = title.findViewById(R.id.title_layout_midden_text);
        titleLayoutToolbar = title.findViewById(R.id.title_layout_toolbar);
        titleLayoutRightImage = title.findViewById(R.id.title_layout_right_image);

        titleLayoutLeftImage.setVisibility(View.GONE);//隐藏返回按钮
        titleLayoutRightImage.setVisibility(View.VISIBLE);//展示右边清单按钮
        titleLayoutMiddenText.setVisibility(View.VISIBLE);//展示中间的text
        titleLayoutMiddenText.setText("直播");
        titleLayoutMiddenText.setTextColor(Color.BLACK);
        titleLayoutMiddenText.setTextSize(16);
        liverv = view.findViewById(R.id.rv_live);
        liverv.setLayoutManager(new GridLayoutManager(getContext(),2));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            strings.add("一条小团团正在直播");
        }
        LiveRvAdapter liveRvAdapter = new LiveRvAdapter(getContext(), strings);
        liverv.setAdapter(liveRvAdapter);
        //rv点击监听
        liveRvAdapter.setOnItemClickListerner(new LiveRvAdapter.onItemClickListerner() {
            @Override
            public void onItemClick(int postion) {

            }
        });
        View tz1 = view.findViewById(R.id.tz1);
        View tz2 = view.findViewById(R.id.tz2);
        //通知点击监听
        tz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        View own = view.findViewById(R.id.own_live);
        ImageView header = own.findViewById(R.id.header_jianjie);
        Button startbtn = own.findViewById(R.id.btn_start);
        //头像点击监听
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //开启直播
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}