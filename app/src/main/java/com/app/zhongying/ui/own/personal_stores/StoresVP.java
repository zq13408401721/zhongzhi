package com.app.zhongying.ui.own.personal_stores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StoresVP extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    public StoresVP(@NonNull FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        List<String> list1=new ArrayList<>();
        list1.add("综合");
        list1.add("销量");
        list1.add("新品");
        return list1.get(position);

    }
}
