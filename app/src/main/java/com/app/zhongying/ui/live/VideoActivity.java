package com.app.zhongying.ui.live;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.zhongying.R;
import com.app.zhongying.common.LoveLayout;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView praise;
    private LoveLayout layout;
    private ImageView exit;
    private ImageView img_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();




    }

    private void initView() {
        praise = findViewById(R.id.video_praise);
        img_bg = findViewById(R.id.imageView);
        layout=findViewById(R.id.video_love);
        exit = findViewById(R.id.video_exit);

        exit.setOnClickListener(this);
        praise.setOnClickListener(this);
        img_bg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
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
}