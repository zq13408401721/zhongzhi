package com.app.zhongying.ui.own;

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

public class OutOfPrintFragment extends Fragment {


    @BindView(R.id.rv)
    RecyclerView rv;
    private Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_out_of_print, container, false);
        bind = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        OutPrintRvAdapter outPrintRvAdapter = new OutPrintRvAdapter();
        rv.setAdapter(outPrintRvAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
    class OutPrintRvAdapter extends RecyclerView.Adapter<OutPrintRvAdapter.ViewHolder>{

        @NonNull
        @Override
        public OutPrintRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.product_outprint,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull OutPrintRvAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}