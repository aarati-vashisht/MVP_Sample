package com.example.mvp_sample.login;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp_sample.R;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    EditText editTextUserName, editTextPassword;
    Button buttonLogin;
    private ProgressBar progressBar;
    LoginPresenterImpl loginPresenter;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUI();
        loginPresenter = new LoginPresenterImpl(this);


    }

    private void getUI() {
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);
        constraintLayout = findViewById(R.id.constraintLayout);
    }

    @Override
    public void showProgress(String Message) {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showToast(String status, String message) {
        progressBar.setVisibility(View.GONE);
        Snackbar snackbar = Snackbar
                .make(constraintLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void onLoginClick(View view) {
        loginPresenter.callService(editTextUserName.getText().toString().trim(), editTextPassword.getText().toString().trim());
    }
}
