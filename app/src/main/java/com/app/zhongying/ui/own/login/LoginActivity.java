package com.app.zhongying.ui.own.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.app.zhongying.R;
import com.app.zhongying.ui.own.login.adapter.LoginPageAdapter;
import com.app.zhongying.ui.own.login.fragments.LoginFragment;
import com.app.zhongying.ui.own.login.fragments.RegisterFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private TabLayout mLoginTab;
    private CustomViewPager mLoginViewPager;
    private ImageView mLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mLoginTab = (TabLayout) findViewById(R.id.login_tab);
        mLoginViewPager = (CustomViewPager) findViewById(R.id.login_viewPager);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new LoginFragment());
        fragmentArrayList.add(new RegisterFragment());

        LoginPageAdapter loginPageAdapter = new LoginPageAdapter(getSupportFragmentManager(), fragmentArrayList);
        mLoginViewPager.setAdapter(loginPageAdapter);
        mLoginTab.setupWithViewPager(mLoginViewPager);
        mLoginTab.getTabAt(0).setText("登录");
        mLoginTab.getTabAt(1).setText("注册");
        mLoginBack = (ImageView) findViewById(R.id.login_back);
        mLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}