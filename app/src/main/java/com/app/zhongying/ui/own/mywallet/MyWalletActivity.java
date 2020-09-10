package com.app.zhongying.ui.own.mywallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.own.mywallet.mywalletfragments.BalanceFragment;
import com.app.zhongying.ui.own.mywallet.mywalletfragments.BindingFragment;
import com.app.zhongying.ui.own.mywallet.mywalletfragments.DetailsFragment;
import com.app.zhongying.ui.own.mywallet.mywalletfragments.IntegralFragment;
import com.app.zhongying.ui.own.mywallet.mywalletfragments.MemberFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyWalletActivity extends AppCompatActivity {

    private ImageView back;
    private TabLayout wallet_tab;
    private ViewPager wallet_vp;
    private ArrayList<String> tabtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initView();
        initData();
    }

    private void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tabtitle = new ArrayList<>();
        tabtitle.add("我的积分");
        tabtitle.add("我的余额");
        tabtitle.add("会员中心");
        tabtitle.add("钱包明细");
        tabtitle.add("支付绑定");
        ArrayList<Fragment> tabfragment = new ArrayList<>();
        tabfragment.add(new IntegralFragment());
        tabfragment.add(new BalanceFragment());
        tabfragment.add(new MemberFragment());
        tabfragment.add(new DetailsFragment());
        tabfragment.add(new BindingFragment());
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabtitle, tabfragment);
        wallet_vp.setAdapter(tabAdapter);
        wallet_vp.setCurrentItem(0);
        wallet_vp.setOffscreenPageLimit(3);
        wallet_tab.setupWithViewPager(wallet_vp);

        for (int i = 0; i < wallet_tab.getTabCount(); i++) {
            TabLayout.Tab tabAt = wallet_tab.getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView(getTabView(i));
            }
        }

        wallet_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //在这里可以设置选中状态下  tab字体显示样式
                wallet_vp.setCurrentItem(tab.getPosition());
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(15);
                    ((TextView) view).setTextColor(ContextCompat.getColor(MyWalletActivity.this, R.color.wallet_tab_selected));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(14);
                    ((TextView) view).setTextColor(ContextCompat.getColor(MyWalletActivity.this, R.color.wallet_tab_noselected));
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Intent intent = getIntent();
        if (intent.hasExtra("id")==true){
            wallet_tab.getTabAt(intent.getIntExtra("id",-1)).select();
        }
    }

    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_tab, null);
        TextView textView = (TextView) view.findViewById(R.id.tab_item_textview);
        textView.setText(tabtitle.get(currentPosition));
        return view;
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        wallet_tab = (TabLayout) findViewById(R.id.wallet_tab);
        wallet_vp = (ViewPager) findViewById(R.id.wallet_vp);
    }

    class TabAdapter extends FragmentPagerAdapter {
        private ArrayList<String> strings;
        private ArrayList<Fragment> fragments;

        public TabAdapter(@NonNull FragmentManager fm, ArrayList<String> strings, ArrayList<Fragment> fragments) {
            super(fm);
            this.strings = strings;
            this.fragments = fragments;
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
            return strings.get(position);
        }
    }
}