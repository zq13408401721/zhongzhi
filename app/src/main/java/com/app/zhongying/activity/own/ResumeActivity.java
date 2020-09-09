package com.app.zhongying.activity.own;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class ResumeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView resume_returns;
    private TextView resume_title;
    private TextView resume_preservation;
    private EditText resume_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        initView();
    }

    private void initView() {
        resume_returns = (ImageView) findViewById(R.id.resume_returns);
        resume_title = (TextView) findViewById(R.id.resume_title);
        resume_preservation = (TextView) findViewById(R.id.resume_preservation);
        resume_text = (EditText) findViewById(R.id.resume_text);
        resume_returns.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.resume_returns:
                finish();
                break;
        }
    }
}