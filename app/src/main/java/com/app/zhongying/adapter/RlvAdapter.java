package com.app.zhongying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;


import com.app.zhongying.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Time: 2020/9/8  20:36
 * Author: Lenovo.pzb
 * Project: Mall
 */
public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Integer> list;

    public RlvAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_po, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Integer integer = list.get(position);
        ViewHolder vh = (ViewHolder) holder;
        Glide.with(context).load(integer).into(vh.iv_rlv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_rlv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.iv_rlv = (ImageView) rootView.findViewById(R.id.iv_rlv);
        }

    }
}
