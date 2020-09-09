package com.app.zhongying.ui.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.adapter.FragmentVpAdapter;
import com.app.zhongying.ui.home.fragments.CulturalFragment;
import com.app.zhongying.ui.home.fragments.HotFragment;
import com.app.zhongying.ui.home.fragments.RecommendFragment;
import com.app.zhongying.ui.home.fragments.TelevisionFragment;
import com.app.zhongying.ui.home.fragments.WenbrigadeFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RecommendActivity extends AppCompatActivity {

    private ImageView img_fanhui;
    private TextView tv_title;
    private ImageView img_cehua;
    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private LinearLayout ctl;
    private NavigationView nv;
    private DrawerLayout dl;
    private ArrayList<Integer> list;
    private ArrayList<Fragment> fragments;
    private FragmentVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        initView();
    }

    private void initView() {
        img_fanhui = (ImageView) findViewById(R.id.img_fanhui);
        tv_title = (TextView) findViewById(R.id.tv_title);
        img_cehua = (ImageView) findViewById(R.id.img_cehua);
        banner = (Banner) findViewById(R.id.banner);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        ctl = (LinearLayout) findViewById(R.id.ctl);
        nv = (NavigationView) findViewById(R.id.nv);
        dl = (DrawerLayout) findViewById(R.id.dl);
        img_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        img_cehua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl.openDrawer(Gravity.RIGHT);
            }
        });

        list = new ArrayList<>();
        list.add(R.drawable.banner1);
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner3);
        banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        RoundedCorners roundedCorners = new RoundedCorners(10);
                        RequestOptions override = RequestOptions.bitmapTransform(roundedCorners).override(100, 100);
                        Glide.with(context).load(path).apply(override).into(imageView);
                    }
                })
                .setDelayTime(2000)
                .start();
        fragments = new ArrayList<Fragment>();
        fragments.add(new RecommendFragment());
        fragments.add(new HotFragment());
        fragments.add(new CulturalFragment());
        fragments.add(new WenbrigadeFragment());
        fragments.add(new TelevisionFragment());
        adapter = new FragmentVpAdapter(getSupportFragmentManager(), 0, fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("推荐");
        tab.getTabAt(1).setText("热门");
        tab.getTabAt(2).setText("文创");
        tab.getTabAt(3).setText("文旅");
        tab.getTabAt(4).setText("影视");
    }



}
