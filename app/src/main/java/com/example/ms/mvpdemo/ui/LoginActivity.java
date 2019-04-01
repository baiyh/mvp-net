package com.example.ms.mvpdemo.ui;

import android.os.Bundle;

import com.example.ms.mvpdemo.R;
import com.example.ms.mvpdemo.base.BaseActivity;
import com.example.ms.mvpdemo.contracts.LoginContracts;
import com.example.ms.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginContracts.loginPresenter> implements LoginContracts.LoginUi {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getPresenter().login("","");
        getPresenter().getMsg("");
    }


    @Override
    public LoginContracts.loginPresenter onBindPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure() {

    }
}
