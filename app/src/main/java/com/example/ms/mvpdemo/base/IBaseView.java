package com.example.ms.mvpdemo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by ms on 2019/4/1.
 * 根据项目需求添加
 */

public interface IBaseView extends IBaseXView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener, int imageId);

    void showEmpty(View view, View.OnClickListener onClickListener);

    void showNetError(View.OnClickListener onClickListener);

    /**
     * 数据加载失败
     * 数据上传失败
     * 数据异常失败
     *
     * @param msg
     * @param loadType 在view中可以使用type类型进行区别
     */
    void showLoadingError(String msg, int loadType);

    /**
     * 上传数据成功时，需要调用的方法
     *
     * @param msg
     * @param loadType 在
     */
    void showLoadingSuccess(String msg, int loadType);

}
