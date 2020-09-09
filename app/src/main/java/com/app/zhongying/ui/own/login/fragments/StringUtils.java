package com.app.zhongying.ui.own.login.fragments;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * 判断是否包含特殊字符
     * @return  false:未包含 true：包含
     */
    public static boolean inputJudge(String editText) {
        String speChat = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(speChat);
        Log.d("inputJudge", "pattern: "+ pattern);
        Matcher matcher = pattern.matcher(editText);
        Log.d("inputJudge", "matcher: "+ matcher);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean inputPhone(String editText) {
        String speChat = "[1][1-9][0-9]{8}";
        Pattern pattern = Pattern.compile(speChat);
        Log.d("inputJudge", "pattern: "+ pattern);
        Matcher matcher = pattern.matcher(editText);
        Log.d("inputJudge", "matcher: "+ matcher);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean inputEnglish(String editText) {
        String speChat = ".*?[a-zA-Z]+.*?";
        Pattern pattern = Pattern.compile(speChat);
        Log.d("inputJudge", "pattern: "+ pattern);
        Matcher matcher = pattern.matcher(editText);
        Log.d("inputJudge", "matcher: "+ matcher);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean inputNum(String editText) {
        String speChat = ".*?[\\d]+.*?";
        Pattern pattern = Pattern.compile(speChat);
        Log.d("inputJudge", "pattern: "+ pattern);
        Matcher matcher = pattern.matcher(editText);
        Log.d("inputJudge", "matcher: "+ matcher);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
}
