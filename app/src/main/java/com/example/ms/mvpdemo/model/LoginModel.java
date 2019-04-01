package com.example.ms.mvpdemo.model;

import com.example.ms.mvpdemo.base.BaseModel;
import com.example.ms.mvpdemo.base.HttpResponseListener;
import com.example.ms.mvpdemo.contracts.LoginContracts;
import com.example.ms.mvpdemo.retrofit.HttpObserver;
import com.example.ms.mvpdemo.retrofit.NetworkManager;

import java.util.HashMap;

/**
 * Created by ms on 2019/4/1.
 * 登录
 */

public class LoginModel extends BaseModel implements LoginContracts.loginModel {

    //登录请求
    @Override
    public void login(String username, String password, HttpResponseListener httpResponseListener) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        //RequestBody body = ReqBodyHelper.createJson(map);
        // 发送网络请求
        sendRequest(NetworkManager.getRequest().login(map),httpResponseListener);
    }

    @Override
    public void getMsg(String phone, HttpObserver observer) {
        sendRequest(NetworkManager.getRequest().getMsg(phone),observer);
    }
}
