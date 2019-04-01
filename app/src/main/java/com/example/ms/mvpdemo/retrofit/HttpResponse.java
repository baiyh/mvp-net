package com.example.ms.mvpdemo.retrofit;

import com.example.ms.mvpdemo.bean.CommonResponse;
import com.example.ms.mvpdemo.error.ExceptionHandle;

import io.reactivex.functions.Function;

/**
 * Created by ms on 2019/4/1.
 * 数据的分离操作，取出对我们有用的数据
 */

public class HttpResponse<T> implements Function<CommonResponse<T>, T> {
    @Override
    public T apply(CommonResponse<T> tCommonResponse) throws Exception {
        if (tCommonResponse.getCode() != 200) {
            throw new ExceptionHandle.ServerException(tCommonResponse.getCode(), tCommonResponse.getMsg());
        }
        return tCommonResponse.getData();
    }
}
