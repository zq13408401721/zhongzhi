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

import java.util.ArrayList;
import java.util.List;

public class LiveRvAdapter extends RecyclerView.Adapter<LiveRvAdapter.ViewHolder> {
    private Context context;
    private List<String> strings;
    private onItemClickListerner onItemClickListerner;

    public void setOnItemClickListerner(LiveRvAdapter.onItemClickListerner onItemClickListerner) {
        this.onItemClickListerner = onItemClickListerner;
    }

    public LiveRvAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_live, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_item_liverv.setText(strings.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListerner.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_item_liverv;
        public TextView tv_item_liverv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_item_liverv = (ImageView) itemView.findViewById(R.id.iv_item_liverv);
            this.tv_item_liverv = (TextView) itemView.findViewById(R.id.tv_item_liverv);
        }
    }

    public interface onItemClickListerner {
        void onItemClick(int postion);
    }

}
