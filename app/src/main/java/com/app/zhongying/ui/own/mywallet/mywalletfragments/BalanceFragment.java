package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.zhongying.R;


public class BalanceFragment extends Fragment {

    private ImageView balance_im_one;
    private TextView tv_total_assets;
    private TextView tv_balance;
    private TextView tv_available_balance;
    private TextView balance_btn_topups;
    private TextView balance_btn_cash;

    public BalanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_balance, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
    }

    private void initView() {
        ImageView balance_im_one = getActivity().findViewById(R.id.balance_im_one);
        TextView tv_total_assets = getActivity().findViewById(R.id.tv_total_assets);
        TextView tv_topup_balance = getActivity().findViewById(R.id.tv_topup_balance);
        TextView tv_available_balance = getActivity().findViewById(R.id.tv_available_balance);
        TextView balance_btn_topups = getActivity().findViewById(R.id.balance_btn_topups);
        TextView balance_btn_cash = getActivity().findViewById(R.id.balance_btn_cash);
        //balance_rv = (RecyclerView) getActivity().findViewById(R.id.balance_rv);
    }
}