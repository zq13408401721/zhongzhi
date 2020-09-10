package com.app.zhongying.ui.live.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2020/9/10  14:38
 * Author: Lenovo.pzb
 * Project: Zhongying
 */
public class RlvFansAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;

    public RlvFansAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fans, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Glide.with(context).load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.circleCropTransform()).into(vh.ivHeader);
        vh.tvName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivHeader;
        public TextView tvName;
        public TextView tvTitle;

        public ViewHolder(View rootView) {
            super(rootView);
            this.ivHeader = (ImageView) rootView.findViewById(R.id.ivHeader);
            this.tvName = (TextView) rootView.findViewById(R.id.tvName);
            this.tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        }

    }
}
