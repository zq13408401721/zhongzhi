package com.app.zhongying.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.EvaluateAdapter;

public class EvaluateFragment extends Fragment {
//tv
    private TextView evaluate_Individual_stores;
    private TextView evaluate_zuzu_time_tv;
    private ImageView evaluate_zuzu_img;
    private TextView evaluate_zuzu_contont_tv;
    private TextView evaluate_zuzu_single_tv;
    private TextView evaluate_zuzu_price_tv;
    private TextView evaluate_zuzu_like_tv;
    //but
    private Button button;

   //rv
    private RecyclerView evaluate_zuzu_rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluate, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
       /* evaluate_Individual_stores = view.findViewById(R.id.evaluate_Individual_stores);
        evaluate_zuzu_time_tv = view.findViewById(R.id.evaluate_zuzu_time_tv);
        evaluate_zuzu_img = view.findViewById(R.id.evaluate_zuzu_img);
        evaluate_zuzu_contont_tv = view.findViewById(R.id.evaluate_zuzu_contont_tv);
        evaluate_zuzu_single_tv = view.findViewById(R.id.evaluate_zuzu_single_tv);
        evaluate_zuzu_price_tv = view.findViewById(R.id.evaluate_zuzu_price_tv);
        button = view.findViewById(R.id.button);
        evaluate_zuzu_like_tv = view.findViewById(R.id.evaluate_zuzu_like_tv);
        evaluate_zuzu_rv = view.findViewById(R.id.evaluate_zuzu_rv);

        evaluate_zuzu_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));

        EvaluateAdapter evaluateAdapter = new EvaluateAdapter(getActivity());
        evaluate_zuzu_rv.setAdapter(evaluateAdapter);

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EvaluateActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
