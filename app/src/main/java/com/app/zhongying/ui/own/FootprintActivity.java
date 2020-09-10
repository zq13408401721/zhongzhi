package com.app.zhongying.ui.own;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

public class FootprintActivity extends AppCompatActivity {

    private ImageView back;
    private TextView toobartitle;
    private TextView toobar_management;
    private CheckBox cb_all;
    private CheckBox cb_part;
    private ImageView head_management_im;
    private TextView name_management_tv;
    private TextView num_management_tv;
    private TextView price_management_tv;
    private TextView buy_management_tv;
    private TextView shopcar_management_tv;
    //private RecyclerView management_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint);
        initView();
        initData();
    }

    private void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //management_rv的子布局是item_management_rv，id已经设置，创建适配器可直接使用
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        toobartitle = (TextView) findViewById(R.id.toobartitle);
        toobar_management = (TextView) findViewById(R.id.toobar_management);
        cb_all = (CheckBox) findViewById(R.id.cb_all);
        cb_part = (CheckBox) findViewById(R.id.cb_part);
        head_management_im = (ImageView) findViewById(R.id.head_management_im);
        name_management_tv = (TextView) findViewById(R.id.name_management_tv);
        num_management_tv = (TextView) findViewById(R.id.num_management_tv);
        price_management_tv = (TextView) findViewById(R.id.price_management_tv);
        buy_management_tv = (TextView) findViewById(R.id.buy_management_tv);
        shopcar_management_tv = (TextView) findViewById(R.id.shopcar_management_tv);
        //management_rv = (RecyclerView) findViewById(R.id.management_rv);
    }
}