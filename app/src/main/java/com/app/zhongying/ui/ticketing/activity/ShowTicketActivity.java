package com.app.zhongying.ui.ticketing.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.ticketing.fragment.DiscountsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ShowTicketActivity extends AppCompatActivity {
    private TabLayout tab_show;
    private ViewPager vp_show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket);
        initView();
    }

    private void initView() {
        tab_show = (TabLayout) findViewById(R.id.tab_show);
        vp_show = (ViewPager) findViewById(R.id.vp_show);
        final List<Fragment> fragments = new ArrayList<>();
        final List<String> titles = new ArrayList<>();
        titles.add("特惠票");
        titles.add("成人票");
        titles.add("优待票");
        titles.add("套票");
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new DiscountsFragment());
        }
        vp_show.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                return titles.get(position);
            }
        });
        tab_show.setupWithViewPager(vp_show);
    }
}
