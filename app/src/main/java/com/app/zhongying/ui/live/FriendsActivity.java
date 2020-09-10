package com.app.zhongying.ui.live;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.zhongying.R;
import com.app.zhongying.ui.live.fragment.MyConcernsFragment;
import com.app.zhongying.ui.live.fragment.MyFansFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.fl)
    FrameLayout fl;
    private MyConcernsFragment myConcernsFragment;
    private MyFansFragment myFansFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        findViewById(R.id.Live_Friedns_ImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        myConcernsFragment = new MyConcernsFragment();
        myFansFragment = new MyFansFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl, myConcernsFragment)
                .add(R.id.fl, myFansFragment)
                .hide(myFansFragment)
                .commit();


        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        hideFragment();
                        getSupportFragmentManager().beginTransaction().show(myConcernsFragment).commit();
                        break;
                    case 1:
                        hideFragment();
                        getSupportFragmentManager().beginTransaction().show(myFansFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void hideFragment() {
        getSupportFragmentManager().beginTransaction().hide(myConcernsFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(myFansFragment).commit();
    }
}