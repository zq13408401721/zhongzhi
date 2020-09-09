package com.app.zhongying;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.adapter.RlvAdapter;
import com.app.zhongying.common.LoveLayout;

import java.util.ArrayList;
import java.util.List;

public class StreamingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView stream_exit;
    private ImageView stream_praise;
    private ImageView stream_gift;
    private LoveLayout stream_love;
    private ConstraintLayout cl;

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
        stream_exit = (ImageView) findViewById(R.id.stream_exit);
        stream_praise = (ImageView) findViewById(R.id.stream_praise);
        stream_gift = (ImageView) findViewById(R.id.stream_gift);
        stream_love = (LoveLayout) findViewById(R.id.stream_love);
        cl = findViewById(R.id.cl);
        stream_exit.setOnClickListener(this);
        stream_gift.setOnClickListener(this);
        stream_praise.setOnClickListener(this);
    }
    private void pop() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_broadcast_view, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(cl, Gravity.BOTTOM, 0, 0);
        RecyclerView rlv = view.findViewById(R.id.rlv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rlv.setLayoutManager(gridLayoutManager);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            list.add(R.mipmap.rocket__easyi);
            list.add(R.mipmap.shu);
            list.add(R.mipmap.jinyuanbao);
            list.add(R.mipmap.youting);
            list.add(R.mipmap.hua);
        }


        RlvAdapter adapter = new RlvAdapter(this, list);
        rlv.setAdapter(adapter);
        stream_gift.bringToFront();
    }
}