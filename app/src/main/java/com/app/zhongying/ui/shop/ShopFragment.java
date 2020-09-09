package com.app.zhongying.ui.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.AftersaleAdapter;

public class ShopFragment extends Fragment {


    private RecyclerView fragment_aftersale_rv;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        /*fragment_aftersale_rv = inflate.findViewById(R.id.fragment_aftersale_rv2);
        fragment_aftersale_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AftersaleAdapter aftersaleAdapter = new AftersaleAdapter(getActivity());
        fragment_aftersale_rv.setAdapter(aftersaleAdapter);*/
    }
}