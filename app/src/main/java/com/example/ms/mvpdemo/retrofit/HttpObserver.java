package com.example.ms.mvpdemo.retrofit;

import com.example.ms.mvpdemo.error.ExceptionHandle;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ms on 2019/4/1.
 */

public  abstract class HttpObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        onDisposable(d);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        //自定义异常的传递
        onFail(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {
        onCompleted();
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(ExceptionHandle.ResponeThrowable e);

    public abstract void onCompleted();

    public abstract void onDisposable(Disposable d);
}
