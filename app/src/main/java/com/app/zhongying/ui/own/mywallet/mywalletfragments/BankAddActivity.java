package com.app.zhongying.ui.own.mywallet.mywalletfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class BankAddActivity extends AppCompatActivity {

    private ImageView back;
    private TextView toobartitle;
    private TextView tvnum_bandcard_tv;
    private TextView name_bandcard_tv;
    private TextView idcard_bandcard_tv;
    private TextView phonenum_bandcard_tv;
    private TextView verificationnum_bandcard_tv;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_add);
        initView();
        initData();
    }

    private void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        toobartitle.setText("绑定银行卡");
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        toobartitle = (TextView) findViewById(R.id.toobartitle);
        tvnum_bandcard_tv = (TextView) findViewById(R.id.tvnum_bandcard_tv);
        name_bandcard_tv = (TextView) findViewById(R.id.name_bandcard_tv);
        idcard_bandcard_tv = (TextView) findViewById(R.id.idcard_bandcard_tv);
        phonenum_bandcard_tv = (TextView) findViewById(R.id.phonenum_bandcard_tv);
        verificationnum_bandcard_tv = (TextView) findViewById(R.id.verificationnum_bandcard_tv);
        cb = (CheckBox) findViewById(R.id.cb);
    }
}