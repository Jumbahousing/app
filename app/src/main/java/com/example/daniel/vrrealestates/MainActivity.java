package com.example.daniel.vrrealestates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button loginButton =  (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        final Button facebookSignin = (Button) findViewById(R.id.signinwithfacebook);
        facebookSignin.setOnClickListener(this);
        final TextView createAccount = (TextView) findViewById(R.id.createafreeaccount);
        createAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intent = new Intent(this,SignIn.class);
                startActivity(intent);
                break;
            case R.id.signinwithfacebook:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(browserIntent);
                break;
            case R.id.createafreeaccount:
                Intent createIntent = new Intent (this, CreateAccount.class);
                startActivity(createIntent);
                break;
        }
    }
}