package com.example.mvp_sample.login;

public interface ILoginView {

    void showProgress(String Message);

    void hideProgress();

    void showToast(String status, String message);
}
