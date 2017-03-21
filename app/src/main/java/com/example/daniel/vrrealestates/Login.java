package com.example.daniel.vrrealestates;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button continueSignIn = (Button) findViewById(R.id.continue_signin);
        continueSignIn.setOnClickListener(this);
        final Button switchUsers = (Button) findViewById(R.id.switch_users);
        switchUsers.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continue_signin :
                Intent searchIntent = new Intent(this, StartSearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.switch_users :
                //Intent searchIntent = new Intent(this, StartSearchActivity.class);
                break;
        }
    }
}

