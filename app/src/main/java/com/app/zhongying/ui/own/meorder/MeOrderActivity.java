package com.app.zhongying.ui.own.meorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.MeOrderVpAdapter;
import com.app.zhongying.ui.fragment.AftersaleFragment;
import com.app.zhongying.ui.fragment.EvaluateFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MeOrderActivity extends AppCompatActivity {

    private TabLayout order_tb;
    private ViewPager order_vb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_order);
        initView();
    }
    private View selector(String names){
        View inflate = LayoutInflater.from(this).inflate(R.layout.meorder_selector, null);
        TextView selector_tv_name = inflate.findViewById(R.id.selector_tv_name);
        selector_tv_name.setText(names);
        return inflate;
    }
    private void initView() {
        order_tb = (TabLayout) findViewById(R.id.order_tb);
        order_vb = (ViewPager) findViewById(R.id.order_vb);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AllOrderFragment());
        fragments.add(new ObligationFragment());
        fragments.add(new ObligationFragment());
        fragments.add(new ObligationFragment());
        fragments.add(new EvaluateFragment());
        fragments.add(new AftersaleFragment());
        MeOrderVpAdapter meOrderVpAdapter = new MeOrderVpAdapter(getSupportFragmentManager(), fragments);
        order_vb.setAdapter(meOrderVpAdapter);
        order_tb.setupWithViewPager(order_vb);
        order_tb.getTabAt(0).setCustomView(selector("全部订单"));
        order_tb.getTabAt(1).setCustomView(selector("待付款"));
        order_tb.getTabAt(2).setCustomView(selector("待发货"));
        order_tb.getTabAt(3).setCustomView(selector("待收货"));
        order_tb.getTabAt(4).setCustomView(selector("评论"));
        order_tb.getTabAt(5).setCustomView(selector("售后"));

    }
}