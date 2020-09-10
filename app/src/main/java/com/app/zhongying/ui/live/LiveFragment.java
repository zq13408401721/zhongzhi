package com.app.zhongying.ui.live;

import android.content.Intent;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;

public class LiveFragment extends Fragment {
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

        view.findViewById(R.id.Live_ImageView_Header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomePageActivity.class);
                startActivity(intent);
            }
        });

        liverv = view.findViewById(R.id.Live_RecyclerView);
        liverv.setLayoutManager(new GridLayoutManager(getContext(),2));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("一条小团团正在直播");
        }
        LiveRvAdapter liveRvAdapter = new LiveRvAdapter(getContext(), strings);
        liverv.setAdapter(liveRvAdapter);
        //rv点击监听
        liveRvAdapter.setOnItemClickListerner(new LiveRvAdapter.onItemClickListerner() {
            @Override
            public void onItemClick(int postion) {
                Intent intent = new Intent(getContext(), StreamingActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.Live_ViewFlipper_i).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StreamingActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.Live_ViewFlipper_ii).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StreamingActivity.class);
                startActivity(intent);
            }
        });
        Button startbtn = view.findViewById(R.id.btn_start);

        //开启直播
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StreamingActivity.class);
                startActivity(intent);
            }
        });
    }
}