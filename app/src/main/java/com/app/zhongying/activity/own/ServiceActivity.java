package com.app.zhongying.activity.own;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.adapter.ServiceAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView returns;
    private TextView title;
    private RecyclerView service_rec;
    private EditText service_edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
        initdata();
    }



    private void initView() {
        returns = (ImageView) findViewById(R.id.returns);
        returns.setOnClickListener(this);
        title = (TextView) findViewById(R.id.title);
        service_rec = (RecyclerView) findViewById(R.id.service_rec);
        service_edittext = (EditText) findViewById(R.id.service_edittext);
    }

    private void initdata() {
        title.setText("在线客服");
        service_rec.setLayoutManager(new LinearLayoutManager(this));
        List<String>list=new ArrayList<>();
        list.add("你好，请问有什么需要你帮助的在软件使用过程中遇到任何问题都可以询问我");
        list.add("请问开播过程为什么需要验证身份");
        list.add("你好，请问有什么需要你帮助的在软件使用过程中遇到任何问题都可以询问我");
        ServiceAdapter serviceAdapter = new ServiceAdapter(this);
        service_rec.setAdapter(serviceAdapter);
        serviceAdapter.setList(list);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.returns:
                finish();
                break;
        }
    }
}