package com.example.ms.mvpdemo.base;

import com.example.ms.mvpdemo.error.ExceptionHandle;

/**
 * Created by ms on 2019/4/1.
 */

public abstract class BasePresenter<V extends IBaseView, T> extends BaseXPresenter<V> implements IBasePresenter, HttpResponseListener<T>{
    public BasePresenter(V view) {
        super(view);
    }

    @Override
    public void cancel() {

    }

    @Override
    public void cancelAll() {

    }

    @Override
    public void onSuccess(Object tag, T t) {

    }

    @Override
    public void onFailure(Object tag, ExceptionHandle.ResponeThrowable failure) {

    }
}
