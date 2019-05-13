package com.example.mvp_sample.login;

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView;
    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }
    @Override
    public void onSuccess() {
        iLoginView.hideProgress();
    }

    @Override
    public void onFailure() {
        iLoginView.hideProgress();

    }

    @Override
    public void callService(String UserName, String Password) {
        iLoginView.showProgress("");
        if (UserName.toLowerCase().equals("admin") && Password.toLowerCase().equals("admin")) {
            iLoginView.showToast("Success", "Login SuccessFully");
        } else {
            iLoginView.showToast("Failure", "Invalid Credential");
        }
    }
}
