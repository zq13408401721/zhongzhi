package com.app.zhongying.ui.ticketing.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.ticketing.fragment.AdultTicketFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ScenicSpotActivity extends AppCompatActivity {
    private TabLayout tab_scenic;
    private ViewPager vp_scenic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenic_spot);
        initView();
    }

    private void initView() {
        tab_scenic = (TabLayout) findViewById(R.id.tab_scenic);
        vp_scenic = (ViewPager) findViewById(R.id.vp_scenic);
        final List<Fragment> fragments = new ArrayList<>();
        final List<String> titles = new ArrayList<>();
        titles.add("特惠票");
        titles.add("成人票");
        titles.add("优待票");
        titles.add("套票");
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new AdultTicketFragment());
        }
        vp_scenic.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tab_scenic.setupWithViewPager(vp_scenic);
    }
}
