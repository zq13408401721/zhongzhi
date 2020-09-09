package com.app.zhongying.ui.own;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zhongying.R;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
    }

    private void initView() {
        //标题
        RelativeLayout tool = findViewById(R.id.se_Finish);
        ImageView toolImg = tool.findViewById(R.id.tuiChu);
        toolImg.setOnClickListener(this);

        RelativeLayout diZ = findViewById(R.id.dizhi);
        diZ.setOnClickListener(this);
        TextView diZTv = diZ.findViewById(R.id.own_settings);
        diZTv.setText("地址管理");

        RelativeLayout qingL = findViewById(R.id.qingli);
        qingL.setOnClickListener(this);
        TextView qingLTv = qingL.findViewById(R.id.se_left);
        TextView qingLTvC = qingL.findViewById(R.id.se_cen);
        qingLTvC.setText("44.61MB");
        qingLTv.setText("清理缓存");

        RelativeLayout yinS = findViewById(R.id.yinsi);
        yinS.setOnClickListener(this);
        TextView yinSTv = yinS.findViewById(R.id.own_settings);
        yinSTv.setText("用户协议及隐私政策");

        RelativeLayout yiJ = findViewById(R.id.yijian);
        yiJ.setOnClickListener(this);
        TextView yiJTv = yiJ.findViewById(R.id.own_settings);
        yiJTv.setText("意见反馈");

        RelativeLayout banB = findViewById(R.id.banben);
        banB.setOnClickListener(this);
        TextView banBTv = banB.findViewById(R.id.se_left);
        TextView banBTvC = banB.findViewById(R.id.se_cen);
        banBTvC.setText("已经最新版本");
        banBTv.setText("当前版本V1.1.0");

        RelativeLayout tuiC = findViewById(R.id.tui_login);
        tuiC.setOnClickListener(this);
        TextView tuiCTv = tuiC.findViewById(R.id.se_left);
        TextView tuiCTvC = tuiC.findViewById(R.id.se_cen);
        tuiCTvC.setText("切换账号");
        tuiCTv.setText("退出登录");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //顶部toolbar退出页面
            case R.id.tuiChu:
                finish();
                break;
            //地址管理
            case R.id.dizhi:
                Toast.makeText(this, "地址管理", Toast.LENGTH_SHORT).show();
                break;
            //清理缓存
            case R.id.qingli:
                Toast.makeText(this, "清理缓存", Toast.LENGTH_SHORT).show();
                break;
            //用户协议及隐私政策
            case R.id.yinsi:
                Toast.makeText(this, "用户协议及隐私政策", Toast.LENGTH_SHORT).show();
                break;
            //意见反馈
            case R.id.yijian:
                Toast.makeText(this, "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            //当前版本
            case R.id.banben:
                Toast.makeText(this, "当前版本", Toast.LENGTH_SHORT).show();
                break;
            //退出登录
            case R.id.tui_login:
                Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}