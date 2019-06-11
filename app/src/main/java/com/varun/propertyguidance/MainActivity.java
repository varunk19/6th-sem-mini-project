package com.varun.propertyguidance;

import android.content.Intent;
import android.os.Handler;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWaitHandler.postDelayed(new Runnable() {

            @Override
            public void run() {

                //The following code will execute after the 5 seconds
                //Go to next page i.e, start the next activity.
                Intent intent = new Intent(getApplicationContext(), home.class);
                startActivity(intent);

                //Let's Finish Splash Activity since we don't want to show this when user press back button.
                finish();
            }
        }, 1000);  // Give a 1 second delay.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}