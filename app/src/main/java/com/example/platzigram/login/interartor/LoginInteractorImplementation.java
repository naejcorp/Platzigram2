package com.example.platzigram.login.interartor;

import com.example.platzigram.login.presenter.LoginPresenterInterface;
import com.example.platzigram.login.repository.LoginRepositoryImplementation;
import com.example.platzigram.login.repository.LoginRepositoryInterface;

public class LoginInteractorImplementation implements LoginInteractorInterface{

    private LoginPresenterInterface presenter;
    private LoginRepositoryInterface repository;

    public LoginInteractorImplementation(LoginPresenterInterface presenter) {
        this.presenter = presenter;
        repository=new LoginRepositoryImplementation(presenter);
    }

    @Override
    public void signIn(String username, String password) {
       repository.signIn(username, password);
    }
}
