package com.app.zhongying.activity.own;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aigestudio.wheelpicker.WheelPicker;
import com.app.zhongying.R;

import java.util.ArrayList;
import java.util.List;

public class Modify_userActivity extends AppCompatActivity implements View.OnClickListener, WheelPicker.OnItemSelectedListener {

    private ImageView returns;
    private TextView title;
    private ImageView modify_head_img;
    private ImageView modify_head;
    private TextView modify_name;
    private ImageView modify_name_img;
    private TextView modify_resume;
    private ImageView modify_resume_img;
    private TextView modify_sex;
    private ImageView modify_sex_img;
    private TextView modify_age;
    private ImageView modify_age_img;
    private TextView modify_phone;
    private ImageView modify_phone_img;
    private TextView photograph;
    private TextView album;
    private TextView cancel;
    private PopupWindow popWnd;
    private LinearLayout layout;
    private PopupWindow popWnds;
    private WheelPicker sex;
    private TextView cancel_sex;
    private TextView determine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        initView();
    }

    private void initView() {
        returns = (ImageView) findViewById(R.id.returns);
        title = (TextView) findViewById(R.id.title);
        layout = (LinearLayout) findViewById(R.id.line);
        modify_head_img = (ImageView) findViewById(R.id.modify_head_img);

        modify_head = (ImageView) findViewById(R.id.modify_head);
        modify_head.setOnClickListener(this);
        modify_name = (TextView) findViewById(R.id.modify_name);
        modify_name_img = (ImageView) findViewById(R.id.modify_name_img);
        modify_name_img.setOnClickListener(this);
        modify_resume = (TextView) findViewById(R.id.modify_resume);
        modify_resume_img = (ImageView) findViewById(R.id.modify_resume_img);
        modify_resume_img.setOnClickListener(this);
        modify_sex = (TextView) findViewById(R.id.modify_sex);
        modify_sex_img = (ImageView) findViewById(R.id.modify_sex_img);
        modify_sex_img.setOnClickListener(this);
        modify_age = (TextView) findViewById(R.id.modify_age);
        modify_age_img = (ImageView) findViewById(R.id.modify_age_img);
        modify_age_img.setOnClickListener(this);
        modify_phone = (TextView) findViewById(R.id.modify_phone);
        modify_phone_img = (ImageView) findViewById(R.id.modify_phone_img);
        modify_phone_img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.modify_head:
                View contentView = LayoutInflater.from(this).inflate(R.layout.head_popupwindow, null);
                photograph = contentView.findViewById(R.id.photograph);
                album = contentView.findViewById(R.id.album);
                cancel = contentView.findViewById(R.id.cancel);
                cancel.setOnClickListener(this);
                popWnd = new PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

               popWnd.showAtLocation(layout, Gravity.CENTER_VERTICAL,0,0);


                break;
            case R.id.modify_name_img:
                Intent nameintent = new Intent(this,Modify_nameActivity.class);
                String name = modify_name.getText().toString();
                nameintent.putExtra("name",name);
                startActivity(nameintent);
                break;
            case R.id.modify_sex_img:

                View views = LayoutInflater.from(this).inflate(R.layout.sex_modify, null);
                cancel_sex = views.findViewById(R.id.cancel_sex);
                determine = views.findViewById(R.id.determine_sex);
                sex = views.findViewById(R.id.wheel_sex);

                sex.setIndicator(true);
                sex.setIndicatorColor(getResources().getColor(R.color.colorwhite));
                List<String> data = new ArrayList<>();
                data.add("男");
                data.add("女");

                sex.setData(data);
                sex.setOnItemSelectedListener(this);
                cancel_sex.setOnClickListener(this);
                determine.setOnClickListener(this);
                popWnds = new PopupWindow(views,ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                popWnds.showAtLocation(layout, Gravity.BOTTOM,0,0);
                break;
            case R.id.modify_resume_img:
                Intent intent = new Intent(this,ResumeActivity.class);
                startActivity(intent);
                break;
            case R.id.modify_age_img:
                Intent daterintent = new Intent(this,Modify_DateActivity.class);
                startActivity(daterintent);
                break;
            case R.id.modify_phone_img:
                break;
            case R.id.cancel:
                popWnd.dismiss();
                break;
            case R.id.cancel_sex:
                popWnds.dismiss();
                break;
            case R.id.determine_sex:
                popWnds.dismiss();
                break;
            case R.id.returns:
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {

    }
}