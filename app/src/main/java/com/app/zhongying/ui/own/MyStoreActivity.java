package com.app.zhongying.ui.own;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;
import com.app.zhongying.activity.own.MarketingActivity;
import com.app.zhongying.activity.own.ServiceActivity;
import com.app.zhongying.ui.own.activities.MessageActivity;
import com.app.zhongying.ui.own.personal_stores.Personal_StoresActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStoreActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_storeIntroduction)
    TextView tvStoreIntroduction;
    @BindView(R.id.iv_right_order)
    ImageView ivRightOrder;
    @BindView(R.id.tv_obligation)//待付款
            TextView tvObligation;
    @BindView(R.id.tv_send)//待发货
            TextView tvSend;
    @BindView(R.id.tv_harvest)//待收货
            TextView tvHarvest;
    @BindView(R.id.tv_evaluate)//评价
            TextView tvEvaluate;
    @BindView(R.id.tv_after)//售后
            TextView tvAfter;
    @BindView(R.id.iv_right_product)
    ImageView ivRightProduct;
    @BindView(R.id.tv_add)//添加商品
            TextView tvAdd;
    @BindView(R.id.tv_sell)//出售中
            TextView tvSell;
    @BindView(R.id.tv_sold_out)//下架商品
            TextView tvSoldOut;
    @BindView(R.id.tv_warehouse)//仓库中
            TextView tvWarehouse;
    @BindView(R.id.tv_out_of_print)//已售完
            TextView tvOutOfPrint;
    @BindView(R.id.rv_msg)
    RelativeLayout rvMsg;
    @BindView(R.id.rv_look_myStore)
    RelativeLayout rvLookMyStore;
    @BindView(R.id.rv_profit)//营销利润
            RelativeLayout rvProfit;
    @BindView(R.id.rv_customer_service)//在线客服
            RelativeLayout rvCustomerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbarTitle.setText("我的店铺");
    }

    @OnClick({R.id.iv_back, R.id.rv_profit,R.id.rv_look_myStore, R.id.rv_msg, R.id.iv_right_order, R.id.tv_obligation, R.id.tv_send,
            R.id.tv_evaluate, R.id.tv_harvest, R.id.tv_after, R.id.iv_right_product,
            R.id.tv_add, R.id.tv_sell, R.id.tv_sold_out, R.id.rv_customer_service, R.id.tv_warehouse, R.id.tv_out_of_print})
    public void onClickListener(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right_order:
                break;
            case R.id.iv_right_product:
                startActivity(new Intent(this, ProductManageActivity.class));
                break;
            case R.id.tv_obligation://待付款
                break;
            case R.id.tv_send://待发货
                break;
            case R.id.tv_evaluate://评价
                break;
            case R.id.tv_harvest://待收货
                break;
            case R.id.tv_after://售后
                break;
            case R.id.tv_add://添加商品
                startAdd();
                break;
            case R.id.tv_sell://出售中
                startSell();
                break;
            case R.id.tv_sold_out://下架商品
                startSoldOut();
                break;
            case R.id.tv_warehouse://仓库中
                startWarehouse();
                break;
            case R.id.tv_out_of_print://已售完
                startOutofPrint();
                break;
            case R.id.rv_msg:
                startActivity(new Intent(MyStoreActivity.this, MessageActivity.class));
                break;
            case R.id.rv_look_myStore:
                startActivity(new Intent(MyStoreActivity.this, Personal_StoresActivity.class));
                break;
            case R.id.rv_customer_service:
                startActivity(new Intent(MyStoreActivity.this, ServiceActivity.class));
                break;
            case R.id.rv_profit:
                startActivity(new Intent(MyStoreActivity.this, MarketingActivity.class));
                break;

        }
    }

    private void startAdd() {
        Intent intent = new Intent(this, ProductManageActivity.class);
        intent.putExtra("id", 0);
        startActivity(intent);
    }

    private void startSell() {
        Intent intent = new Intent(this, ProductManageActivity.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }

    private void startSoldOut() {
        Intent intent = new Intent(this, ProductManageActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }


    private void startWarehouse() {
        Intent intent = new Intent(this, ProductManageActivity.class);
        intent.putExtra("id", 3);
        startActivity(intent);
    }

    private void startOutofPrint() {
        Intent intent = new Intent(this, ProductManageActivity.class);
        intent.putExtra("id", 4);
        startActivity(intent);
    }
}