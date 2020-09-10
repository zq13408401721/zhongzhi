package com.app.zhongying.ui.own;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.zhongying.R;
import com.app.zhongying.activity.own.Modify_userActivity;
import com.app.zhongying.activity.own.ServiceActivity;
import com.app.zhongying.ui.own.activities.MessageActivity;
import com.app.zhongying.ui.own.activities.MyLoveActivity;
import com.app.zhongying.ui.own.mywallet.MyWalletActivity;

public class OwnFragment extends Fragment implements View.OnClickListener {


    private ImageView own_head;
    private LinearLayout own_Payment;
    private LinearLayout own_Cons;
    private LinearLayout own_Goods;
    private LinearLayout own_Evaluate;
    private LinearLayout own_After;
    private LinearLayout own_integral;
    private LinearLayout own_balance;
    private LinearLayout own_core;
    private LinearLayout own_detailed;
    private LinearLayout own_binding;
    private ImageView moneyJR;
    private ImageView dingJR;

    public OwnFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_own, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        own_head = (ImageView) view.findViewById(R.id.own_head);
        own_head.setOnClickListener(this);
        own_Payment = (LinearLayout) view.findViewById(R.id.own_Payment);
        own_Payment.setOnClickListener(this);
        own_Cons = (LinearLayout) view.findViewById(R.id.own_Cons);
        own_Cons.setOnClickListener(this);
        own_Goods = (LinearLayout) view.findViewById(R.id.own_Goods);
        own_Goods.setOnClickListener(this);
        own_Evaluate = (LinearLayout) view.findViewById(R.id.own_Evaluate);
        own_Evaluate.setOnClickListener(this);
        own_After = (LinearLayout) view.findViewById(R.id.own_After);
        own_After.setOnClickListener(this);
        own_integral = (LinearLayout) view.findViewById(R.id.own_integral);
        own_integral.setOnClickListener(this);
        own_balance = (LinearLayout) view.findViewById(R.id.own_balance);
        own_balance.setOnClickListener(this);
        own_core = (LinearLayout) view.findViewById(R.id.own_core);
        own_core.setOnClickListener(this);
        own_detailed = (LinearLayout) view.findViewById(R.id.own_detailed);
        own_detailed.setOnClickListener(this);
        own_binding = (LinearLayout) view.findViewById(R.id.own_binding);
        own_binding.setOnClickListener(this);
        moneyJR = view.findViewById(R.id.own_jinru_money);
        moneyJR.setOnClickListener(this);
        dingJR = view.findViewById(R.id.own_jingru_dingdan);
        dingJR.setOnClickListener(this);

        RelativeLayout gouW=view.findViewById(R.id.gouwuche);
        gouW.setOnClickListener(this);
        TextView gouWTv=gouW.findViewById(R.id.own_dynamic);
        ImageView gouWImg=gouW.findViewById(R.id.img);
        gouWTv.setText("购物车");

        RelativeLayout xiaoX=view.findViewById(R.id.xiaoxi);
        xiaoX.setOnClickListener(this);
        TextView xiaoXTv=xiaoX.findViewById(R.id.own_dynamic);
        ImageView xiaoXImg=xiaoX.findViewById(R.id.img);
        xiaoXTv.setText("消息中心");

        RelativeLayout zuJ=view.findViewById(R.id.zuji);
        zuJ.setOnClickListener(this);
        TextView zuJTv=zuJ.findViewById(R.id.own_dynamic);
        ImageView zuJImg=zuJ.findViewById(R.id.img);
        zuJTv.setText("我的足迹");

        RelativeLayout keF=view.findViewById(R.id.kefu);
        keF.setOnClickListener(this);
        TextView keFTv=keF.findViewById(R.id.own_dynamic);
        ImageView keFImg=keF.findViewById(R.id.img);
        keFTv.setText("在线客服");

