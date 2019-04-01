package com.example.ms.mvpdemo.retrofit;

import com.example.ms.mvpdemo.service.ApiService;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ms on 2019/4/1.
 */

public class NetworkManager {
    private static NetworkManager mInstance;
    private static Retrofit retrofit;
    private static volatile ApiService request = null;

    public static NetworkManager getInstance() {
        //防止并发访问，创建多个对象
        if (mInstance == null) {
            synchronized (NetworkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetworkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化方法
     */
    public void init() {
        //日志输出
        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new CommonInterceptor()) //添加公共的请求参数
                .addInterceptor(log) //日志打印
                .build();
        //初始化retrofit
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("host URL")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static ApiService getRequest() {
        if (request == null) {
            synchronized (Request.class) {
                request = retrofit.create(ApiService.class);
            }
        }
        return request;
    }

    public class CommonInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request oldRequest = chain.request();

            // 添加新的参数
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host())
                    .addQueryParameter("device_type", "1")
                    .addQueryParameter("version","")
                    .addQueryParameter("token", "")
                    .addQueryParameter("userid", "");

            // 新的请求
            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build())
                    .build();

            return chain.proceed(newRequest);
        }
    }

}
