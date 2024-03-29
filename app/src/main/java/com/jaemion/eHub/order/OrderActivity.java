package com.jaemion.eHub.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.OrderActivityBinding;
import com.jaemion.eHub.order.ui.OrderFragment_Estimate;

public class OrderActivity extends AppCompatActivity {
    OrderActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.order_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.order_container, OrderFragment_Estimate.newInstance())
                    .commitNow();
        }

        setSupportActionBar(binding.orderToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_black);
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

    public void setToolbar(String title) {
        setSupportActionBar(binding.orderToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.orderToolbarTitle.setText(title);
    }
}
