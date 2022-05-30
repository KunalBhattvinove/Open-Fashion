package com.example.mushop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mushop.R;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME_OUT = 3000;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                /*  getUpdate();*/
                launchHomeScreen();
            }
        }, SPLASH_TIME_OUT);

    }
    private void launchHomeScreen() {

        startActivity(new Intent(Splash_Activity.this, MainActivity.class));
        finish();
    }
}