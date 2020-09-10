package com.app.zhongying.ui.live;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.zhongying.R;
import com.app.zhongying.common.LoveLayout;
import com.app.zhongying.ui.live.fragment.LiveasRlvAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView stream_exit;
    private ImageView stream_praise;
    private ImageView stream_gift;
    private ImageView video_cut;
    private ImageView imageView2;
    private LoveLayout stream_love;
    private ConstraintLayout cl;
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private RecyclerView Live_Streaming_rlv;
    private LiveasRlvAdapter mAdapters;
    private Button btnPk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        initView();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.stream_exit:
                //退出当前页面
                finish();
                break;
            case R.id.stream_praise:
                //点赞
                stream_love.addLoveView();
                break;
            case R.id.stream_gift:
                //礼物
                pop();
                break;
        }
    }

    private void initView() {

        btnPk = findViewById(R.id.btnPK);
        stream_exit = (ImageView) findViewById(R.id.stream_exit);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        video_cut = (ImageView) findViewById(R.id.video_cut);
        stream_praise = (ImageView) findViewById(R.id.stream_praise);
        stream_gift = (ImageView) findViewById(R.id.stream_gift);
        stream_love = (LoveLayout) findViewById(R.id.stream_love);
        mRecyclerView = findViewById(R.id.Live_Streaming_RecyclerView);
        cl = findViewById(R.id.Live_Streaming_ConstraintLayout);
        stream_exit.setOnClickListener(this);
        stream_gift.setOnClickListener(this);
        stream_praise.setOnClickListener(this);
        mEditText = findViewById(R.id.Live_Streaming_EditText);
        Live_Streaming_rlv = findViewById(R.id.Live_Streaming_rlv);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        LiveRlvAdapter mAdapter = new LiveRlvAdapter(this, 56300000);
        mRecyclerView.setAdapter(mAdapter);

        Live_Streaming_rlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapters = new LiveasRlvAdapter(this);
        Live_Streaming_rlv.setAdapter(mAdapters);


        mEditText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //这里注意要作判断处理，ActionDown、ActionUp都会回调到这里，不作处理的话就会调用两次
                if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.getAction()) {
                    //处理事件
                    mAdapters.addData(mEditText.getText().toString());
                    mEditText.setText("");
                    Live_Streaming_rlv.scrollToPosition(mAdapters.getItemCount() - 1);

                    return true;
                }
                return false;
            }
        });
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

        stream_gift.bringToFront();

    }
}