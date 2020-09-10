package com.app.zhongying.activity.own;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.app.zhongying.R;

public class ServiceActivity extends AppCompatActivity {

    private ImageView returns;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initView();
    }

    private void initView() {
        returns = (ImageView) findViewById(R.id.returns);
        title = (TextView) findViewById(R.id.title);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}