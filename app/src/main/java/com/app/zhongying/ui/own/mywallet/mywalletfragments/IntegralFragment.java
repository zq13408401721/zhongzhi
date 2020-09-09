package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

public class IntegralFragment extends Fragment {

    private ImageView integral_im_one;
    private TextView tv_myintegral;
    private TextView tv_integral_num;
    private ImageView integral_im_two;
    private ImageView integral_im_three;
   //private RecyclerView integral_rv;

    public IntegralFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_integral, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
    }

    private void initView() {
        integral_im_one = (ImageView) getActivity().findViewById(R.id.integral_im_one);
        tv_integral_num = (TextView) getActivity().findViewById(R.id.tv_integral_num);
        integral_im_two = (ImageView) getActivity().findViewById(R.id.integral_im_two);
        integral_im_three = (ImageView) getActivity().findViewById(R.id.integral_im_three);
        //integral_rv = (RecyclerView) getActivity().findViewById(R.id.integral_rv);
    }
}