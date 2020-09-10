package com.app.zhongying.ui.own.login.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;
import com.app.zhongying.ui.own.login.fragments.StringUtils;

public class ReviseActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mRevisePwd;
    private EditText mRevisePwdSure;
    private Button mBtnRevise;
    private ImageView mReviseBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);
        initView();
    }

    private void initView() {
        mRevisePwd = (EditText) findViewById(R.id.revise_pwd);
        mRevisePwdSure = (EditText) findViewById(R.id.revise_pwd_sure);
        mBtnRevise = (Button) findViewById(R.id.btn_revise);

        mBtnRevise.setOnClickListener(this);
        mReviseBack = (ImageView) findViewById(R.id.revise_back);
        mReviseBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_revise:
                if (mRevisePwd.getText().toString().equals(mRevisePwdSure.getText().toString())) {
                    finish();
                }
                break;
            case R.id.revise_back:
                finish();
                break;
        }
    }
}