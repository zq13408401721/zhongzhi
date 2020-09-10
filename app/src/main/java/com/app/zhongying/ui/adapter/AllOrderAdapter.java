package com.app.zhongying.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.own.meorder.ShowOrderActivity;

public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.ViewHolder> {
    Context context;

    public AllOrderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.allorder_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.allorder_showorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowOrderActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton allorder_raiobnt;
        TextView allorder_done;
        TextView allorder_time;
        ImageView allorder_img;
        TextView allorder_content;
        TextView allorder_single;
        TextView allorder_payment;
        Button allorder_afterdetail;
        Button allorder_showorder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            allorder_raiobnt = itemView.findViewById(R.id.allorder_raiobnt);
            allorder_done = itemView.findViewById(R.id.allorder_done);
            allorder_time = itemView.findViewById(R.id.allorder_time);
            allorder_img = itemView.findViewById(R.id.allorder_img);
            allorder_content = itemView.findViewById(R.id.allorder_content);
            allorder_single = itemView.findViewById(R.id.allorder_single);
            allorder_payment = itemView.findViewById(R.id.allorder_payment);
            allorder_afterdetail = itemView.findViewById(R.id.allorder_afterdetail);
            allorder_showorder = itemView.findViewById(R.id.allorder_showorder);
        }
    }
}
