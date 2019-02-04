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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.ui.MainFragment_List;
import com.jaemion.eHub.main.ui.MainFragment_Main;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener, NavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigation;
    TextView toolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle = findViewById(R.id.main_toolbar_title);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
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

        int id = menuItem.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    public TextView getToolbarTitle(){
        return toolbarTitle;
    }
}
