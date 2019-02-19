package com.jaemion.eHub.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.UserInfoActivityBinding;
import com.jaemion.eHub.userinfo.ui.UserInfoFragment_Main;


public class UserInfoActivity extends AppCompatActivity {
    UserInfoActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.user_info_activity);
        setSupportActionBar(binding.userInfoActivityToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
        setToolbar("내 정보");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.user_info_activity_container, UserInfoFragment_Main.newInstance())
                    .commitNow();
        }
    }

    public void setToolbar(String title) {
        binding.userInfoActivityToolbarTitle.setText(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() <= 0)
                    finish();
                else {
                    getSupportFragmentManager().popBackStack();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
