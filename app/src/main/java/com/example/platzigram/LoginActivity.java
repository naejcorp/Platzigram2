package com.example.platzigram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import view.ContainerActivity;
import view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view){

        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void goLogin(View view){

        Intent intent=new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }

}
