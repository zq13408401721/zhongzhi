package com.app.zhongying.ui.live;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.app.zhongying.R;
import com.app.zhongying.common.LoveLayout;

import java.util.Arrays;
import java.util.List;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView praise;
    private LoveLayout layout;
    private ImageView exit;
    private ImageView img_bg;
    private ImageView video_gift;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();


    }

    private void initView() {
        praise = findViewById(R.id.video_praise);
        img_bg = findViewById(R.id.imageView);
        video_gift = findViewById(R.id.video_gift);
        layout = findViewById(R.id.video_love);
        exit = findViewById(R.id.video_exit);
        cl = findViewById(R.id.cl);

        exit.setOnClickListener(this);
        praise.setOnClickListener(this);
        img_bg.setOnClickListener(this);
        video_gift.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_gift:
                pop();
                break;
            case R.id.video_praise:
                layout.addLoveView();
                break;
            case R.id.imageView:
                layout.addLoveView();
                break;
            case R.id.video_exit:
                //关闭直播
                Intent intent = new Intent(this, FinalBroadcaseActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


    private void pop() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_broadcast_view, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(cl, Gravity.BOTTOM, 0, 0);
        ViewPager viewPager = view.findViewById(R.id.Live_ViewPager_Item);
        View inflate = getLayoutInflater().inflate(R.layout.fragment_gift, null);
        View inflates = getLayoutInflater().inflate(R.layout.fragment_gift_ii, null);
        List<View> views = Arrays.asList(inflate, inflates);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view1 = views.get(position);
                container.addView(view1);
                return view1;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }
        });

        video_gift.bringToFront();
    }
}