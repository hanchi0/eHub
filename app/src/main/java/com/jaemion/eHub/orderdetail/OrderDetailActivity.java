package com.jaemion.eHub.orderdetail;

import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jaemion.eHub.R;

public class OrderDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView tvType, tvDuration, tvTitle, tvNum, tvPay, tvMessage;

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
        tvMessage = findViewById(R.id.order_detail_tvMessage);
        tvType = findViewById(R.id.order_detail_tvType);
        tvDuration = findViewById(R.id.order_detail_tvDuration);
        tvTitle = findViewById(R.id.order_detail_tvTitle);
        tvNum = findViewById(R.id.order_detail_tvNum);
        tvPay = findViewById(R.id.order_detail_tvPay);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        OrderDetailAdapter adapter = new OrderDetailAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        if (adapter.getItemCount() != 0) {
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
