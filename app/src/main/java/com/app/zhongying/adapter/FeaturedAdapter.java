package com.app.zhongying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<String> list;

    public FeaturedAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rv_featured, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView reccommend_tu;
        public ImageView huang;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.reccommend_tu = (ImageView) rootView.findViewById(R.id.reccommend_tu);
            this.huang = (ImageView) rootView.findViewById(R.id.huang);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }
    }
}
