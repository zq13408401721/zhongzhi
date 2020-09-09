package com.app.zhongying.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import com.app.zhongying.ui.shopbean.ShopBean;

import java.util.ArrayList;
import java.util.List;
//商品详情页里面的适配器
public class InfoAdapter extends RecyclerView.Adapter {

    Context mContext;

    List<ShopBean> datas = new ArrayList<>();

    public InfoAdapter(Context context) {
        mContext = context;
    }

    public void addDataList(List<ShopBean> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.shop_item, parent, false);
        return new ItemViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShopBean bean = datas.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.item_iv.setBackgroundResource(bean.getPic());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static
    class ItemViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView item_iv;

        public ItemViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_iv = (ImageView) rootView.findViewById(R.id.item_iv);
        }

    }
}
