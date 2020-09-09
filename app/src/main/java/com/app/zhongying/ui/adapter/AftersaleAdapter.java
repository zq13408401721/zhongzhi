package com.app.zhongying.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import static com.app.zhongying.ui.adapter.CornerTransform.dip2px;

public class AftersaleAdapter extends RecyclerView.Adapter<AftersaleAdapter.ViewHolder> {
    Context context;

    public AftersaleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_aftersale, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
 /*       CornerTransform transformation = new CornerTransform(context, dip2px(context, 10));
//只是绘制左上角和右上角圆角
        transformation.setExceptCorner(false, false, false, false);

        Glide.with(context)
                .load(R.drawable.img_bg2)
                .skipMemoryCache(true)
                .transform(transformation)
                .into(holder.evaluate_zuzu_img);*/
        RoundedCorners roundedCorners = new RoundedCorners(30);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
 Glide.with(context).load(R.drawable.img_bg2).apply(requestOptions).into(holder.evaluate_zuzu_img);

    }

    @Override
    public int getItemCount() {
        return 4;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public View rootView;
        public TextView evaluate_Individual_stores;
        public TextView evaluate_zuzu_time_tv;
        public ImageView evaluate_zuzu_img;
        public TextView evaluate_zuzu_contont_tv;
        public TextView evaluate_zuzu_single_tv;
        public TextView evaluate_zuzu_price_tv;
        public Button button;
        public Button button2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.evaluate_Individual_stores = (TextView) rootView.findViewById(R.id.evaluate_Individual_stores);
            this.evaluate_zuzu_time_tv = (TextView) rootView.findViewById(R.id.evaluate_zuzu_time_tv);
            this.evaluate_zuzu_img = (ImageView) rootView.findViewById(R.id.evaluate_zuzu_img);
            this.evaluate_zuzu_contont_tv = (TextView) rootView.findViewById(R.id.evaluate_zuzu_contont_tv);
            this.evaluate_zuzu_single_tv = (TextView) rootView.findViewById(R.id.evaluate_zuzu_single_tv);
            this.evaluate_zuzu_price_tv = (TextView) rootView.findViewById(R.id.evaluate_zuzu_price_tv);
            this.button = (Button) rootView.findViewById(R.id.button);
            this.button2 = (Button) rootView.findViewById(R.id.button2);
        }
    }

}
