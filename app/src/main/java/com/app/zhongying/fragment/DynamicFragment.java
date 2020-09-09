package com.app.zhongying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.adapter.RecommendAdapter;

import java.util.ArrayList;

public class DynamicFragment extends Fragment {
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_dynamic, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
       rv = inflate.findViewById(R.id.rv);
       rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> list = new ArrayList<>();
        RecommendAdapter recommendAdapter = new RecommendAdapter(list, getActivity());
        rv.setAdapter(recommendAdapter);
    }
}
