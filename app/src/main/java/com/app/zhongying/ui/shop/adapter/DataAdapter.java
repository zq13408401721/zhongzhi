package com.app.zhongying.ui.shop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<String> data = new ArrayList<>();
    private Context context;
    private boolean isFirst=true;
    public DataAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<String> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = data.get(position);
        holder.mTitle.setText(s);

        holder.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFirst == true) {
                    holder.mTitle.setBackgroundResource(R.drawable.shape_pop_button);
                    holder.mTitle.setTextColor(Color.WHITE);
                    isFirst = false;
                } else {
                    holder.mTitle.setBackgroundResource(R.drawable.shape_pop_item);
                    holder.mTitle.setTextColor(Color.BLACK);
                    isFirst = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
