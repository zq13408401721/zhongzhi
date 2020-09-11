package com.app.zhongying.ui.shop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.MyAdapter;
import com.app.zhongying.ui.shop.utils.Dates;
import com.app.zhongying.ui.shop.utils.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

public class LookActivity extends AppCompatActivity {

    //一个横向的ListView
    List<Dates> datas = new ArrayList<Dates>();
    private HorizontalListView mlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);
        initView();
        initData();
        initAdapter();

    }

    private void initAdapter() {

        MyAdapter adapter = new MyAdapter((ArrayList<Dates>) datas, this);
        mlv.setAdapter(adapter);

    }


    /**
     * 这里用虚拟数据实现，仅供参考
     */
    private void initData() {
        // TODO Auto-generated method stub
        Dates item1 = new Dates();
        item1.setTime("下单");
        item1.setStatu(1);              //设置状态标记1 ，0
        Dates item2 = new Dates();
        item2.setTime("付款");
        item2.setStatu(1);
        Dates item3 = new Dates();
        item3.setTime("备货");
        item3.setStatu(0);
        Dates item4 = new Dates();
        item4.setTime("发货");
        item4.setStatu(0);
        Dates item5 = new Dates();
        item4.setTime("签收");
        item4.setStatu(0);

        datas.add(item1);
        datas.add(item2);
        datas.add(item3);
        datas.add(item4);
        datas.add(item5);
    }


    private void initView() {
        mlv = (HorizontalListView) findViewById(R.id.mlv);
    }
}