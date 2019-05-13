package com.example.mvp_sample.login;

public interface ILoginPresenter {
    void onSuccess();

    void onFailure();

    void callService(String UserName, String Password);
}
