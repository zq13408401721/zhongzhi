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

/**
 * Time: 2020/9/10  15:51
 * Author: Lenovo.pzb
 * Project: Zhongying
 */
public class LiveaRlvAdapter extends RecyclerView.Adapter<LiveaRlvAdapter.ViewHolder> {
    private Context context;
    private long mInt;

    public LiveaRlvAdapter(Context context, long i) {
        this.context = context;
        mInt = i;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rlv_live_txt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_text.setText("aaaaaaa");
    }


    @Override
    public int getItemCount() {
        return ((int) mInt);
    }



    class ViewHolder  extends RecyclerView.ViewHolder{
        public TextView tv_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
        }

    }
}
