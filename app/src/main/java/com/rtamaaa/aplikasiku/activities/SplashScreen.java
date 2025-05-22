package com.rtamaaa.aplikasiku.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.rtamaaa.aplikasiku.R;
import com.rtamaaa.aplikasiku.activities.login.Login;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, Login.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}
