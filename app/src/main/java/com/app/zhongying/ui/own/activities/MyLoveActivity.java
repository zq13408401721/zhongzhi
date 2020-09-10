package com.app.zhongying.ui.own.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.VpnManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.zhongying.R;
import com.app.zhongying.adapter.LoveVpAdapter;
import com.app.zhongying.ui.own.fragments.mylefragments.LoveArticleFragment;
import com.app.zhongying.ui.own.fragments.mylefragments.LoveBabyFragment;
import com.app.zhongying.ui.own.fragments.mylefragments.LovePersonalFragment;
import com.app.zhongying.ui.own.fragments.mylefragments.LoveScenicSpotFragment;
import com.app.zhongying.ui.own.fragments.mylefragments.LoveShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyLoveActivity extends AppCompatActivity implements View.OnClickListener {

    private Unbinder unbinder;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_manage)
    TextView tvManage;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rel)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_love);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(this);
        tvManage.setVisibility(View.VISIBLE);
        tvManage.setOnClickListener(this);
        tvTitle.setText("我的收藏");
        List<Fragment> fragments = new ArrayList<>();
        LoveBabyFragment loveBabyFragment = new LoveBabyFragment();
        LoveShopFragment loveShopFragment = new LoveShopFragment();
        LoveArticleFragment loveArticleFragment = new LoveArticleFragment();
        LoveScenicSpotFragment loveScenicSpotFragment = new LoveScenicSpotFragment();
        LovePersonalFragment lovePersonalFragment = new LovePersonalFragment();
        fragments.add(loveBabyFragment);
        fragments.add(loveShopFragment);
        fragments.add(loveArticleFragment);
        fragments.add(loveScenicSpotFragment);
        fragments.add(lovePersonalFragment);
        LoveVpAdapter loveVpAdapter = new LoveVpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(loveVpAdapter);
        tab.setupWithViewPager(vp);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_manage:
                if (relativeLayout.getVisibility() != View.VISIBLE){
                    relativeLayout.setVisibility(View.VISIBLE);
                    tvManage.setText("完成");
                }else {
                    relativeLayout.setVisibility(View.GONE);
                    tvManage.setText("管理");
                }
                break;
        }
    }
}