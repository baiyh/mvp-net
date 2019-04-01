package com.example.ms.mvpdemo.disposable;

import io.reactivex.disposables.Disposable;

/**
 * Created by ms on 2019/4/1.
 */

public interface SubscriptionHelper<T> {
    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelall();
}
