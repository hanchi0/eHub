package com.jaemion.eHub.orderdetail;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jaemion.eHub.R;

public class OrderDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView tvStatus, tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
        toolbar = findViewById(R.id.order_detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
        recyclerView = findViewById(R.id.order_detail_recyclerView);
        tvStatus = findViewById(R.id.order_detail_tvStatus);
        tvMessage = findViewById(R.id.order_detail_tvMessage);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        OrderDetailAdapter adapter = new OrderDetailAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        if (adapter.getItemCount() != 0) {
            tvStatus.setVisibility(View.GONE);
            tvMessage.setVisibility(View.GONE);
        }else{
            recyclerView.setVisibility(View.GONE);
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
