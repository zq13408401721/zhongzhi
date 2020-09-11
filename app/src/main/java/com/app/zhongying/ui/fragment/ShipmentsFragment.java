package com.app.zhongying.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.EvaluateAdapter;
import com.app.zhongying.ui.adapter.OrderAdapter;

//待收货
public class ShipmentsFragment extends BaseFragment {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        RecyclerView shipments_rv = view.findViewById(R.id.shipments_rv);
       /* shipments_rv.setLayoutManager(new GridLayoutManager(context,2));
        EvaluateAdapter evaluateAdapter = new EvaluateAdapter(context);
        shipments_rv.setAdapter(evaluateAdapter);*/

        shipments_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        OrderAdapter orderAdapter = new OrderAdapter(getActivity());
        shipments_rv.setAdapter(orderAdapter);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment_shipments;
    }
}