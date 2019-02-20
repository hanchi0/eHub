package com.jaemion.eHub.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.UserInfoActivityBinding;
import com.jaemion.eHub.userinfo.ui.UserInfoFragment_Main;
import com.jaemion.eHub.userinfo.ui.UserInfoFragment_Modify;


public class UserInfoActivity extends AppCompatActivity {
    UserInfoActivityBinding binding;
    MenuItem item;

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
                    .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                    .replace(R.id.user_info_activity_container, UserInfoFragment_Main.newInstance())
                    .commitNow();
        }
    }

    public void setToolbar(String title) {
        binding.userInfoActivityToolbarTitle.setText(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        item = menu.findItem(R.id.toolbar_menu_modify);
        return true;
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
            case R.id.toolbar_menu_modify:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .addToBackStack(null)
                        .replace(R.id.user_info_activity_container, new UserInfoFragment_Modify())
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setItemVisible(boolean val) {
        item.setVisible(val);
    }
}
