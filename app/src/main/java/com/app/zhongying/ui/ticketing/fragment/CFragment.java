package com.app.zhongying.ui.ticketing.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.app.zhongying.R;
import com.app.zhongying.ui.ticketing.activity.MovieActivity;
import com.app.zhongying.ui.ticketing.activity.ShowTicketActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class CFragment extends Fragment {

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView cdB_1 = view.findViewById(R.id.cdC_1);
        CardView cdB_2 = view.findViewById(R.id.cdC_2);
        CardView cdB_3 = view.findViewById(R.id.cdC_3);
        CardView cdB_4 = view.findViewById(R.id.cdC_4);
        cdB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MovieActivity.class);
                startActivity(intent);
            }
        });
        cdB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MovieActivity.class);
                startActivity(intent);
            }
        });
        cdB_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MovieActivity.class);
                startActivity(intent);
            }
        });
        cdB_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MovieActivity.class);
                startActivity(intent);
            }
        });
    }
}