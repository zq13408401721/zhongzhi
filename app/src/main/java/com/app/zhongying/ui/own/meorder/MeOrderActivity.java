package com.app.zhongying.ui.own.meorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.MeOrderVpAdapter;
import com.app.zhongying.ui.fragment.AftersaleFragment;
import com.app.zhongying.ui.fragment.EvaluateFragment;
import com.app.zhongying.ui.fragment.ReceivingFragment;
import com.app.zhongying.ui.fragment.ShipmentsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MeOrderActivity extends AppCompatActivity {

    private TabLayout order_tb;
    private ViewPager order_vp;
    private List<String> tabTitle;
    private Toolbar toolbar;
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_set;
    private TextView tv_over;
    private ImageView iv_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_order);
        initView();
    }




    private void initView() {
        order_tb = (TabLayout) findViewById(R.id.order_tb);
        order_vp = (ViewPager) findViewById(R.id.order_vp);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_set = (TextView) findViewById(R.id.tv_set);
        tv_over = (TextView) findViewById(R.id.tv_over);
        iv_navigation = (ImageView) findViewById(R.id.iv_navigation);
        tv_title.setText("我的订单");
        iv_navigation.setVisibility(View.GONE);

        tabTitle = new ArrayList<>();
        tabTitle.add("全部订单");
        tabTitle.add("待付款");
        tabTitle.add("待发货");
        tabTitle.add("待收货");
        tabTitle.add("评论");
        tabTitle.add("售后");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AllOrderFragment());
        fragments.add(new ObligationFragment());
        fragments.add(new ReceivingFragment());
        fragments.add(new ShipmentsFragment());
        fragments.add(new EvaluateFragment());
        fragments.add(new AftersaleFragment());

        MeOrderVpAdapter meOrderVpAdapter = new MeOrderVpAdapter(getSupportFragmentManager(), fragments, tabTitle);
        order_vp.setAdapter(meOrderVpAdapter);


        order_tb.setupWithViewPager(order_vp);


        order_vp.setCurrentItem(0);
        order_vp.setOffscreenPageLimit(3);

        for (int i = 0; i < order_tb.getTabCount(); i++) {
            TabLayout.Tab tabAt = order_tb.getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView(getTabView(i));
            }
        }

        View view = order_tb.getTabAt(0).getCustomView();
        if (null != view && view instanceof TextView) {
            ((TextView) view).setTextColor(ContextCompat.getColor(MeOrderActivity.this, R.color.colorred));
        }
        order_tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                CharSequence text = tab.getText();
                tv_title.setText(text);

                //在这里可以设置选中状态下  tab字体显示样式
                order_vp.setCurrentItem(tab.getPosition());
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextColor(ContextCompat.getColor(MeOrderActivity.this, R.color.colorred));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextColor(ContextCompat.getColor(MeOrderActivity.this, R.color.white));
                }

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(this).inflate(R.layout.meorder_selector, null);
        TextView selector_tv_name = (TextView) view.findViewById(R.id.selector_tv_name);
        selector_tv_name.setText(tabTitle.get(currentPosition));
        return view;
    }
}