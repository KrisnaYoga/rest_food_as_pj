package com.klmpk2b.rstrnt_pj.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klmpk2b.rstrnt_pj.MainActivity;
import com.klmpk2b.rstrnt_pj.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new android.os.Handler().postDelayed(
            new Runnable() {
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
    }
}
