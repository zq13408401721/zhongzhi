package com.app.zhongying.ui.shop.fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.zhongying.R;
import com.app.zhongying.ui.shop.adapter.RvAdapter;

import java.util.ArrayList;

public class CreativeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_creative, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.rv);

        ArrayList<String> imgs = new ArrayList<>();
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.one));
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.two));
        imgs.add(getStringFromDrawableRes(getContext(), R.drawable.three));

        rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        RvAdapter rvAdapter = new RvAdapter(getContext());
        rv.setAdapter(rvAdapter);

    }
    public static String getStringFromDrawableRes(Context context, int id) {

        Resources resources = context.getResources();

        String path = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"

                + resources.getResourcePackageName(id) + "/"

                + resources.getResourceTypeName(id) + "/"

                + resources.getResourceEntryName(id);

        return path;

    }
}