package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.zhongying.R;

public class BindingFragment extends Fragment {

    private ImageView binding_im_gary;
    private ImageView binding_im_add;
    //private RecyclerView binding_rv;

    public BindingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_binding, container, false);

        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        //RecycleView自条目 item_binding_rv
        //添加银行卡的Activity是BankAddActivity

    }

    private void initView() {
        //binding_rv = getActivity().findViewById(R.id.binding_rv);
        binding_im_add = getActivity().findViewById(R.id.binding_im_add);
        binding_im_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),BankAddActivity.class));
            }
        });
    }
}