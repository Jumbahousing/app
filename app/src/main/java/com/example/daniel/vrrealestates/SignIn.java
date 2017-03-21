package com.example.daniel.vrrealestates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button signIn = (Button) findViewById(R.id.signin);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin :
                Intent signIntent = new Intent(this, StartSearchActivity.class);
                startActivity(signIntent);

                break;
        }
    }
}
