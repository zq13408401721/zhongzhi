package com.app.zhongying;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.adapter.FlowLayout;
import com.app.zhongying.adapter.FlowLayoutAdapter;
import com.app.zhongying.view.TagAdapter;
import com.app.zhongying.www.db.RecordsDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SeekActivity extends AppCompatActivity {
    @BindView(R.id.moreArrow)
    ImageView moreArrow;
    @BindView(R.id.fl_search_records)
    FlowLayout flSearchRecords;
    @BindView(R.id.tv_hotdoreseek)
    TextView tvHotdoreseek;
    @BindView(R.id.aaa)
    RelativeLayout aaa;
    @BindView(R.id.tv1)
    TextView tv1;
    private RecordsDao mRecordsDao;
    //默然展示词条个数
    private final int DEFAULT_RECORD_NUMBER = 10;
    private List<String> recordList = new ArrayList<>();
    private TagAdapter mRecordsAdapter;


    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.tv_recentlyseek)
    TextView tvRecentlyseek;
    @BindView(R.id.iv_delet)
    ImageView ivDelet;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.layout3)
    LinearLayout layout3;
    @BindView(R.id.et_seek)
    EditText etSeek;
    private ArrayList<String> timeslIST;
    private FlowAdapter flowAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
        timeslIST = new ArrayList<>();
        flowAdapter = new FlowAdapter(timeslIST);
        flSearchRecords.setAdapter(flowAdapter);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = tvCancel.getText().toString();
                if (s.equals("取消")) {
                    //不进行任何操作
                    finish();
                } else {
                    //进行搜索并添加入最近搜索
                    String s1 = etSeek.getText().toString();
                    timeslIST.add(s1);
//                    mRecordsDao.addRecords("11111");
//                    mRecordsDao.addRecords("22222");
                    mRecordsDao.addRecords(s1);

                    //创建适配器
                    flowAdapter.notifyDataSetChanged();

                }

            }
        });
        //默认账号
        String username = "007";
        //初始化数据库
        mRecordsDao = new RecordsDao(this, username);

        final EditText editText = findViewById(R.id.et_seek);

        initData();

        etSeek.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    tvCancel.setText("搜索");
                } else {
                    tvCancel.setText("取消");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        moreArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除搜索历史
                editText.setText("");
            }
        });

        mRecordsDao.setNotifyDataChanged(new RecordsDao.NotifyDataChanged() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void notifyDataChanged() {
                initData();
            }
        });

        ivDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("确定要删除全部历史记录？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //清除所有数据
                        mRecordsDao.deleteUsernameAllRecords();
                        timeslIST.clear();
                    }
                });
            }
        });
    }

    class FlowAdapter extends FlowLayoutAdapter<String> {


        public FlowAdapter(List<String> list_bean) {
            super(list_bean);

        }

        @Override
        public void bindDataToView(ViewHolder holder, int position, String bean) {
            //获取布局id
            TextView tv = holder.getView(R.id.flow_item_tv);

            tv.setText(bean);



        }

        @Override
        public void onItemClick(int position, String bean, View view) {
            clear();
            notifyDataSetChanged();
        }

        @Override
        public int getItemLayoutID(int position, String bean) {
            return R.layout.flow_item_layout;
        }
    }

    private void showDialog(String dialogTitle, @NonNull DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SeekActivity.this);
        builder.setMessage(dialogTitle);
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    private void initData() {


        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                emitter.onNext(mRecordsDao.getRecordsByNumber(DEFAULT_RECORD_NUMBER));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> s) throws Exception {
                        recordList.clear();
                        recordList = s;
                        if (null == recordList || recordList.size() == 0) {
                            aaa.setVisibility(View.GONE);
                        } else {
                            aaa.setVisibility(View.VISIBLE);
                        }
                        if (mRecordsAdapter != null) {
                            mRecordsAdapter.setData(recordList);
                            mRecordsAdapter.notifyDataChanged();
                        }
                    }
                });
    }


    @Override
    protected void onDestroy() {
        mRecordsDao.closeDatabase();
        mRecordsDao.removeNotifyDataChanged();
        super.onDestroy();
    }
}


