package com.app.zhongying.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.MainActivity;
import com.app.zhongying.R;
import com.app.zhongying.ui.adapter.TitlebarView;
import com.hedgehog.ratingbar.RatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

public class EvaluateActivity extends AppCompatActivity {

    @BindView(R.id.title2)
    TitlebarView title2;
    @BindView(R.id.evaluate_zuzu_img)
    ImageView evaluateZuzuImg;
    @BindView(R.id.evaluate_zuzu_contont_tv)
    TextView evaluateZuzuContontTv;
    @BindView(R.id.evaluate_zuzu_single_tv)
    TextView evaluateZuzuSingleTv;
    @BindView(R.id.evaluate_zuzu_price_tv)
    TextView evaluateZuzuPriceTv;
    @BindView(R.id.ratingbar)
    RatingBar ratingbar;
    @BindView(R.id.very_good_tv)
    TextView veryGoodTv;
    @BindView(R.id.good_tv)
    TextView goodTv;
    @BindView(R.id.ordinary_tv)
    TextView ordinaryTv;
    @BindView(R.id.veary_bad_tv)
    TextView vearyBadTv;
    @BindView(R.id.edit_img)
    ImageView editImg;
    @BindView(R.id.textView)
    EditText textView;
    @BindView(R.id.content_tv)
    TextView contentTv;
    @BindView(R.id.jiahao_img)
    ImageView jiahaoImg;
    @BindView(R.id.public_tv)
    TextView publicTv;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.xing_tv1)
    RatingBar xingTv1;
    @BindView(R.id.xing_tv2)
    RatingBar xingTv2;

    //相机相册id
    private final int RC_CAMERA = 1;
    private final int RC_ALBUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        setContentView(R.layout.activity_evaluate2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title2.setRightText("发布");

        title2.setTitle("发表评价");

        title2.setLeftDrawable(R.mipmap.huitui);

        title2.setTitleSize(20);

        title2.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(EvaluateActivity.this, "回去", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {

            }
        });

        //加号图片
        jiahaoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPhoto();
            }
        });


        //五角星
        ratingbar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float RatingCount) {

                if (RatingCount == 1) {
                    ordinaryTv.setVisibility(View.GONE);
                    vearyBadTv.setVisibility(View.VISIBLE);
                    goodTv.setVisibility(View.GONE);
                    veryGoodTv.setVisibility(View.GONE);
                }
                if (RatingCount == 2) {
                    ordinaryTv.setVisibility(View.VISIBLE);
                    vearyBadTv.setVisibility(View.GONE);
                    goodTv.setVisibility(View.GONE);
                    veryGoodTv.setVisibility(View.GONE);
                }
                if (RatingCount == 3) {
                    ordinaryTv.setVisibility(View.GONE);
                    vearyBadTv.setVisibility(View.GONE);
                    goodTv.setVisibility(View.VISIBLE);
                    veryGoodTv.setVisibility(View.GONE);
                }
                if (RatingCount == 4) {
                    ordinaryTv.setVisibility(View.GONE);
                    vearyBadTv.setVisibility(View.GONE);
                    goodTv.setVisibility(View.GONE);
                    veryGoodTv.setVisibility(View.VISIBLE);
                }
                if (RatingCount == 5) {
                    ordinaryTv.setVisibility(View.GONE);
                    vearyBadTv.setVisibility(View.GONE);
                    goodTv.setVisibility(View.GONE);
                    veryGoodTv.setVisibility(View.VISIBLE);
                }
            }
        });

        contentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
                contentTv.setVisibility(View.GONE);
                editImg.setVisibility(View.GONE);
            }
        });
    }

    private void openPhoto() {
        //定义dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(EvaluateActivity.this);
        builder.setTitle("请选择");
        builder.setItems(new String[]{"相机", "相册"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    //相机
                    case 0:
                        Intent intent_camera = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent_camera, RC_CAMERA);//rc_camera
                        break;
                    //相册
                    case 1:
                        Intent intent_album = new Intent(Intent.ACTION_PICK);
                        intent_album.setType("image/*");
                        startActivityForResult(intent_album, RC_ALBUM);
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RC_CAMERA:
                Toast.makeText(EvaluateActivity.this, "相机回调", Toast.LENGTH_SHORT).show();
                break;
            case RC_ALBUM:
                Toast.makeText(EvaluateActivity.this, "相册回调", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}