        RelativeLayout haoY=view.findViewById(R.id.yaoqing);
        haoY.setOnClickListener(this);
        TextView haoYTv=haoY.findViewById(R.id.own_dynamic);
        ImageView haoYImg=haoY.findViewById(R.id.img);
        haoYTv.setText("邀请好友");

        RelativeLayout ruZ=view.findViewById(R.id.shenqing);
        ruZ.setOnClickListener(this);
        TextView ruZTv=ruZ.findViewById(R.id.own_dynamic);
        ImageView ruZImg=ruZ.findViewById(R.id.img);
        ruZTv.setText("申请入驻/我的店铺");

        RelativeLayout shouC=view.findViewById(R.id.shoucang);
        shouC.setOnClickListener(this);
        TextView shouCTv=shouC.findViewById(R.id.own_dynamic);
        ImageView shouCImg=shouC.findViewById(R.id.img);
        shouCTv.setText("我的收藏");

        RelativeLayout sheZ=view.findViewById(R.id.shezhi);
        sheZ.setOnClickListener(this);
        TextView sheZTv=sheZ.findViewById(R.id.own_dynamic);
        ImageView sheZImg=sheZ.findViewById(R.id.img);
        sheZTv.setText("设置");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //我的页面头部跳转
            case R.id.own_head:
                startActivity(new Intent(getContext(), Modify_userActivity.class));
                break;
            //我的页面代付款跳转
            case R.id.own_Payment:
                break;
            //我的页面待发货跳转
            case R.id.own_Cons:
                break;
            //我的页面待收货跳转
            case R.id.own_Goods:
                break;
            //我的页面评价跳转
            case R.id.own_Evaluate:
                break;
            //我的页面售后跳转
            case R.id.own_After:
                break;
            //我的页面点击我的订单进入全部订单跳转
            case R.id.own_jingru_dingdan:
                break;
            //我的页面我的积分跳转
            case R.id.own_integral:
                startActivity(new Intent(getContext(), MyWalletActivity.class).putExtra("id",0));
                break;
            //我的页面我的余额跳转
            case R.id.own_balance:
                startActivity(new Intent(getContext(), MyWalletActivity.class).putExtra("id",1));

                break;
            //我的页面会员中心跳转
            case R.id.own_core:
                startActivity(new Intent(getContext(), MyWalletActivity.class).putExtra("id",2));

                break;
            //我的页面钱包明细跳转
            case R.id.own_detailed:
                startActivity(new Intent(getContext(), MyWalletActivity.class).putExtra("id",3));

                break;
            //我的页面支付绑定跳转
            case R.id.own_binding:
                startActivity(new Intent(getContext(), MyWalletActivity.class).putExtra("id",4));

                break;
            //我的页面我的钱包进入钱包跳转
            case R.id.own_jinru_money:
                startActivity(new Intent(getContext(), MyWalletActivity.class));
                break;
            //我的页面购物车跳转
            case R.id.gouwuche:
                break;
            //我的页面消息中心跳转
            case R.id.xiaoxi:
                startActivity(new Intent(getContext(), MessageActivity.class));
                break;
            //我的页面我的足迹跳转
            case R.id.zuji:
                startActivity(new Intent(getContext(), FootprintActivity.class));

                break;
            //我的页面在线客服跳转
            case R.id.kefu:
                startActivity(new Intent(getContext(), ServiceActivity.class));
                break;
            //我的页面邀请好友跳转
            case R.id.yaoqing:
                startActivity(new Intent(getContext(),InvitationActivity.class));
                break;
            //我的页面申请入驻/我的店铺跳转
            case R.id.shenqing:
                startActivity(new Intent(getActivity(),FillInformationActivity.class));
                break;
            //我的页面我的收藏跳转
            case R.id.shoucang:
                startActivity(new Intent(getContext(), MyLoveActivity.class));
                break;
            //我的页面设置跳转
            case R.id.shezhi:
                startActivity(new Intent(getContext(),SettingsActivity.class));
                break;
        }
    }
}