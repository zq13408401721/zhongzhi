package com.app.zhongying.ui.own;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.own.fragment.store.AddProductFragment;
import com.app.zhongying.ui.own.fragment.store.SellProductFragment;
import com.app.zhongying.ui.own.fragment.store.WarehouseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductManageActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewPage)
    ViewPager viewPage;

    String[] tabs = {"添加商品", "出售中", "下架商品", "仓库中", "已售完"};

    private ArrayList<Fragment> fragments;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_manage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        toolbarTitle.setText("产品管理");

        fragments = new ArrayList<>();
        fragments.add(new AddProductFragment());
        fragments.add(new SellProductFragment());
        fragments.add(new OutOfPrintFragment());
        fragments.add(new WarehouseFragment());
        fragments.add(new OutOfPrintFragment());

        viewPage.setAdapter(new ViewPageAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPage);

        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);

        if (intent.hasExtra("id")==true){
            tab.getTabAt(id).select();
        }


    }


    @OnClick(R.id.iv_back)
    public void onClickListener(View view) {
        finish();
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}