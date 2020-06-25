package com.example.platzigram.login.repository;

import com.example.platzigram.login.presenter.LoginPresenterInterface;

public class LoginRepositoryImplementation implements LoginRepositoryInterface{

    LoginPresenterInterface presenter;

    public LoginRepositoryImplementation(LoginPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signIn(String username, String password) {
        boolean success=true;
        if(success){
            presenter.loginSuccess();
        }else {
            presenter.loginError("Ocurrió un error");
        }
    }
}
