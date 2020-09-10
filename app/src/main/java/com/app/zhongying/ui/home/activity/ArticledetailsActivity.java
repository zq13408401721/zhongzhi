package com.app.zhongying.ui.home.activity;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class ArticledetailsActivity extends AppCompatActivity {

    private ImageView imagehead;
    private ImageView img_fanhui;
    private TextView tv_title;
    private ImageView img_share;
    private ImageView img_cehua;
    private TextView tv_time;
    private TextView tv_name;
    private TextView tv_sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articledetails);
        initView();
    }

    private void initView() {
        img_fanhui=findViewById(R.id.img_fanhui);
        tv_title = findViewById(R.id.tv_title);
        img_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextPaint paint = tv_title.getPaint();
        paint.setFakeBoldText(true);
    }
}