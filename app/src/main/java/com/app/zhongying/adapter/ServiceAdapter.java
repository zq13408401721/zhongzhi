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

public class ServiceAdapter extends RecyclerView.Adapter {
    private List<String>list=new ArrayList<>();
    private Context context;

    public ServiceAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.service_left, parent, false);
            return new holderleft(inflate);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.service_riget, parent, false);
        return new holderriget(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==1){
            holderleft holderleft= (ServiceAdapter.holderleft) holder;
            holderleft.text.setText(list.get(position));
            if (position==2){
                holderleft.date.setVisibility(View.GONE);
            }
        }
        if (itemViewType==2){
            holderriget holderriget= (ServiceAdapter.holderriget) holder;
            holderriget.text.setText(list.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
       if (position%2==1){
           return 2;
       }
       return 1;
    }
    class holderleft extends RecyclerView.ViewHolder {
        private TextView date;
        private ImageView head;
        private TextView text;
        public holderleft(@NonNull View itemView) {
            super(itemView);
           date= itemView.findViewById(R.id.service_date);
            head= itemView.findViewById(R.id.service_head);
            text= itemView.findViewById(R.id.service_text);
        }
    }
    class holderriget extends RecyclerView.ViewHolder {
        private TextView date;
        private ImageView head;
        private TextView text;
        public holderriget(@NonNull View itemView) {
            super(itemView);
            date= itemView.findViewById(R.id.service_date);
            head= itemView.findViewById(R.id.service_head);
            text= itemView.findViewById(R.id.service_text);
        }
    }
}
