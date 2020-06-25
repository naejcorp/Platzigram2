package com.example.platzigram.login.presenter;

import android.view.View;

import com.example.platzigram.login.interartor.LoginInteractorImplementation;
import com.example.platzigram.login.interartor.LoginInteractorInterface;
import com.example.platzigram.login.view.LoginViewInterface;

public class LoginPresenterImplementation implements LoginPresenterInterface {

    private LoginViewInterface loginView;
    private LoginInteractorInterface interactor;

    public LoginPresenterImplementation(LoginViewInterface loginView) {
        this.loginView = loginView;
        interactor =new LoginInteractorImplementation(this);
    }

    @Override
    public void signIn(String username, String password) {
        loginView.disableInputs();
        loginView.showProgressBar();

        interactor.signIn(username,password);
    }

    @Override
    public void loginSuccess() {
        loginView.goHome();

        loginView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);
    }
}
