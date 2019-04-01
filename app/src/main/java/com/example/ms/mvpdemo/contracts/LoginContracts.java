package com.example.ms.mvpdemo.contracts;

import com.example.ms.mvpdemo.base.HttpResponseListener;
import com.example.ms.mvpdemo.base.IBasePresenter;
import com.example.ms.mvpdemo.base.IBaseView;
import com.example.ms.mvpdemo.retrofit.HttpObserver;

/**
 * Created by ms on 2019/4/1.
 * 登录页面的契约类
 */

public class LoginContracts {
    /**
     * view接口层
     */
    public interface LoginUi extends IBaseView {

        void loginSuccess();

        void loginFailure();
    }

    /**
     * presenter接口层
     */
    public interface loginPresenter extends IBasePresenter {
        void login(String username, String password);

        void getMsg(String phone);
    }

    /**
     * model接口层
     */
    public interface loginModel {
        void login(String username, String password, HttpResponseListener httpResponseListener);

        void getMsg(String phone, HttpObserver observer);
    }
}
