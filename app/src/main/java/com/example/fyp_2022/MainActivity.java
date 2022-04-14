package com.example.fyp_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

//Splash Activity

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
//    TextView progressText;
//    BroadcastReceiver broadcastReceiver;
//    Intent loginActivityIntent;
//   // public static SplashActivity splashActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        progressText = findViewById(R.id.progressText);
//        splashActivity = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}

