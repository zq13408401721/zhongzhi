package com.app.zhongying.activity.own;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class MarketingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView returns;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);
        initView();
    }

    private void initView() {
        returns = (ImageView) findViewById(R.id.returns);
        returns.setOnClickListener(this);
        title = (TextView) findViewById(R.id.title);
        title.setText("营销利润");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.returns:
                finish();
                break;
        }
    }
}