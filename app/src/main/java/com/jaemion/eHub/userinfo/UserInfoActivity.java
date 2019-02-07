package com.jaemion.eHub.userinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jaemion.eHub.R;
import com.jaemion.eHub.userinfo.ui.UserInfoFragment_Main;


public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, UserInfoFragment_Main.newInstance())
                    .commitNow();
        }
    }
}
