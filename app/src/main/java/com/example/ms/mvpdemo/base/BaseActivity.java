package com.example.ms.mvpdemo.base;

import android.view.View;

/**
 * Created by ms on 2019/4/1.
 */

public abstract class BaseActivity <P extends IBasePresenter> extends BaseXActivity<P> implements IBaseView {
    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {

    }

    @Override
    public void showEmpty(View view, View.OnClickListener onClickListener) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }

    @Override
    public void showLoadingError(String msg, int loadType) {

    }

    @Override
    public void showLoadingSuccess(String msg, int loadType) {

    }
}
