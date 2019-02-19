package com.jaemion.eHub.orderdetail;

import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.OrderDetailActivityBinding;

public class OrderDetailActivity extends AppCompatActivity {

    OrderDetailActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.order_detail_activity);
        setSupportActionBar(binding.orderDetailToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
        /*tvType = findViewById(R.id.order_detail_tvType);
        tvDuration = findViewById(R.id.order_detail_tvDuration);
        tvTitle = findViewById(R.id.order_detail_tvTitle);
        tvNum = findViewById(R.id.order_detail_tvNum);
        tvPay = findViewById(R.id.order_detail_tvPay);*/

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.orderDetailRecyclerView.setHasFixedSize(true);
        binding.orderDetailRecyclerView.setLayoutManager(layoutManager);
        OrderDetailAdapter adapter = new OrderDetailAdapter(getApplicationContext());
        binding.orderDetailRecyclerView.setAdapter(adapter);
        if (adapter.getItemCount() != 0) {
            binding.orderDetailTvMessage.setVisibility(View.GONE);
        } else {
            binding.orderDetailRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
