package com.app.zhongying.ui.live;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.zhongying.R;

public class FinalBroadcaseActivity extends AppCompatActivity {
    private Button btn_Sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_broadcase);
        initView();
    }

    private void initView() {
        btn_Sure = findViewById(R.id.Broadcast_Button_Sure);
        btn_Sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}