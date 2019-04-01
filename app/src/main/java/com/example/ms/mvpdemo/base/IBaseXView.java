package com.example.ms.mvpdemo.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by ms on 2019/4/1.
 */

public interface IBaseXView {

    <T extends AppCompatActivity> T getSelfActivity();
}
