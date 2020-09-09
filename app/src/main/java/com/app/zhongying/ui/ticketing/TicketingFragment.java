package com.app.zhongying.ui.ticketing;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.DataAdapter;
import com.app.zhongying.ui.adapter.VpAdapter;
import com.app.zhongying.ui.ticketing.fragment.AFragment;
import com.app.zhongying.ui.ticketing.fragment.BFragment;
import com.app.zhongying.ui.ticketing.fragment.CFragment;
import com.app.zhongying.ui.ticketing.fragment.DFragment;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TicketingFragment extends Fragment implements View.OnClickListener {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private ImageView mImg;
    private RecyclerView mRecycler;
    private Button btn_click;
    private NavigationView mNavigation;
    private DrawerLayout mDrawer;

    public TicketingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_ticketing, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        banner = (Banner) view.findViewById(R.id.banner);
        tab = (TabLayout) view.findViewById(R.id.tab);
        vp = (ViewPager) view.findViewById(R.id.vp);
        mImg = (ImageView) view.findViewById(R.id.iv_img);
        mRecycler = (RecyclerView) view.findViewById(R.id.mRecycler);
        btn_click = (Button) view.findViewById(R.id.btn_click);
        mNavigation = (NavigationView) view.findViewById(R.id.mNavigation);
        mDrawer = (DrawerLayout) view.findViewById(R.id.mDrawer);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        titles = new ArrayList<>();
        titles.add("景点门票");
        titles.add("演出门票");
        titles.add("电影票");
        titles.add("酒店预订");

        /*tab.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tab, 5, 5);
//                SetIndicator.setIndicator(tabLive,5,5);
            }
        });*/


        //创建适配器
        VpAdapter vpAdapter = new VpAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        initCeHua();
        initbanner();
    }

    //侧滑
    private void initCeHua() {
        btn_click.setOnClickListener(this);
        mImg.setOnClickListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawer, null, R.string.app_name, R.string.app_name);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                int right = drawerView.getRight();
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                mDrawer.setAlpha(1);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        List<String> data = new ArrayList<>();
        data.clear();
        for (int i = 0; i < 10; i++) {
            data.add("啦啦啦" + i);
        }

        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        DataAdapter dataAdapter = new DataAdapter(getActivity());
        mRecycler.setAdapter(dataAdapter);
        dataAdapter.addData(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:

                break;
            case R.id.iv_img:
                mDrawer.openDrawer(Gravity.RIGHT);
                mNavigation.getBackground().setAlpha(1);
                break;
        }
    }

    /**
     * dp转px
     **/
    public int dip2px(int dipValue) {
        float reSize = getResources().getDisplayMetrics().density;
        return (int) ((dipValue * reSize) + 0.5);
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip2px(leftDip), Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip2px(rightDip), Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    private void initbanner() {
        final ArrayList<String> images = new ArrayList<>();
        images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3872983311,3499280098&fm=26&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2305191078,2341992867&fm=26&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=30335840,369621311&fm=26&gp=0.jpg");

        for (int i = 0; i < images.size(); i++) {
            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(getActivity()).load(path).into(imageView);
                        }
                    }).start();
        }
    }
}