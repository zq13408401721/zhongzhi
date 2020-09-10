package com.app.zhongying.activity.own;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.aigestudio.wheelpicker.WheelPicker;
import com.app.zhongying.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Modify_userActivity extends AppCompatActivity implements View.OnClickListener, WheelPicker.OnItemSelectedListener {

    private RelativeLayout returns;
    private TextView title;
    private ImageView modify_head_img;
    private RelativeLayout modify_head;
    private TextView modify_name;
    private RelativeLayout modify_name_img;
    private TextView modify_resume;
    private RelativeLayout modify_resume_img;
    private TextView modify_sex;
    private RelativeLayout modify_sex_img;
    private TextView modify_age;
    private RelativeLayout modify_age_img;
    private TextView modify_phone;
    private RelativeLayout modify_phone_img;
    private TextView photograph;
    private TextView album;
    private TextView cancel;
    private PopupWindow popWnd;
    private LinearLayout layout;
    private PopupWindow popWnds;
    private WheelPicker sex;
    private TextView cancel_sex;
    private TextView determine;
    private View contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        initView();
    }

    private void initView() {
        returns = (RelativeLayout) findViewById(R.id.returns);
        returns.setOnClickListener(this);
        title = (TextView) findViewById(R.id.title);
        layout = (LinearLayout) findViewById(R.id.line);
        modify_head_img = (ImageView) findViewById(R.id.modify_head_img);

        modify_head = (RelativeLayout) findViewById(R.id.modify_head);
        modify_head.setOnClickListener(this);
        modify_name = (TextView) findViewById(R.id.modify_name);
        modify_name_img = (RelativeLayout) findViewById(R.id.modify_name_img);
        modify_name_img.setOnClickListener(this);
        modify_resume = (TextView) findViewById(R.id.modify_resume);
        modify_resume_img = (RelativeLayout) findViewById(R.id.modify_resume_img);
        modify_resume_img.setOnClickListener(this);
        modify_sex = (TextView) findViewById(R.id.modify_sex);
        modify_sex_img = (RelativeLayout) findViewById(R.id.modify_sex_img);
        modify_sex_img.setOnClickListener(this);
        modify_age = (TextView) findViewById(R.id.modify_age);
        modify_age_img = (RelativeLayout) findViewById(R.id.modify_age_img);
        modify_age_img.setOnClickListener(this);
        modify_phone = (TextView) findViewById(R.id.modify_phone);
        modify_phone_img = (RelativeLayout) findViewById(R.id.modify_phone_img);
        modify_phone_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.modify_head:

                onphotograph();

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

    private void onphotograph() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            //Toast.makeText(MainActivity.this,"您申请了动态权限",Toast.LENGTH_SHORT).show();
        }else{
            //否则去请求相机权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);

        }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final AlertDialog dialog = builder.create();
        contentView = LayoutInflater.from(this).inflate(R.layout.head_popupwindow, null);
        photograph = contentView.findViewById(R.id.photograph);
        popWnd = new PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popWnd.showAtLocation(layout, Gravity.CENTER_VERTICAL,0,0);
        album = contentView.findViewById(R.id.album);
        cancel = contentView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWnd.dismiss();
            }
        });
        album.setOnClickListener(new View.OnClickListener() {// 在相册中选取
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                dialog.dismiss();
            }
        });
        photograph.setOnClickListener(new View.OnClickListener() {// 调用照相机
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent2, 2);// 采用ForResult打开
                dialog.dismiss();
            }
        });
        dialog.setView(contentView);
      //  dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }
                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                   Bitmap head = extras.getParcelable("data");
                    if (head != null) {
/**
 * 上传服务器代码
 */
                        setPicToView(head);// 保存在SD卡中
                        modify_head_img.setImageBitmap(head);// 用ImageView显示出来
                        popWnd.dismiss();
                    }
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
// aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
// outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
         String path = "/sdcard/myHead/";// sd路径
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
// 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {

    }
}