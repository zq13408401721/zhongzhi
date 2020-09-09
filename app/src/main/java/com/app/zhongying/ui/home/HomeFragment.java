package com.app.zhongying.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.adapter.FeaturedAdapter;
import com.app.zhongying.ui.home.activity.SeekActivity;
import com.app.zhongying.activity.DetailsActivity;
import com.app.zhongying.activity.EventAcitivity;
import com.app.zhongying.activity.MoveActivity;
import com.app.zhongying.activity.PeopleActivity;
import com.app.zhongying.activity.WenBrigadeAcitivity;
import com.app.zhongying.activity.WenCreateActivity;
import com.app.zhongying.adapter.FragmentAdapter;
import com.app.zhongying.fragment.DynamicFragment;
import com.app.zhongying.fragment.ThreeFragment;
import com.app.zhongying.fragment.TwoFragment;
import com.app.zhongying.ui.home.activity.RecommendActivity;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    private ImageView image_taskbar;
    private ImageView image_bei;
    private EditText ed_seek;
    private Banner banner;
    private LinearLayout ll;
    private LinearLayout tuijian;
    private LinearLayout remen;
    private LinearLayout wenchuang;
    private LinearLayout wenlv;
    private LinearLayout yingshi;
    private LinearLayout lll;
    private ImageView image_Event;
    private LinearLayout llll;
    private RecyclerView rv_featured;
    private TabLayout tablayout;
    private ViewPager vp;
    private LinearLayout lllll;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);

        return inflate;

    }

    private static final String TAG = "HomeFragment";

    private void initView(View inflate) {
        ed_seek = inflate.findViewById(R.id.ed_seek);
        banner = inflate.findViewById(R.id.banner);
        tuijian = inflate.findViewById(R.id.tuijian);
        remen = inflate.findViewById(R.id.remen);
        wenchuang = inflate.findViewById(R.id.wenchuang);
        wenlv = inflate.findViewById(R.id.wenlv);
        yingshi = inflate.findViewById(R.id.yingshi);
        image_Event = inflate.findViewById(R.id.image_Event);
        rv_featured = inflate.findViewById(R.id.rv_featured);
        tablayout = inflate.findViewById(R.id.tablayout);
        vp = inflate.findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new DynamicFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());


        vp.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));

        tablayout.setupWithViewPager(vp);
        tablayout.getTabAt(0).setText("行业动态");
        tablayout.getTabAt(1).setText("政策法规");
        tablayout.getTabAt(2).setText("平台公告");
        list = new ArrayList<>();
        rv_featured.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        FeaturedAdapter featuredAdapter = new FeaturedAdapter(getActivity(),list);
        rv_featured.setAdapter(featuredAdapter);

        rv_featured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });
        image_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        yingshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        wenlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        wenchuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        remen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        tuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
            }
        });

        ed_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SeekActivity.class);
                startActivity(intent);
            }


        });

    }
}