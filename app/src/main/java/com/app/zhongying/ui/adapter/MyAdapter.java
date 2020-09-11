package com.app.zhongying.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zhongying.R;
import com.app.zhongying.ui.shop.utils.Dates;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter {
 
    private ArrayList<Dates> datas;
    Context context;
 
 
    public MyAdapter(ArrayList<Dates> dates, Context context) {
        super();
        this.datas = dates;
        this.context = context;
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return datas.size();
    }
 
    @Override
    public Object getItem(int position) {
//        if(position > this.datas.size()){
//            return null;
//        }
        return datas.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Item item=null;
        if (convertView == null) {
            item = new Item();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view2, null);
            item.time = (TextView) convertView.findViewById(R.id.show_time);
            item.title = (TextView) convertView.findViewById(R.id.show_title);
            item.lineNorma = (View) convertView.findViewById(R.id.line_normal);
            item.lineHiLight = (View) convertView.findViewById(R.id.line_highlight);
            item.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(item);
 
        } else {
            item = (Item) convertView.getTag();
        }
 
 
        //根据数据状态对视图做不同的操作
        if (datas.get(position).getStatu() == 1) {
            item.lineHiLight.setVisibility(View.VISIBLE);
            /**
             * 看这
             * 里
             *
             *
             */

            item.image.setImageResource(R.drawable.yseture);
            item.time.setVisibility(View.VISIBLE);
        }
 
        item.time.setText(datas.get(position).getTime());
        item.title.setText(datas.get(position).getTitle());
 
 
        //这里在起始位置，就不显示“轴”了
        if (position == 0) {
            item.lineNorma.setVisibility(View.INVISIBLE);
            item.lineHiLight.setVisibility(View.INVISIBLE);
        }
 
        return convertView;
    }
 
    private class Item {
        TextView time, title;
        View lineNorma, lineHiLight;
        ImageView image;
    }
}