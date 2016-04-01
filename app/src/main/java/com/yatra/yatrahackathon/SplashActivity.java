package com.yatra.yatrahackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by XVTS8308 on 01/04/2016.
 */
public class SplashActivity extends Activity {

    private String TAG = SplashActivity.class.getSimpleName();
    private static int SPLASH_TIME_OUT_PERIOD = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, SPLASH_TIME_OUT_PERIOD);
    }
}
