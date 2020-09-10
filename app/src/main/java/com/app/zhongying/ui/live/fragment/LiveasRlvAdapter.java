package com.app.zhongying.ui.live.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Time: 2020/9/10  15:51
 * Author: Lenovo.pzb
 * Project: Zhongying
 */
public class LiveasRlvAdapter extends RecyclerView.Adapter<LiveasRlvAdapter.ViewHolder> {
    private Context context;
    private List<String> data = new ArrayList<>();

    public LiveasRlvAdapter(Context context) {
        this.context = context;
    }

    @SuppressLint("NewApi")
    public void addData(String datas) {

        data.add(datas);
        if (data.size() > 20) {
            List<String> collect = data.stream().skip(data.size()-20).collect(Collectors.toList());
            data.clear();
            data.addAll(collect);
        }

        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rlv_live_txt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_text.setText(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
        }

    }
}
