package com.example.ms.mvpdemo.base;

import com.example.ms.mvpdemo.error.ExceptionHandle;

/**
 * Created by ms on 2019/4/1.
 * 网络请求响应接口
 */

public interface HttpResponseListener<T> {
    /**
     * 网络请求成功
     *
     * @param tag 请求的标记
     * @param t   返回的数据
     */
    void onSuccess(Object tag,T t);
    /**
     * 网络请求失败
     *
     * @param tag     请求的标记
     * @param failure 请求失败时，返回的信息类
     */
    void onFailure(Object tag,ExceptionHandle.ResponeThrowable failure);
}
