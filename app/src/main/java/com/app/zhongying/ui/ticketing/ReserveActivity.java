package com.app.zhongying.ui.ticketing;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ReserveActivity extends AppCompatActivity{

    public List<Point> data = new ArrayList<>();
    private ImageView img_back;
    private ViewPager TopVp;
    private TabLayout tab;
    private ViewPager vp;
    private TextView tv_location;
    private TextView tv_ticket;
    private TextView tv_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        initView();
    }

    private void initView() {

        img_back = (ImageView) findViewById(R.id.img_back);
        TopVp = (ViewPager) findViewById(R.id.topVp);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        tv_location = (TextView) findViewById(R.id.tv_location);
        tv_ticket = (TextView) findViewById(R.id.tv_ticket);
        tv_count = (TextView) findViewById(R.id.tv_count);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        List<Fragment> fragmentImages = new ArrayList<>();
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));

        TopVpAdapter topVpAdapter = new TopVpAdapter(getSupportFragmentManager(), fragmentImages);
        TopVp.setAdapter(topVpAdapter);
        TopVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_count.setText((position+1)+"/5");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("9月8号");
        tabTitles.add("9月9号");
        tabTitles.add("9月10号");
        tabTitles.add("9月11号");
        tabTitles.add("9月12号");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        SelectFragment selectFragment = new SelectFragment(this);
        fragments.add(selectFragment);

        selectFragment.setiLoad(new SelectFragment.ILoad() {
            @Override
            public void getList(List<Point> data) {
                if (data!=null){
                    Log.d(TAG, "getList: "+data.toString());
                }
            }
        });

        SelectVpAdapter vpAdapter = new SelectVpAdapter(getSupportFragmentManager(), tabTitles, fragments);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
//        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                String string = tab.getText().toString();
//                View customView = tab.getCustomView();
//                if (null!=customView && customView instanceof  TextView){
//                    ((TextView)customView).setTextSize(18);
//                    ((TextView) customView).setTextColor(ContextCompat.getColor(ReserveActivity.this,R.color.colorYes));
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                View view = tab.getCustomView();
//                if (null != view && view instanceof TextView) {
//                    // 改变 tab 未选择状态下的字体大小
//                    ((TextView) view).setTextSize(18);
//                    // 改变 tab 未选择状态下的字体颜色
//                    ((TextView) view).setTextColor(ContextCompat.getColor(ReserveActivity.this, R.color.colorNo));
//                }
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    private static final String TAG = "ReserveActivity";

    public void setData(List<Point> list) {
        Log.d(TAG, "initView: "+list.size());
    }
}