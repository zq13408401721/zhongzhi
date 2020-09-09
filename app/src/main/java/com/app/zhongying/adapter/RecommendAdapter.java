package com.app.zhongying.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.home.activity.ArticledetailsActivity;

import java.util.ArrayList;

public class RecommendAdapter extends RecyclerView.Adapter {
    private ArrayList<String> list;
    private Context context;

    public RecommendAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.carview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArticledetailsActivity.class);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickLis != null) onItemClickLis.click(position);
                Intent intent = new Intent(context, ArticledetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView reccommend_tu;
        public ImageView huang;
        public TextView tv_title;
        public CardView carview;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.carview = rootView.findViewById(R.id.carview);
            this.reccommend_tu = (ImageView) rootView.findViewById(R.id.reccommend_tu);
            this.huang = (ImageView) rootView.findViewById(R.id.huang);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
    private OnItemClickLis onItemClickLis;

    public void setOnItemClickLis(OnItemClickLis onItemClickLis) {
        this.onItemClickLis = onItemClickLis;
    }

    public interface OnItemClickLis{
        void click(int position);
    }
}
