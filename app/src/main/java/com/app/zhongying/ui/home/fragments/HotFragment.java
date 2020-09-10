package com.app.zhongying.ui.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.adapter.RecommendAdapter;

import java.util.ArrayList;

public class HotFragment extends Fragment {


    private RecyclerView mRcy;
    private RecommendAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(inflate);
        return inflate;

    }

    private void initView(View inflate) {
        mRcy = inflate.findViewById(R.id.rcy);
        mRcy.setLayoutManager(new GridLayoutManager(getContext(),2));
        ArrayList<String> list = new ArrayList<>();
        adapter = new RecommendAdapter(list, getActivity());
        mRcy.setAdapter(adapter);
    }
}