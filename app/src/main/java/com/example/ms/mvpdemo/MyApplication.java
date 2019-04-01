package com.example.ms.mvpdemo;

import android.app.Application;

import com.example.ms.mvpdemo.retrofit.NetworkManager;

/**
 * Created by ms on 2019/4/1.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化网络请求
        NetworkManager.getInstance().init();
    }
}
