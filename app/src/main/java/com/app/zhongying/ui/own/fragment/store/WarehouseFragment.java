package com.app.zhongying.ui.own.fragment.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WarehouseFragment extends Fragment {
    @BindView(R.id.rv_warehouse)
    RecyclerView rvWarehouse;
    private Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_warehouse, container, false);
        bind = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {
        rvWarehouse.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvWarehouse.setAdapter(new WarehouseRvAdapter());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
    class WarehouseRvAdapter extends RecyclerView.Adapter<WarehouseRvAdapter.ViewHolder>{


        @NonNull
        @Override
        public WarehouseRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.product_warehouse,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull WarehouseRvAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}