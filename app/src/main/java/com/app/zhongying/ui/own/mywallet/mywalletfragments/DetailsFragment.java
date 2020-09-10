package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

public class DetailsFragment extends Fragment {

    //private RecyclerView details_rv;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_details, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
        //RecycleVew 自条目可复用item_balance_rv
    }

    private void initView() {
        //details_rv = getActivity().findViewById(R.id.details_rv);
    }
}