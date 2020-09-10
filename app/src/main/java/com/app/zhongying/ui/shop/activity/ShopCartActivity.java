package com.app.zhongying.ui.shop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.shop.adapter.ShopAdapter;
import com.app.zhongying.ui.shop.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

public class ShopCartActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;//返回
    private TextView tv_title;//toolbar标题
    private TextView tv_set;//管理
    private TextView tv_shopNum;//商品数量
    private RecyclerView mRecycler;
    private CheckBox cb_all;//全选
    private TextView tv_pay;//去结算
    private TextView tv_money;//金额
    private Toolbar toolbar;
    private ShopAdapter shopAdapter;
    private boolean mStatus = true;
    private TextView tv_over;
    private TextView tv_delete;
    private List<ShopBean> data;
    private ImageView iv_collection;
    private ImageView iv_share;
    private ImageView iv_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);
        initView();
        initData();

    }

    private void initData() {
        data = new ArrayList<>();
        data.clear();
        for (int i = 0; i < 9; i++) {
            ShopBean bean = new ShopBean("http://static.aihanfu.net/uploadfile/2018/1217/20181217104003642.jpeg", "MARICE魅力资女士素颜霜", 99);
            data.add(bean);
        }
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        shopAdapter = new ShopAdapter(this);
        mRecycler.setAdapter(shopAdapter);
        shopAdapter.addData(data);

        cb_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //点击之后将全部条目都选中 再次点击就取消全部选中
                if (compoundButton.isPressed()) {
                    if (mStatus == true) {
                        shopAdapter.statusChanged(true);
                        mStatus = false;
                    } else if (mStatus == false) {
                        shopAdapter.statusChanged(false);
                        mStatus = true;

                    } else {

                    }
                }
            }
        });


        cb_all.setChecked(false);
    }

    public void setPrice(int price) {
        tv_money.setText("合计：¥" + price + "");
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_set = (TextView) findViewById(R.id.tv_set);
        tv_shopNum = (TextView) findViewById(R.id.tv_shopNum);
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        cb_all = (CheckBox) findViewById(R.id.cb_all);
        tv_pay = (TextView) findViewById(R.id.tv_pay);
        tv_money = (TextView) findViewById(R.id.tv_money);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_delete = (TextView) findViewById(R.id.tv_delete);
        tv_over = (TextView) findViewById(R.id.tv_over);
        iv_back.setOnClickListener(this);
        tv_set.setOnClickListener(this);
        tv_over.setOnClickListener(this);
        tv_delete.setOnClickListener(this);
        iv_collection = (ImageView) findViewById(R.id.iv_collection);
        iv_collection.setOnClickListener(this);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_share.setOnClickListener(this);
        iv_navigation = (ImageView) findViewById(R.id.iv_navigation);
        iv_navigation.setOnClickListener(this);

        iv_navigation.setVisibility(View.GONE);
        tv_set.setVisibility(View.VISIBLE  );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_set:
                //设置点击 结算按钮 、管理按钮、金额消失  完成按钮 删除按钮显示
                tv_pay.setVisibility(View.GONE);
                tv_set.setVisibility(View.GONE);
                tv_money.setVisibility(View.GONE);

                tv_over.setVisibility(View.VISIBLE);
                tv_delete.setVisibility(View.VISIBLE);

                break;
            case R.id.tv_over:
                //设置点击 结算按钮 、管理按钮、金额显示  完成按钮 删除按钮消失
                tv_pay.setVisibility(View.VISIBLE);
                tv_set.setVisibility(View.VISIBLE);
                tv_money.setVisibility(View.VISIBLE);

                tv_over.setVisibility(View.GONE);
                tv_delete.setVisibility(View.GONE);
                break;
            case R.id.tv_delete:
                //点击删除 清除选中的条目
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).isStatus() == true) {
                        shopAdapter.removeData(data.get(i));
                    }
                }
                shopAdapter.notifyDataSetChanged();
                tv_money.setText("合计：¥" + 0 + "");
                cb_all.setChecked(false);
                break;
            case R.id.tv_pay:
                Toast.makeText(this, "去结算", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void setStatus(boolean b) {
        cb_all.setChecked(b);
    }
}