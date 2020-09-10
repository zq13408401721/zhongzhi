package com.app.zhongying.ui.own.login.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    private CheckBox mselect_register;
    private Button mbtn_register;
    private EditText mRegister_phone;
    private EditText mVerification;
    private EditText mRegister_verCode;
    private EditText mRegister_pwd;
    private boolean isOK = false;
    private ImageView mRegister_visi;

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
        mselect_register = view.findViewById(R.id.select_register);
        mbtn_register = view.findViewById(R.id.btn_register);
        mRegister_phone = view.findViewById(R.id.register_phone);
        mVerification = view.findViewById(R.id.verification);
        mRegister_verCode = view.findViewById(R.id.register_verCode);
        mRegister_pwd = view.findViewById(R.id.register_pwd);
        mRegister_visi = view.findViewById(R.id.register_visi);
        mRegister_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "1234234", Toast.LENGTH_SHORT).show();
                mRegister_ver.setClickable(false);
                CountDownTimer timer = new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        mRegister_ver.setText("获取验证码（" + l / 1000 + ")秒");
                    }

                    @Override
                    public void onFinish() {
                        mRegister_ver.setText("获取验证码");
                        mRegister_ver.setClickable(true);
                    }
                };
                timer.start();
            }
        });
        mselect_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mselect_register.isSelected()) {
                    mselect_register.setChecked(false);
                    mselect_register.setSelected(false);
                } else if (!mselect_register.isSelected()) {
                    mselect_register.setChecked(true);
                    mselect_register.setSelected(true);
                }
            }
        });
        mbtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!StringUtils.isMobile(mRegister_phone.getText().toString())) {
                    Toast.makeText(getActivity(), "手机号不符合标准", Toast.LENGTH_SHORT).show();
                } else if (mVerification.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "验证码不能为空", Toast.LENGTH_SHORT).show();
                } else if (mRegister_pwd.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mRegister_visi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRegister_pwd.getInputType()==129) {
                    mRegister_pwd.setInputType(128);
                } else {
                    mRegister_pwd.setInputType(129);
                }
            }
        });
    }

}
