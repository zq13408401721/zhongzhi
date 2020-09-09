package com.app.zhongying.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;
import com.app.zhongying.ui.home.HomeFragment;



import butterknife.BindView;
import butterknife.ButterKnife;

public class SeekActivity extends AppCompatActivity {

    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.tv_recentlyseek)
    TextView tvRecentlyseek;
    @BindView(R.id.iv_delet)
    ImageView ivDelet;
    @BindView(R.id.layout1)
    LinearLayout layout1;
    @BindView(R.id.tv_hotdoreseek)
    TextView tvHotdoreseek;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.layout3)
    LinearLayout layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
