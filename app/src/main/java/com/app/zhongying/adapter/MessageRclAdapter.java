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
import java.util.List;

public class MessageRclAdapter extends RecyclerView.Adapter {
    private Context context;
    private List list = new ArrayList();

    public MessageRclAdapter(Context context) {
        this.context = context;
    }

    public void setList(List list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_message_item, parent, false);
        return new HolderItem(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    private class HolderItem extends RecyclerView.ViewHolder {

        private ImageView imgHead;
        private TextView tvName;
        private TextView tvContent;

        public HolderItem(View inflate) {
            super(inflate);
            imgHead = inflate.findViewById(R.id.img_head);
            tvName = inflate.findViewById(R.id.tv_name);
            tvContent = inflate.findViewById(R.id.tv_content);
        }
    }
}
