package com.app.zhongying.ui.adapter;

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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {
    Context context;

    public EvaluateAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemevaluate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoundedCorners roundedCorners = new RoundedCorners(30);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(R.drawable.img_bg2).apply(requestOptions).into(holder.item_evaluate_zuanshi_img);
    }

    @Override
    public int getItemCount() {
        return 10;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView imageView;
        public ImageView item_evaluate_zuanshi_img;
        public TextView item_evaluate_integral_tv;
        public TextView item_evaluate_content_tv;
        public TextView item_evaluate_price_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.imageView = (ImageView) rootView.findViewById(R.id.imageView);
            this.item_evaluate_zuanshi_img = (ImageView) rootView.findViewById(R.id.item_evaluate_zuanshi_img);
            this.item_evaluate_integral_tv = (TextView) rootView.findViewById(R.id.item_evaluate_integral_tv);
            this.item_evaluate_content_tv = (TextView) rootView.findViewById(R.id.item_evaluate_content_tv);
            this.item_evaluate_price_tv = (TextView) rootView.findViewById(R.id.item_evaluate_price_tv);
        }
    }

}
