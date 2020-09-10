package com.app.zhongying.ui.own.meorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.OrderAdapter;

public class ObligationFragment extends Fragment {
    private ImageView obligation_commodity;
    private TextView obligation_Seller;
    private TextView obligation_Username;
    private TextView obligation_name;
    private TextView obligation_single;
    private TextView obligation_payment;
    private Button obligation_afterdetail;
    private Button obligation_showorder;
    private CardView Receiving_CardView;
    private RecyclerView obligation_rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_obligation, null);
        iniView(inflate);
        return inflate;
    }

    private void iniView(View inflate) {
        obligation_commodity = inflate.findViewById(R.id.obligation_commodity);
        obligation_Seller = inflate.findViewById(R.id.obligation_Seller);
        obligation_Username = inflate.findViewById(R.id.obligation_Username);
        obligation_name = inflate.findViewById(R.id.obligation_name);
        obligation_single = inflate.findViewById(R.id.obligation_single);
        obligation_payment = inflate.findViewById(R.id.obligation_payment);
        obligation_afterdetail = inflate.findViewById(R.id.obligation_afterdetail);
        obligation_showorder = inflate.findViewById(R.id.obligation_showorder);
        obligation_rv = inflate.findViewById(R.id.obligation_rv);
        obligation_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        OrderAdapter orderAdapter = new OrderAdapter(getActivity());
        obligation_rv.setAdapter(orderAdapter);
    }
}