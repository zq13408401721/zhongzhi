package com.app.zhongying.activity.own;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class Modify_DateActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView date_returns;

    private TextView date_title;
    private TextView date_preservation;
    private EditText year1;
    private EditText year2;
    private EditText year3;
    private EditText year4;
    private EditText month1;
    private EditText month2;
    private EditText day;
    private EditText day1;
    private LinearLayout layou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify__date);
        initView();
    }

    private void initView() {
        date_returns = (ImageView) findViewById(R.id.date_returns);
        date_returns.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.date_returns:
                finish();
                break;
        }
    }
}