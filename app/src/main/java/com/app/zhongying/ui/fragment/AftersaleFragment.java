package com.app.zhongying.ui.fragment;

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
import com.app.zhongying.ui.adapter.AftersaleAdapter;

public class AftersaleFragment extends Fragment {
    private RecyclerView fragment_aftersale_rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aftersale, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        fragment_aftersale_rv = view.findViewById(R.id.fragment_aftersale_rv);
        fragment_aftersale_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AftersaleAdapter aftersaleAdapter = new AftersaleAdapter(getActivity());
        fragment_aftersale_rv.setAdapter(aftersaleAdapter);
    }
}
