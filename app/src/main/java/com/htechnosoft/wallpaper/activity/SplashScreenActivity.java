package com.htechnosoft.wallpaper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.htechnosoft.wallpaper.Constants.AppConstants;
import com.htechnosoft.wallpaper.R;


public class SplashScreenActivity extends AppCompatActivity {

    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    redirectToMainScreen();
                    // Finish this activity
                    finish();
                }
            }
        }, AppConstants.SPLASH_TIME_OUT);
    }

    private void redirectToMainScreen()
    {
        mIntent = new Intent(SplashScreenActivity.this, HomeScreen.class);
        startActivity(mIntent);
    }
}
