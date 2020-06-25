package com.example.platzigram.login.view;

import android.view.View;

public interface LoginViewInterface {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount(View view);
    void goHome();
}
