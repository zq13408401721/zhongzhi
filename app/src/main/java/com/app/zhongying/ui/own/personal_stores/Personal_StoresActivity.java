package com.app.zhongying.ui.own.personal_stores;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Personal_StoresActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView store_Finish;
    private ImageView shouCang;
    private ImageView fenXiang;
    private TextView store_X;
    private TextView store_guanZ;
    private TextView souS;
    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__stores);
        initView();
    }

    private void initView() {
        store_Finish = (ImageView) findViewById(R.id.store_Finish);
        store_Finish.setOnClickListener(this);
        shouCang = (ImageView) findViewById(R.id.shouCang);
        shouCang.setOnClickListener(this);
        fenXiang = (ImageView) findViewById(R.id.fenXiang);
        fenXiang.setOnClickListener(this);
        store_X = (TextView) findViewById(R.id.store_X);
        store_X.setOnClickListener(this);
        store_guanZ = (TextView) findViewById(R.id.store_guanZ);
        store_guanZ.setOnClickListener(this);
        souS = (TextView) findViewById(R.id.souS);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        tab.setupWithViewPager(vp);
        List<Fragment> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new StoresFragment());
        }
        StoresVP storesVP = new StoresVP(getSupportFragmentManager(), list);
        vp.setAdapter(storesVP);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //返回
            case R.id.store_Finish:
                finish();
                break;
                //收藏
            case R.id.shouCang:
                break;
                //分享
            case R.id.fenXiang:
                break;
                //小程序按钮
            case R.id.store_X:
                break;
        }
    }
}