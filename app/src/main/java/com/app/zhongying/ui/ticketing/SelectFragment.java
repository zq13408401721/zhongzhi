package com.app.zhongying.ui.ticketing;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.app.zhongying.R;

import java.util.ArrayList;
import java.util.List;

public class SelectFragment extends Fragment {

    private SeatSelectView seat;
    private ReserveActivity activity;
    private List<Point> list= new ArrayList<>();
    private ILoad iLoad;

    public void setiLoad(ILoad iLoad) {
        iLoad.getList(list);
    }

    public SelectFragment(ReserveActivity activity) {
        this.activity = activity;
    }

    public SelectFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        seat = view.findViewById(R.id.seat);
        seat.setData(5, 6);
    }

    private static final String TAG = "SelectFragment";

    public void getData(List<Point> data) {
        Log.d(TAG, "getData: " + data.size());
        if(data!=null&&data.size()>0){
            list.clear();
            list.addAll(data);
        }
    }

    interface ILoad {
        void getList(List<Point> data);
    }

}