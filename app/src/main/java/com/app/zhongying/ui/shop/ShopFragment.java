package com.app.zhongying.ui.shop;

import android.content.Intent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.ShoppingActivity;

import butterknife.BindView;
import com.app.zhongying.ui.shop.adapter.DataAdapter;
import com.app.zhongying.ui.shop.adapter.VpAdapter;
import com.app.zhongying.ui.shop.common.VideoItemDecoration;
import com.app.zhongying.ui.shop.fragments.CreativeFragment;
import com.app.zhongying.ui.shop.fragments.FilmsFragment;
import com.app.zhongying.ui.shop.fragments.PomeloFragment;
import com.app.zhongying.ui.shop.utils.RoundImageView;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment implements OnBannerListener {

    private Banner banner_shop;
    private TabLayout tab_shop;
    private ViewPager vp_shop;
    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_collection;
    private ImageView iv_share;
    private TextView tv_set;
    private ImageView iv_navigation;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(view);
        setBanner();
        return view;
    }


    private void initView(View view) {

        banner_shop = view.findViewById(R.id.banner_shop);
        tab_shop = view.findViewById(R.id.tab_shop);
        vp_shop = view.findViewById(R.id.vp_shop);
        iv_back=view.findViewById(R.id.iv_back);
        tv_title=view.findViewById(R.id.tv_title);
        iv_collection=view.findViewById(R.id.iv_collection);
        iv_share=view.findViewById(R.id.iv_share);
        tv_set=view.findViewById(R.id.tv_set);
        iv_navigation=view.findViewById(R.id.iv_navigation);
        toolbar=view.findViewById(R.id.toolbar);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CreativeFragment());
        fragments.add(new PomeloFragment());
        fragments.add(new FilmsFragment());
        VpAdapter vpAdapter = new VpAdapter(getActivity().getSupportFragmentManager(), fragments);
        vp_shop.setAdapter(vpAdapter);
        tab_shop.setupWithViewPager(vp_shop);
        tab_shop.getTabAt(0).setText("文创");
        tab_shop.getTabAt(1).setText("文旅");
        tab_shop.getTabAt(2).setText("影视");
        iv_back.setVisibility(View.GONE);
        tv_title.setText("商城");

        iv_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPop();
            }
        });
    }

    private void initPop() {


            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop_item, null);
            TextView btn_click = inflate.findViewById(R.id.btn_click);
            RecyclerView recyclerView = inflate.findViewById(R.id.mRecycler);
            List<String> data = new ArrayList<>();
            data.clear();
            for (int i = 0; i < 10; i++) {
                data.add("啦啦啦" + i);
            }

            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            VideoItemDecoration itemDecoration = new VideoItemDecoration();
            itemDecoration.setSpace(20);
            recyclerView.addItemDecoration(itemDecoration);
            DataAdapter dataAdapter = new DataAdapter(getActivity());
            recyclerView.setAdapter(dataAdapter);
            dataAdapter.addData(data);

            //获取屏幕的宽度
            DisplayMetrics outMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            int widthPixels = outMetrics.widthPixels;

            final PopupWindow popupWindow = new PopupWindow(inflate, widthPixels/2, WindowManager.LayoutParams.FILL_PARENT, true);
            popupWindow.setOutsideTouchable(true);
            //设置动画
            // popupWindow.setAnimationStyle(R.style.AnimationRightFade);
            //设置背景色
//        ColorDrawable dw = new ColorDrawable(0xffffffff);
//        popupWindow.setBackgroundDrawable(dw);
            setBackground(1f);
            //监听事件
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    setBackground(1f);
                }
            });

            //点击确定
            btn_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
            //设置位置
            popupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.fragment_shop, null), Gravity.RIGHT, 0, 500);


    }

    public void setBackground(float alpha) {
        WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
        attributes.alpha = alpha;
        getActivity().getWindow().setAttributes(attributes);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(), "点击了banner", Toast.LENGTH_SHORT).show();
    }

    /**
     * 图片加载类
     */
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

        /**
         * 自定义圆角类
         *
         * @param context
         * @return
         */
        @Override
        public ImageView createImageView(Context context) {
            RoundImageView img = new RoundImageView(context);
            return img;
        }
    }

    private void setBanner() {
        List imgs = new ArrayList<>();
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.one));
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.two));
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.three));
//        List titles = new ArrayList<>();
//        titles.add("教育图片1");
//        titles.add("教育图片2");
//        titles.add("教育图片3");
//        for (int i = 0; i < 3; i++) {
//            banners.addAll(imgs);
//        }
        banner_shop.setImages(imgs)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();

        MyImageLoader mMyImageLoader = new MyImageLoader();
        //设置图片加载器
        banner_shop.setImageLoader(mMyImageLoader);

//    设置内置样式，共有六种可以点入方法内逐一体验使用。
        //      banner_shop.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

//    设置图片加载器，图片加载器在下方
// banner_shop.setImageLoader(new MyLoaderextends());

//    设置图片网址或地址的集合
//        banner_shop.setImages(imgs);

//        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner_shop.setBannerAnimation(Transformer.DepthPage);
//
//        //设置轮播图的标题集合
//        banner_shop.setBannerTitles(titles);
//        //设置轮播间隔时间
        banner_shop.setDelayTime(3000);
//    设置是否为自动轮播，默认是“是”。
//        banner_shop.isAutoPlay(true);
//    设置指示器的位置，小点点，左中右。
        banner_shop.setIndicatorGravity(BannerConfig.CENTER)
//    以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
//    必须最后调用的方法，启动轮播图。
                .start();
    }


    public static String getStringFromDrawableRes(Context context, int id) {
        Resources resources = context.getResources();
        String path = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + resources.getResourcePackageName(id) + "/"
                + resources.getResourceTypeName(id) + "/"
                + resources.getResourceEntryName(id);

        return path;
    }

//当返回到activity，继续

    @Override
    public void onResume() {
        super.onResume();
        banner_shop.start();
    }

    //activity停止
    @Override
    public void onStop() {
        super.onStop();
        banner_shop.stopAutoPlay();
    }
}