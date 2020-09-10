package com.app.zhongying.ui.ticketing.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.app.zhongying.R;
import com.app.zhongying.ui.ticketing.fragment.HotelFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {

    private TabLayout hotel_tabs;
    private ViewPager hotel_vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        initView();
    }

    private void initView() {
        hotel_tabs = (TabLayout) findViewById(R.id.hotel_tabs);
        hotel_vp = (ViewPager) findViewById(R.id.hotel_vp);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        titles.add("特惠票");
        titles.add("成人票");
        titles.add("优待票");
        titles.add("套票");
        for (int i = 0; i < titles.size() ; i++) {
            fragments.add(new HotelFragment());
        }

        hotel_vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        hotel_tabs.setupWithViewPager(hotel_vp);

    }
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(@NonNull FragmentManager fm) {
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
            return titles.get(position);
        }
    }

}