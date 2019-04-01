package com.example.ms.mvpdemo.service;

import com.example.ms.mvpdemo.bean.CommonResponse;
import com.example.ms.mvpdemo.bean.MessageBean;
import com.example.ms.mvpdemo.bean.UserBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ms on 2019/4/1.
 */

public interface ApiService {
    public final String HOST_URL = "" ;

    @GET("{fenzhi}{bianhao}/orderinfo")
    Observable<List<UserBean>> getUsers(@Path("fenzhi") String fenzhi,
                                        @Path("bianhao") String bianhao,
                                        @Query("batchNo") String batchNo);
    @GET("login")
    Observable<CommonResponse<UserBean>> login(@FieldMap HashMap<String, String> map);

    @GET("getMsg")
    Observable<MessageBean> getMsg(@Query("phone") String phone);
}
