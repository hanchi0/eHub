package com.jaemion.eHub.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.jaemion.eHub.R;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.signup.SignUpActivity;

public class SplashActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        Handler handler = new Handler();
        handler.postDelayed(new splashHandler(), 1500);
    }

    private class splashHandler implements Runnable {
        @Override
        public void run() {
            //if (sharedPreferences.getBoolean("isFirst", true))
                startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
            //else
               // startActivity(new Intent(SplashActivity.this, SignInActivity.class));

           // sharedPreferences.edit().putBoolean("isFirst",false).commit();
            finish();
        }
    }
}
