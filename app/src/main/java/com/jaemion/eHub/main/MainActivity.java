package com.jaemion.eHub.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.MainActivityBinding;
import com.jaemion.eHub.main.ui.MainFragment_List;
import com.jaemion.eHub.main.ui.MainFragment_Main;
import com.jaemion.eHub.userinfo.UserInfoActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener, View.OnClickListener {
    MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(binding.mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.mainDrawerLayout, binding.mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.mainDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.mainNavigation.setOnNavigationItemReselectedListener(this);
        binding.mainNavigation.setOnNavigationItemSelectedListener(this);
        binding.mainNavigation.setSelectedItemId(R.id.main_navigation_home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, MainFragment_Main.newInstance())
                .commitNow();
        binding.mainNavigation.getMenu().findItem(R.id.main_navigation_home).setTitle("발주하기");
        binding.mainNavigation.getMenu().findItem(R.id.main_navigation_dashboard).setTitle("발주 리스트");
        binding.mainActivityNav.mainActivityNavIvMyPage.setOnClickListener(this);
        binding.mainActivityNav.mainActivityNavIvNotice.setOnClickListener(this);
        binding.mainActivityNav.mainActivityNavIvSetting.setOnClickListener(this);
        binding.mainActivityNav.mainActivityNavIvInfo.setOnClickListener(this);
        binding.mainActivityNav.mainActivityNavTvLogOut.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.mainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public BottomNavigationView getNavigationVIew() {
        return binding.mainNavigation;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.main_navigation_home:
                binding.mainToolbarTitle.setText("발주하기");
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.main_container, MainFragment_Main.newInstance())
                        .commitNow();
                return true;
            case R.id.main_navigation_dashboard:
                binding.mainToolbarTitle.setText("발주목록확인");
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out)
                        .replace(R.id.main_container, MainFragment_List.newInstance())
                        .commitNow();
                return true;
        }

        binding.mainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_nav_ivMyPage:
                Intent intent = new Intent(this, UserInfoActivity.class);
                startActivity(intent);
                break;

            case R.id.main_activity_nav_ivNotice:
                break;

            case R.id.main_activity_nav_ivSetting:
                break;

            case R.id.main_activity_nav_ivInfo:
                break;

            case R.id.main_activity_nav_tvLogOut:
                break;
        }
    }

    public TextView getToolbarTitle() {
        return binding.mainToolbarTitle;
    }
}
