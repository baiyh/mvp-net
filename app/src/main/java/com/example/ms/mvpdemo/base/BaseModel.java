package com.example.ms.mvpdemo.base;

import com.example.ms.mvpdemo.bean.CommonResponse;
import com.example.ms.mvpdemo.bean.UserBean;
import com.example.ms.mvpdemo.error.ExceptionHandle;
import com.example.ms.mvpdemo.retrofit.HttpObserver;
import com.example.ms.mvpdemo.retrofit.HttpResponse;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ms on 2019/4/1.
 */

public class BaseModel {
    /**
     * 发送网络请求
     *
     * @param observable
     * @param callback
     * @param <T>
     */
    protected <T> void sendRequest(@NonNull Observable<CommonResponse<T>> observable, final HttpResponseListener<T> callback) {
        observable
                .subscribeOn(Schedulers.io())
                .map(new HttpResponse<T>()) //map将抽出我们又用的数据
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        callback.onSuccess("", t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure("", ExceptionHandle.handleException(throwable));
                    }
                });
    }

    /**
     * 发送网络请求
     *
     * @param tag        标记
     * @param observable 被观察者
     * @param callback   回调
     * @param <T>
     */
    protected <T> void sendRequest(@NonNull final Object tag, @NonNull Observable<T> observable, final HttpResponseListener callback) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        callback.onSuccess(tag, t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(tag, ExceptionHandle.handleException(throwable));
                    }
                });
    }

    /**
     * 发送网络请求
     *
     * @param observable 被观察者
     * @param observer   观察者
     * @param <T>
     */
    protected <T> void sendRequest(@NonNull Observable<T> observable, @NonNull HttpObserver<T> observer) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    /**
     * 发送网络请求
     *
     * @param tag        请求标记
     * @param observable 被观察者
     * @param observer   观察者
     * @param <T>
     */
    protected <T> void sendRequest(@NonNull Object tag, @NonNull Observable<T> observable, @NonNull HttpObserver<T> observer) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
