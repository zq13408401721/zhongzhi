package com.app.zhongying.ui.adapter;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TopVpAdapter extends FragmentPagerAdapter {

    private List<Fragment> images;

    public TopVpAdapter(@NonNull FragmentManager fm, List<Fragment> images) {
        super(fm);
        this.images = images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = images.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
