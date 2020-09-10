package com.app.zhongying.ui.live.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyFansFragment extends Fragment {

    @BindView(R.id.rlvFans)
    RecyclerView rlvFans;
    private View view;
    private RlvFansAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_fans, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        rlvFans.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("关注我快快快");
        }
        RlvFansAdapter adapter = new RlvFansAdapter(strings, getContext());
        rlvFans.setAdapter(adapter);
    }
}