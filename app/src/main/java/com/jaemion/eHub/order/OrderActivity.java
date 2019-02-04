package com.jaemion.eHub.order;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.DatePicker;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.order.ui.OrderFragment_Estimate;

import java.text.DateFormat;
import java.util.Calendar;

public class OrderActivity extends AppCompatActivity{
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.order_container, OrderFragment_Estimate.newInstance())
                    .commitNow();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.order_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);

        toolbarTitle = findViewById(R.id.order_toolbar_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() <= 0)
                    finish();
                else if (getSupportFragmentManager().getFragments().toString().contains("Statement")) {
                    finish();
                } else {
                    getSupportFragmentManager().popBackStack();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getFragments().toString().contains("Statement"))
            finish();
        else
            super.onBackPressed();
    }

    public TextView getToolbarTitle() {
        return toolbarTitle;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
