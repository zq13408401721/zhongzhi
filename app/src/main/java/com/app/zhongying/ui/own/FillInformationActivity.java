package com.app.zhongying.ui.own;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FillInformationActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.rv_storeName)
    RelativeLayout rvStoreName;
    @BindView(R.id.rv_storeImage)
    RelativeLayout rvStoreImage;
    @BindView(R.id.rv_storeIntroduction)
    RelativeLayout rvStoreIntroduction;
    @BindView(R.id.rv_content)
    RelativeLayout rvContent;
    @BindView(R.id.rv_phone)
    RelativeLayout rvPhone;
    @BindView(R.id.rv_QQ)
    RelativeLayout rvQQ;
    @BindView(R.id.rv_Emile)
    RelativeLayout rvEmile;
    @BindView(R.id.btn_commit)
    Button btnCommit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_information);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbarTitle.setText("填写资料");

    }

    @OnClick({R.id.iv_back,R.id.rv_storeName,R.id.rv_storeImage,R.id.rv_storeIntroduction,R.id.rv_content,
            R.id.rv_phone,R.id.rv_QQ,R.id.rv_Emile,R.id.btn_commit})
    public void onClickListener(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.rv_storeName:
                break;
            case R.id.btn_commit:
                startActivity(new Intent(this,MyStoreActivity.class));
                break;

        }
    }

}