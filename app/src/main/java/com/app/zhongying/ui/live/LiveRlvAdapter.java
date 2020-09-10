package com.app.zhongying.ui.live;

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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class LiveRlvAdapter extends RecyclerView.Adapter<LiveRlvAdapter.ViewHolder> {
    private Context context;
    private long mInt;

    public LiveRlvAdapter(Context context, long i) {
        this.context = context;
        mInt = i;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rlv_live, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(R.drawable.header).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.iv_item_liverv);
    }

    @Override
    public int getItemCount() {
        return ((int)mInt);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_item_liverv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_item_liverv = (ImageView) itemView.findViewById(R.id.Live_Item_ImageView);
        }
    }

}
