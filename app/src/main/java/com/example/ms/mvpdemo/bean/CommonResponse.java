package com.example.ms.mvpdemo.bean;

/**
 * Created by ms on 2019/4/1.
 * 具体的数据请求响应结果，根据时间情况定
 * 以下模拟假的数据返回格式
 */

public class CommonResponse<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
