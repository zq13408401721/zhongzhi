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
import com.app.zhongying.ui.ticketing.fragment.MovieFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {


    private TabLayout movie_tabs;
    private ViewPager movie_vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initView();
    }

    private void initView() {

        movie_tabs = (TabLayout) findViewById(R.id.movie_tabs);
        movie_vp = (ViewPager) findViewById(R.id.movie_vp);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        titles.add("特惠票");
        titles.add("成人票");
        titles.add("优待票");
        titles.add("套票");
        for (int i = 0; i < titles.size() ; i++) {
            fragments.add(new MovieFragment());
        }
        movie_vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        movie_tabs.setupWithViewPager(movie_vp);

    }
    public class MyAdapter extends FragmentPagerAdapter{
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