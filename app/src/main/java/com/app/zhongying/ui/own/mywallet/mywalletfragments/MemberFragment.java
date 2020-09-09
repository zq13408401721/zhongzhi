package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.zhongying.R;

public class MemberFragment extends Fragment {

    private TextView member_btn_application;
    private ImageView member_im_one;
    private ImageView member_im_two;
    private ImageView member_im_three;
    private TextView member_btn_experience;

    public MemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_member, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initData() {

    }

    private void initView() {
        member_btn_application = getActivity().findViewById(R.id.member_btn_application);
        member_im_one = getActivity().findViewById(R.id.member_im_one);
        member_im_two = getActivity().findViewById(R.id.member_im_two);
        member_im_three = getActivity().findViewById(R.id.member_im_three);
        member_btn_experience = getActivity().findViewById(R.id.member_btn_experience);
    }
}