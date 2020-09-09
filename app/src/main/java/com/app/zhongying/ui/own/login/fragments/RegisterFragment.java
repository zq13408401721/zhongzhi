package com.app.zhongying.ui.own.login.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.zhongying.R;

import butterknife.BindView;

public class RegisterFragment extends Fragment {


    private Button mRegister_ver;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_register, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRegister_ver = view.findViewById(R.id.register_ver);
        mRegister_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "1234234", Toast.LENGTH_SHORT).show();
                CountDownTimer timer = new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        mRegister_ver.setText("获取验证码（"+l/1000+")秒");
                    }

                    @Override
                    public void onFinish() {
                        mRegister_ver.setText("获取验证码");
                    }
                };
                timer.start();
            }
        });
    }

}
