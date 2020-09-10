package com.app.zhongying.ui.own.login.fragments;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.app.zhongying.ui.own.login.activitys.ForgetActivity;

public class LoginFragment extends Fragment {

    private EditText mPhone;
    private EditText mPwd;
    private ImageView mVisi;
    private Button mLong_btn;
    private Button mLong_wechat_not;
    private Button mLong_wechat;
    private ImageView mSelect_yes;
    private ImageView mSelect_no;
    private TextView mForget;
    private String mPhone_num;
    private String mPhone_pwd;
    private boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPhone = view.findViewById(R.id.login_phone);
        mPwd = view.findViewById(R.id.login_pwd);
        mVisi = view.findViewById(R.id.login_visi);
        mLong_btn = view.findViewById(R.id.long_btn);
        mLong_wechat_not = view.findViewById(R.id.long_wechat_not);
        mLong_wechat = view.findViewById(R.id.long_wechat);
        mSelect_yes = view.findViewById(R.id.select_yes);
        mSelect_no = view.findViewById(R.id.select_no);
        mForget = view.findViewById(R.id.login_forget);
        initData();
    }

    private void initData() {
       mForget.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity(), ForgetActivity.class);
               startActivity(intent);
           }
       });
        mPhone_num = mPhone.getText().toString().trim();
        mPhone_pwd = mPwd.getText().toString().trim();

        mLong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(StringUtils.inputPhone(mPhone_num)){
                    if (StringUtils.inputEnglish(mPhone_pwd)){

                    } else if (StringUtils.inputNum(mPhone_pwd)){
                        Toast.makeText(getContext(),"注册成功",Toast.LENGTH_SHORT).show();

                    }else if (StringUtils.inputJudge(mPhone_pwd)){
                        Toast.makeText(getContext(),"注册成功",Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getContext(),"密码不符合标准",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(),"手机号不符合标准",Toast.LENGTH_SHORT).show();

                }
            }
        });
        mSelect_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelect_no.getVisibility() == View.VISIBLE){
                    mSelect_no.setVisibility(View.INVISIBLE);
                    mSelect_yes.setVisibility(View.VISIBLE);
                    mLong_wechat_not.setVisibility(View.INVISIBLE);
                    mLong_wechat.setVisibility(View.VISIBLE);
                }else {
                    mSelect_no.setVisibility(View.VISIBLE);
                    mSelect_yes.setVisibility(View.INVISIBLE);
                    mLong_wechat_not.setVisibility(View.VISIBLE);
                    mLong_wechat.setVisibility(View.INVISIBLE);
                }
            }
        });

        mVisi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (flag) {
                    mPwd.setInputType(View.AUTOFILL_TYPE_NONE);
                    flag=false;
                }else{
                    mPwd.setInputType(mPwd.getInputType());
                    flag=true;
                }
            }
        });
    }
}
