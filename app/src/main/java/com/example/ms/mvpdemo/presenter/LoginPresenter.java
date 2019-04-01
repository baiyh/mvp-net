package com.example.ms.mvpdemo.presenter;

import com.example.ms.mvpdemo.base.BasePresenter;
import com.example.ms.mvpdemo.base.HttpResponseListener;
import com.example.ms.mvpdemo.bean.MessageBean;
import com.example.ms.mvpdemo.bean.UserBean;
import com.example.ms.mvpdemo.contracts.LoginContracts;
import com.example.ms.mvpdemo.disposable.SubscriptionManager;
import com.example.ms.mvpdemo.error.ExceptionHandle;
import com.example.ms.mvpdemo.model.LoginModel;
import com.example.ms.mvpdemo.retrofit.HttpObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by ms on 2019/4/1.
 */

public class LoginPresenter extends BasePresenter<LoginContracts.LoginUi, UserBean> implements LoginContracts.loginPresenter {

    private LoginContracts.loginModel mLoginMdl;

    public LoginPresenter(LoginContracts.LoginUi view) {
        super(view);
        mLoginMdl = new LoginModel();
    }

    @Override
    public void login(String username, String password) {
        mLoginMdl.login(username, password, new HttpResponseListener<UserBean>() {
            @Override
            public void onSuccess(Object tag, UserBean o) {
                if (isViewAttach()) {
                    getView().loginSuccess();
                }
            }

            @Override
            public void onFailure(Object tag, ExceptionHandle.ResponeThrowable failure) {
                // 先判断是否已经与 View 建立联系
                if (isViewAttach()) {
                    getView().loginFailure();
                }
            }
        });


    }

    @Override
    public void getMsg(String phone) {
        mLoginMdl.getMsg("15411323", new HttpObserver<MessageBean>() {
            @Override
            public void onSuccess(MessageBean o) {

            }

            @Override
            public void onFail(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onDisposable(Disposable d) {
                //添加订阅
                SubscriptionManager.getInstance().add(d);
            }
        });
    }

}
