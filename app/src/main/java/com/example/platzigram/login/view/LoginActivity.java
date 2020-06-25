package com.example.platzigram.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.platzigram.R;
import com.example.platzigram.login.presenter.LoginPresenterImplementation;
import com.example.platzigram.login.presenter.LoginPresenterInterface;
import com.google.android.material.textfield.TextInputEditText;

import view.ContainerActivity;
import view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface{

    private TextInputEditText username,password;
    private Button login;
    private ProgressBar progressBarLogin;
    private LoginPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login   =findViewById(R.id.login);
        progressBarLogin=findViewById(R.id.progressbarLogin);
        hideProgressBar();

        presenter=new LoginPresenterImplementation(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(username.equals(""))
                presenter.signIn(username.getText().toString(),password.getText().toString());
            }
        });

    }


    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error)+" "+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccount(View view) {

        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    @Override
    public void goHome() {

        Intent intent=new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }

}
