package com.app.zhongying.ui.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import com.app.zhongying.ui.shopbean.ShopBean;
import com.app.zhongying.ui.utils.DP2PXUtils;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingActivity extends AppCompatActivity {
//1234logt
//商品详情
    private static final String TAG = "ShoppingActivity";
    @BindView(R.id.iv_collect_shop)
    ImageView ivCollectShop;
    @BindView(R.id.iv_share_shop)
    ImageView ivShareShop;
    @BindView(R.id.toolbar_shop)
    Toolbar toolbarShop;
    @BindView(R.id.banner_shop)
    Banner bannerShop;
    @BindView(R.id.tv_title_shop)
    TextView tvTitleShop;
    @BindView(R.id.iv_merchant_shop)
    ImageView ivMerchantShop;
    @BindView(R.id.tv_shopTitle_shop)
    TextView tvShopTitleShop;
    @BindView(R.id.tv_optimization_shop)
    TextView tvOptimizationShop;
    @BindView(R.id.tv_schedule_shop)
    TextView tvScheduleShop;
    @BindView(R.id.iv_commodity_shop)
    ImageView ivCommodityShop;
    @BindView(R.id.tv_title_commodity_shop)
    TextView tvTitleCommodityShop;
    @BindView(R.id.tv_content_commodity_shop)
    TextView tvContentCommodityShop;
    @BindView(R.id.tv_purchase_commodity_shop)
    TextView tvPurchaseCommodityShop;
    @BindView(R.id.tv_price_commodity_shop)
    TextView tvPriceCommodityShop;
    @BindView(R.id.content_shop)
    ConstraintLayout contentShop;
    @BindView(R.id.tv_evaluate_shop)
    TextView tvEvaluateShop;
    @BindView(R.id.tv_look_shop)
    TextView tvLookShop;
    @BindView(R.id.iv_in_shop)
    ImageView ivInShop;
    @BindView(R.id.iv_user_shop)
    ImageView ivUserShop;
    @BindView(R.id.tv_userName_shop)
    TextView tvUserNameShop;
    @BindView(R.id.tv_userContent_shop)
    TextView tvUserContentShop;
    @BindView(R.id.recycler_shop)
    RecyclerView recyclerShop;
    @BindView(R.id.shop_shop)
    ImageView shopShop;
    @BindView(R.id.tv_tv)
    TextView tvTv;
    @BindView(R.id.support_shop)
    ImageView supportShop;
    @BindView(R.id.tv_shopCar_shop)
    TextView tvShopCarShop;
    @BindView(R.id.tv_purchase_shop)
    TextView tvPurchaseShop;
    @BindView(R.id.iv_finish_shop)
    ImageView ivFinishShop;
    private InfoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        ButterKnife.bind(this);
        /* 88px --> 29dp
         * 40px -->  13dp
         * 98px-->33dp
         * 32px-->11dp
         * */

        int i = DP2PXUtils.dp2px(this, 11l);
        int i720 = DP2PXUtils.dp2px(this, 85);
        int i255 = DP2PXUtils.dp2px(this, 75l);
        Log.d(TAG, "onCreate: " + i);
        Log.d(TAG, "onCreate7: " + i720);
        Log.d(TAG, "onCreate7: " + i255);


        initData();
        setBanner();

    }

    private void setBanner() {
        ArrayList<String> banners = new ArrayList<>();
        List imgs = new ArrayList();
        imgs.add(getStringFromDrawableRes(this,R.drawable.crop__ic_cancel));
        imgs.add(getStringFromDrawableRes(this,R.drawable.crop__ic_cancel));
        imgs.add(getStringFromDrawableRes(this,R.drawable.crop__ic_cancel));
        bannerShop.setImages(imgs)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
    }
    public static String getStringFromDrawableRes(Context context, int id) {

        Resources resources = context.getResources();

        String path = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"

                + resources.getResourcePackageName(id) + "/"

                + resources.getResourceTypeName(id) + "/"

                + resources.getResourceEntryName(id);

        return path;

    }

    private void initData() {

        List<ShopBean> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add(new ShopBean(R.drawable.android));
        }


        recyclerShop.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new InfoAdapter(this);
        recyclerShop.setAdapter(mAdapter);
        mAdapter.addDataList(datas);



    }

    @OnClick({R.id.tv_look_shop, R.id.tv_shopCar_shop, R.id.tv_purchase_shop,R.id.iv_finish_shop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_look_shop:
                startActivity(new Intent(this,LookActivity.class));
                break;
            case R.id.tv_shopCar_shop:
                startActivity(new Intent(this,ShopCarActivity.class));
                break;
            case R.id.tv_purchase_shop:
                startActivity(new Intent(this,purchaseActivity.class));
                break;
            case R.id.iv_finish_shop:
                finish();
                break;
        }
    }
}