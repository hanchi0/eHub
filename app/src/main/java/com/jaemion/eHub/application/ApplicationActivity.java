package com.jaemion.eHub.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.MenuItem;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ui.ApplicationFragment_List;
import com.jaemion.eHub.databinding.ApplicationActivityBinding;

public class ApplicationActivity extends AppCompatActivity {
    ApplicationActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.application_activity);
        setToolbar("발주된 작업 목록");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.application_container, ApplicationFragment_List.newInstance())
                    .commitNow();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public TextView getToolbarTitle() {
        return binding.applicationToolbarTitle;
    }

    public void setToolbar(String title) {
        setSupportActionBar(binding.applicationToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.applicationToolbarTitle.setText(title);
    }
}
