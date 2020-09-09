package com.app.zhongying.ui.ticketing.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.ticketing.fragment.SelectFragment;
import com.app.zhongying.ui.adapter.SelectVpAdapter;
import com.app.zhongying.ui.adapter.TopVpAdapter;
import com.app.zhongying.ui.ticketing.fragment.ImageFragment;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
    private SelectFragment selectFragment;
    private List<Fragment> fragmentImages;
    private List<String> tabTitles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        EventBus.getDefault().register(this);
        initData();
        initView();
    }

    private void initData() {
        fragmentImages = new ArrayList<>();
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));
        fragmentImages.add(new ImageFragment(R.drawable.ic_launcher_background,this));


        tabTitles = new ArrayList<>();
        tabTitles.add("9月8号");
        tabTitles.add("9月9号");
        tabTitles.add("9月10号");
        tabTitles.add("9月11号");
        tabTitles.add("9月12号");

        fragments = new ArrayList<>();
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        fragments.add(new SelectFragment(this));
        selectFragment = new SelectFragment(this);
        fragments.add(selectFragment);
    }

    StringBuffer stringBuffer = new StringBuffer();
    @Subscribe
    public void onEvent(String event) {
        if (event.equals("[]")){
            tv_location.setText("请选择");
            Toast.makeText(this, "请选择", Toast.LENGTH_SHORT).show();
        }else {
            int length = event.length();
            Log.d(TAG, "onEvent: "+length);
            String substring1 = "";
            String substring2 = "";
            String substring3 = "";
            String substring4 = "";
            String substring5 = "";
            String substring6 = "";
            String substring7 = "";
            String substring8 = "";
            StringBuilder stringBuffer1 = new StringBuilder();
            StringBuilder stringBuffer2 = new StringBuilder();
            StringBuilder stringBuffer3 = new StringBuilder();
            StringBuilder stringBuffer4 = new StringBuilder();
            int count = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            int f = 0;
            int g = 0;
            int h = 0;
            if (event.length()/13 == 1){
                substring1 = event.substring(7, 8);
                substring2 = event.substring(10, 11);
                count = 1;
                int integer1 = Integer.parseInt(substring1);
                int integer2 = Integer.parseInt(substring2);
                a = integer1+1;
                b = integer2+1;
                stringBuffer1.append(a).append("-").append(b).append("、");
            }else if (event.length()/13 == 2){
                substring1 = event.substring(7,8);
                substring2 = event.substring(10, 11);
                substring3 = event.substring(20,21);
                substring4 = event.substring(23,24);
                count = 2;
                int integer1 = Integer.parseInt(substring1);
                int integer2 = Integer.parseInt(substring2);
                int integer3 = Integer.parseInt(substring3);
                int integer4 = Integer.parseInt(substring4);
                a = integer1+1;
                b = integer2+1;
                c = integer3+1;
                d = integer4+1;

                stringBuffer2.append(a).append("-").append(b).append("、")
                .append(c).append("-").append(d).append("、");
            }else if (length/13 == 3){
                substring1 = event.substring(7,8);
                substring2 = event.substring(10, 11);
                substring3 = event.substring(20,21);
                substring4 = event.substring(23,24);
                substring5 = event.substring(33,34);
                substring6 = event.substring(36,37);
                count = 3;
                int integer1 = Integer.parseInt(substring1);
                int integer2 = Integer.parseInt(substring2);
                int integer3 = Integer.parseInt(substring3);
                int integer4 = Integer.parseInt(substring4);
                int integer5 = Integer.parseInt(substring5);
                int integer6 = Integer.parseInt(substring6);
                a = integer1+1;
                b = integer2+1;
                c = integer3+1;
                d = integer4+1;
                e = integer5+1;
                f = integer6+1;

                stringBuffer3.append(a).append("-").append(b).append("、")
                        .append(c).append("-").append(d).append("、")
                .append(e).append("-").append(f).append("、");
            }else if (length/13 == 4){
                substring1 = event.substring(7,8);
                substring2 = event.substring(10, 11);
                substring3 = event.substring(20,21);
                substring4 = event.substring(23,24);
                substring5 = event.substring(33,34);
                substring6 = event.substring(36,37);
                substring7 = event.substring(46,47);
                substring8 = event.substring(49,50);
                count = 4;
                int integer1 = Integer.parseInt(substring1);
                int integer2 = Integer.parseInt(substring2);
                int integer3 = Integer.parseInt(substring3);
                int integer4 = Integer.parseInt(substring4);
                int integer5 = Integer.parseInt(substring5);
                int integer6 = Integer.parseInt(substring6);
                int integer7 = Integer.parseInt(substring7);
                int integer8 = Integer.parseInt(substring8);
                a = integer1+1;
                b = integer2+1;
                c = integer3+1;
                d = integer4+1;
                e = integer5+1;
                f = integer6+1;
                g = integer7+1;
                h = integer8+1;

                stringBuffer4.append(a).append("-").append(b).append("、")
                        .append(c).append("-").append(d).append("、")
                        .append(e).append("-").append(f).append("、")
                .append(g).append("-").append(h).append("、");
            }else{
                boolean b1 = !stringBuffer1.toString().isEmpty();
                boolean b2 = !stringBuffer2.toString().isEmpty();
                boolean b3 = !stringBuffer3.toString().isEmpty();
                boolean b4 = !stringBuffer4.toString().isEmpty();
                if (b1 && b2 && b3 && b4){
                    Toast.makeText(this, "请选择", Toast.LENGTH_SHORT).show();
                    tv_location.setText("请选择");
                    tv_ticket.setText("立即购买");
                }else {
                    Toast.makeText(this, "每人限购四张!", Toast.LENGTH_SHORT).show();
                    tv_ticket.setText("无法购买");
                    tv_location.setText("限购四张");
                }
                ;
            }
            switch (count) {
                case 1:
                    tv_location.setText(stringBuffer1.toString());
                    tv_ticket.setText("立即购买");
                    break;

                case 2:
                    tv_location.setText(stringBuffer2.toString());
                    tv_ticket.setText("立即购买");
                    break;

                case 3:
                    tv_location.setText(stringBuffer3.toString());
                    tv_ticket.setText("立即购买");
                    break;

                case 4:
                    tv_location.setText(stringBuffer4.toString());
                    tv_ticket.setText("立即购买");
                    break;
            }
        }
    };



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




//        selectFragment.setiLoad(new SelectFragment.ILoad() {
//            @Override
//            public void getList(List<Point> data) {
//                if (data!=null){
//                    Log.d(TAG, "getList: "+data.toString());
//                }
//            }
//        });

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