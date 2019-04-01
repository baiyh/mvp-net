package com.example.ms.mvpdemo.base;

import android.support.v7.app.AppCompatActivity;

import com.example.ms.mvpdemo.disposable.SubscriptionManager;

/**
 * Created by ms on 2019/4/1.
 * view层的基类activity
 */

public abstract class BaseXActivity<P extends IBaseXPresenter> extends AppCompatActivity implements IBaseXView {
    private P mPresenter;

    //创建presenter对象
    public abstract P onBindPresenter();

    //获取presenter对象
    public P getPresenter() {
        if (mPresenter == null) {
            mPresenter = onBindPresenter();
        }
        return mPresenter;
    }

    @Override
    public AppCompatActivity getSelfActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束时，将 presenter 与 view 之间的联系断开，防止出现内存泄露
         */
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        //View消除时取消订阅关系
        SubscriptionManager.getInstance().cancelall();
    }
}
