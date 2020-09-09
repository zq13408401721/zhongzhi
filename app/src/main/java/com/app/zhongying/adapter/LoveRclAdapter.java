package com.app.zhongying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class LoveRclAdapter extends RecyclerView.Adapter {
    Context context;
    List list = new ArrayList();

    public LoveRclAdapter(Context context) {
        this.context = context;
    }

    public void setList(List list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_love_rcl, parent, false);
        return new HolderItem(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HolderItem holderItem = (HolderItem) holder;
        Glide.with(context).load(R.mipmap.ic_launcher).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holderItem.imgImage);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class HolderItem extends RecyclerView.ViewHolder {

        private ImageView imgImage;

        public HolderItem(View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.img_image);
        }
    }
}
