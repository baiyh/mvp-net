package com.example.ms.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * Created by ms on 2019/4/1.
 * presenter的基类实现
 */

public class BaseXPresenter<V extends IBaseXView> implements IBaseXPresenter {
    //防止activity不走destroy方法，采用弱引用防止内存泄露
    private WeakReference<V> mWeakf;

    public BaseXPresenter(V view) {
        attachView(view);
    }

    private void attachView(V view) {
        mWeakf = new WeakReference<V>(view);
    }

    public V getView() {
        return mWeakf.get();
    }

    @Override
    public boolean isViewAttach() {
        return mWeakf != null && mWeakf.get() != null;
    }

    @Override
    public void detachView() {
        if (mWeakf != null) {
            mWeakf.clear();
            mWeakf = null;
        }
    }
}
