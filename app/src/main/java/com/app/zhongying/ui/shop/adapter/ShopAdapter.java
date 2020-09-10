package com.app.zhongying.ui.shop.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.shop.activity.ShopCartActivity;
import com.app.zhongying.ui.shop.bean.ShopBean;
import com.app.zhongying.ui.shop.utils.Dp2Px;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context context;
    private List<ShopBean> data = new ArrayList<>();


    public ShopAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<ShopBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void removeData(ShopBean bean) {
        this.data.remove(bean);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopBean bean = data.get(position);
        RoundedCorners roundedCorners = new RoundedCorners(Dp2Px.dip2px(context, 15));
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(bean.getUrl()).apply(requestOptions).into(holder.mImg);
        final int[] num = {bean.getNum()};
        holder.shopNum.setText(num[0] + "");
        //点击加号
        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num[0]++;
                holder.shopNum.setText(num[0] + "");
                bean.setNum(num[0]);
                //默认为1 点击一次 将cb设置为true
                bean.setStatus(true);
                holder.cb1.setChecked(true);
                holder.cb2.setChecked(true);
                getSum();
            }
        });

        //点击减号
        holder.tvReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num[0] > 1) {
                    num[0]--;
                    holder.shopNum.setText(num[0] + "");
                    bean.setNum(num[0]);
                    getSum();
                } else {
                    Toast.makeText(context, "最少购买一件哦", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //默认选中的状态
        holder.cb2.setChecked(bean.isStatus());
        holder.cb1.setChecked(bean.isStatus());
        //设置监听
        holder.cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed()) {
                    //被点击后设置状态
                    bean.setStatus(b);
                    holder.cb1.setChecked(b);
                }
                //获取选中条目的价格
                getSum();
                setStatus(data);
            }
        });

        holder.cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed()) {
                    bean.setStatus(b);
                    holder.cb2.setChecked(b);

                }
                setStatus(data);
            }
        });

    }

    //当条目全部手动选中
    public void setStatus(List<ShopBean> data) {
        //当全部选中条目后activity的全选也要选中
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            boolean status = data.get(i).isStatus();
            if (status == true) {
                count++;
            }
        }
        if (count == data.size()) {
            ((ShopCartActivity) context).setStatus(true);
        } else {
            ((ShopCartActivity) context).setStatus(false);
        }

    }

    public void getSum() {
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            //数量
            int num = data.get(i).getNum();
            //价格
            int price = data.get(i).getPrice();
            if (data.get(i).isStatus() == true) {
                sum += (num * price);
            }
        }
        ((ShopCartActivity) context).setPrice(sum);
    }

    public List<ShopBean> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void statusChanged(boolean b) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setStatus(b);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb1)
        CheckBox cb1;
        @BindView(R.id.cb2)
        CheckBox cb2;
        @BindView(R.id.mImg)
        ImageView mImg;
        @BindView(R.id.tv_reduce)
        TextView tvReduce;
        @BindView(R.id.shopNum)
        TextView shopNum;
        @BindView(R.id.tv_add)
        TextView tvAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
