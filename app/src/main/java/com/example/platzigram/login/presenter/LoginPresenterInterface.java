package com.example.platzigram.login.presenter;

public interface LoginPresenterInterface {

    void signIn(String username, String password);//Interactor
    void loginSuccess();
    void loginError(String error);

}
