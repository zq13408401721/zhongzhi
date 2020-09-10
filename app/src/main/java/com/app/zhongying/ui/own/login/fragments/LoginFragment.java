package com.app.zhongying.ui.own.login.fragments;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.app.zhongying.ui.own.login.activitys.ForgetActivity;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

public class LoginFragment extends Fragment {

    private EditText mPhone;
    private EditText mPwd;
    private ImageView mVisi;
    private Button mLong_btn;
    private Button mLong_wechat_not;
    private CheckBox mSelect_no;
    private TextView mForget;
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

        /*//  去除中文
        mPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length()>0){
                    for (int i = 0; i < editable.length(); i++) {
                        char c = editable.charAt(i);
                        if (c >= 0x4e00 && c <= 0X9fff) { // 根据字节码判断
                            // 如果是中文，则清除输入的字符，否则保留
                            editable.delete(i,i+1);
                        }
                    }
                }
                String pwd = mPwd.getText().toString();
                    pwd = editable.toString();
            }
        });
*/
        mLong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Phone_num = mPhone.getText().toString();
                String Pwd = mPwd.getText().toString();
                if (!StringUtils.isMobile(Phone_num)) {
                    Toast.makeText(getActivity(), "电话号不符合标准", Toast.LENGTH_SHORT).show();
                } else if (Pwd.isEmpty()) {
                    Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSelect_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelect_no.isSelected()) {
                    mSelect_no.setChecked(false);
                    mSelect_no.setSelected(false);
                    mLong_wechat_not.setBackgroundDrawable(getResources().getDrawable(R.drawable.gray_shap));
                } else if (!mSelect_no.isSelected()) {
                    mSelect_no.setChecked(true);
                    mSelect_no.setSelected(true);
                    mLong_wechat_not.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_shap));
                }
            }
        });

        mVisi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mPwd.getInputType()==129) {
                  //  mPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mPwd.setInputType(128);
                } else {
                    //mPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mPwd.setInputType(129);
                }

            }
        });
    }
}
