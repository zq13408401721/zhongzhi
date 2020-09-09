package com.app.zhongying.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.ShoppingActivity;

import butterknife.BindView;

public class ShopFragment extends Fragment {


    @BindView(R.id.btn_click)
    Button btnClick;
    private RecyclerView fragment_aftersale_rv;

    public ShopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {

        btnClick = inflate.findViewById(R.id.btn_click);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ShoppingActivity.class));
            }
        });
    }
}