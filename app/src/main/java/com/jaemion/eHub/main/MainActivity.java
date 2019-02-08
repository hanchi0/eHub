package com.jaemion.eHub.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.ui.MainFragment_List;
import com.jaemion.eHub.main.ui.MainFragment_Main;
import com.jaemion.eHub.signin.SignInActivity;
import com.jaemion.eHub.userinfo.UserInfoActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener, View.OnClickListener {
    BottomNavigationView bottomNavigation;
    TextView toolbarTitle;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle = findViewById(R.id.main_toolbar_title);
        drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.main_navigation_home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, MainFragment_Main.newInstance())
                .commitNow();
        bottomNavigationView.getMenu().findItem(R.id.main_navigation_home).setTitle("발주하기");
        bottomNavigationView.getMenu().findItem(R.id.main_navigation_dashboard).setTitle("발주 리스트");
        bottomNavigation = bottomNavigationView;
        findViewById(R.id.main_activity_nav_layout).setOnClickListener(this);
        findViewById(R.id.main_activity_nav_ivMyPage).setOnClickListener(this);
        findViewById(R.id.main_activity_nav_ivNotice).setOnClickListener(this);
        findViewById(R.id.main_activity_nav_ivSetting).setOnClickListener(this);
        findViewById(R.id.main_activity_nav_ivInfo).setOnClickListener(this);
        findViewById(R.id.main_activity_nav_tvLogOut).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public BottomNavigationView getNavigationVIew() {
        return bottomNavigation;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.main_navigation_home:
                toolbarTitle.setText("발주하기");
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.main_container, MainFragment_Main.newInstance())
                        .commitNow();
                return true;
            case R.id.main_navigation_dashboard:
                toolbarTitle.setText("발주목록확인");
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out)
                        .replace(R.id.main_container, MainFragment_List.newInstance())
                        .commitNow();
                return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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
        return toolbarTitle;
    }
}
