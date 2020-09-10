package com.app.zhongying.ui.own.meorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.AllOrderAdapter;


public class AllOrderFragment extends Fragment {

    private RecyclerView allorder_rv;
    private Toolbar allorder_toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_all_order, null);
        initView(inflate);
        return inflate;

    }

    private void initView(View inflate) {
        allorder_rv = inflate.findViewById(R.id.allorder_rv);
        allorder_toolbar = inflate.findViewById(R.id.allorder_toolbar);
        allorder_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AllOrderAdapter allOrderAdapter = new AllOrderAdapter(getActivity());
        allorder_rv.setAdapter(allOrderAdapter);
    }
}